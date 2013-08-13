package org.hbird.transport.protocols.kiss;

import static org.hbird.transport.protocols.kiss.KissConstants.DATA_FRAME;
import static org.hbird.transport.protocols.kiss.KissConstants.FEND;
import static org.hbird.transport.protocols.kiss.KissConstants.FESC;
import static org.hbird.transport.protocols.kiss.KissConstants.FULL_DUPLEX;
import static org.hbird.transport.protocols.kiss.KissConstants.P;
import static org.hbird.transport.protocols.kiss.KissConstants.RETURN;
import static org.hbird.transport.protocols.kiss.KissConstants.SET_HARDWARE;
import static org.hbird.transport.protocols.kiss.KissConstants.SLOT_TIME;
import static org.hbird.transport.protocols.kiss.KissConstants.TFEND;
import static org.hbird.transport.protocols.kiss.KissConstants.TFESC;
import static org.hbird.transport.protocols.kiss.KissConstants.TX_DELAY;
import static org.hbird.transport.protocols.kiss.KissConstants.TX_TAIL;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.hbird.core.commons.util.BytesUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * See <a href="http://www.ka9q.net/papers/kiss.html">KISS standard</a>.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class KissSyncerDecoder extends CumulativeProtocolDecoder {
	private static final Logger LOG = LoggerFactory.getLogger(KissSyncerDecoder.class);

	private static final int LOW_NIBBLE_MASK = 0x0F;

	private Byte currentlyHandling = null;

	private byte[] data = ArrayUtils.EMPTY_BYTE_ARRAY;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		boolean state = true;

		if (currentlyHandling != null) {
			if (LOG.isTraceEnabled()) {
				LOG.trace("Currently handling frame type " + Integer.toHexString(currentlyHandling & 0xFF) + ", continuing with new buffer...");
			}
			// figure out which type we were handling and send IoBuffer to that method to continue handling
			return handleType(in, out, state, currentlyHandling);
		}

		byte first = in.get();

		// If we have a FEND and some data, we are ready to go
		if (first == FEND) {
			if (in.hasRemaining()) {
				byte type = in.get();

				if (type == FEND) {
					// drop second FEND as this could be a sync flush
					if (in.hasRemaining()) {
						type = in.get();
					}
					else {
						return false;
					}
				}

				// The type indicator is split across two nibbles so we need to get those first...
				// Command type is the low nibble
				byte commandType = (byte) (type & LOW_NIBBLE_MASK);

				// Port number is the high nibble
				@SuppressWarnings("unused")
				// Not implemented send to port yet
				byte port = (byte) ((type >> 4) & LOW_NIBBLE_MASK);

				currentlyHandling = commandType;
				state = handleType(in, out, state, commandType);
			}
			else {
				// Nothing left in the buffer so we'll wait.
				if (LOG.isTraceEnabled()) {
					LOG.trace("Nothing left in the buffer immediately after receiving a FEND, will wait on more data.");
				}
				state = false;
			}
		}
		return state;
	}

	private boolean handleType(IoBuffer in, ProtocolDecoderOutput out, boolean state, byte commandType) {
		boolean localState = state;
		// Now we can perform the correct logic given the type.
		switch (commandType) {
			case DATA_FRAME:
				if (LOG.isTraceEnabled()) {
					LOG.trace("Data frame detected.");
				}
				localState = handleDataFrame(in, out);
				break;
			case TX_DELAY:
				LOG.warn("Unsupported KISS command type: TX_DELAY. Ignoring frame");
				currentlyHandling = null;
				break;
			case P:
				LOG.warn("Unsupported KISS command type: \"P\". Ignoring frame");
				currentlyHandling = null;
				break;
			case SLOT_TIME:
				LOG.warn("Unsupported KISS command type: SLOT_TIME. Ignoring frame");
				currentlyHandling = null;
				break;
			case TX_TAIL:
				LOG.warn("Unsupported KISS command type: TX_TAIL. Ignoring frame");
				currentlyHandling = null;
				break;
			case FULL_DUPLEX:
				LOG.warn("Unsupported KISS command type: FULL_DUPLEX. Ignoring frame");
				currentlyHandling = null;
				break;
			case SET_HARDWARE:
				LOG.warn("Unsupported KISS command type: SET_HARDWARE. Ignoring frame");
				currentlyHandling = null;
				break;
			case RETURN:
				LOG.warn("Unsupported KISS command type: RETURN. Ignoring frame");
				currentlyHandling = null;
				break;
			default:
				localState = handleExtendedKissFrame(commandType, in, out);
				break;
		}
		return localState;
	}

	protected boolean handleExtendedKissFrame(byte commandType, IoBuffer in, ProtocolDecoderOutput out) {
		// Corruption as this handler only expects standard KISS frames. Cancel frame handling and return true to end
		// this frame.
		LOG.error("Corrupt KISS frame; unknown command type: 0x" + Integer.toHexString(commandType & 0xFF));
		currentlyHandling = null;
		return true;
	}

	/**
	 * Writes out the data portion of the frame.
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	private boolean handleDataFrame(IoBuffer in, ProtocolDecoderOutput out) {
		byte[] extractedData = extractDataFromFrame(in);
		if (extractedData == null) {
			return false;
		}

		byte[] newData = editOutData(data);
		if (newData != null) {
			out.write(newData);
		}
		else {
			out.write(data);
		}

		handleComplete();
		return true;
	}

	/**
	 * Allows a subclass to change the data that is to be written out just before it is sent.#
	 * 
	 * If the method returns null, the original data is written out.
	 * 
	 * @return
	 */
	protected byte[] editOutData(byte[] outData) {
		return null;
	}

	protected void handleComplete() {
		currentlyHandling = null;
		data = ArrayUtils.EMPTY_BYTE_ARRAY;
	}

	protected byte[] extractDataFromFrame(IoBuffer in) {
		if (!in.hasRemaining()) {
			// Nothing here! Might need more data from the OS network buffer.
			if (LOG.isTraceEnabled()) {
				LOG.trace("No data remaining in the buffer when attempting, waiting for more data...");
			}
			return null;
		}

		byte next = (byte) 0x00;
		while ((next = in.get()) != FEND) {
			if (next == FESC) {
				// escape mode active
				next = in.get();
				if (next == TFEND) {
					next = FEND;
				}
				else if (next == TFESC) {
					next = FESC;
				}
				else {
					// escaped mode error; no action is taken and frame decode continues
					LOG.warn("Unexpected byte 0x" + Integer.toHexString(next & 0xFF)
							+ " after escape in KISS TNC frame. Expected TFESC or TFEND. Ignoring escape and continuing decode.");
				}
			}
			data = ArrayUtils.add(data, next);

			// If there is no data left and we have not yet found a FEND then we need more data from the buffer
			// returning false signifies this.
			if (!in.hasRemaining()) {
				if (LOG.isTraceEnabled()) {
					LOG.trace("No remaining data and no FEND received so we probably have fragmentation in the data frame, waiting for more data...");
				}
				return null;
			}
		}

		// The next byte is now FEND so we have the full data payload and can write out the data.
		if (LOG.isDebugEnabled()) {
			LOG.debug("Received FEND so the frame is complete. Data = " + BytesUtility.hexDump(data));
		}

		return data;
	}

	public void setCurrentlyHandling(Byte currentlyHandling) {
		this.currentlyHandling = currentlyHandling;
	}
}
