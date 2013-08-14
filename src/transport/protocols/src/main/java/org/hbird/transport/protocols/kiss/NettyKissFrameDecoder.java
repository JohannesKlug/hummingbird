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
import org.hbird.core.commons.util.BytesUtility;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Flexible KISS frame decoder for the Netty-io framework
 * 
 * @author Mark Doyle
 * 
 */
public class NettyKissFrameDecoder extends FrameDecoder {
	private static final Logger LOG = LoggerFactory.getLogger(NettyKissFrameDecoder.class);

	private static final int LOW_NIBBLE_MASK = 0x0F;

	private Byte currentlyHandling = null;

	private byte[] data = ArrayUtils.EMPTY_BYTE_ARRAY;

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer in) throws Exception {
		if (in.readableBytes() <= 0) {
			return null;
		}

		if (currentlyHandling != null) {
			if (LOG.isTraceEnabled()) {
				LOG.trace("Currently handling frame type " + Integer.toHexString(currentlyHandling & 0xFF) + ", continuing with new buffer...");
			}
			// figure out which type we were handling
			Object result = handleType(in, currentlyHandling);
			if (result != null) {
				frameHandlingComplete();
			}
			return result;
		}

		byte first = in.readByte();

		// If we have a FEND and some data, we are ready to go
		if (first == FEND) {
			if (in.readable()) {
				byte type = skipFlushFends(in);

				// The type indicator is split across two nibbles so we need to get those first...
				// Command type is the low nibble
				byte commandType = (byte) (type & LOW_NIBBLE_MASK);

				// Port number is the high nibble
				@SuppressWarnings("unused")
				// Not implemented send to port yet
				byte port = (byte) ((type >> 4) & LOW_NIBBLE_MASK);

				currentlyHandling = commandType;
				Object result = handleType(in, commandType);
				if (result != null) {
					frameHandlingComplete();
				}
				return result;
			}
			// Nothing left in the buffer so we'll wait.
			if (LOG.isTraceEnabled()) {
				LOG.trace("Nothing left in the buffer immediately after receiving a FEND, will wait on more data.");
			}
			return null;
		}

		return null;
	}

	/**
	 * Skips over any FEND bytes returning the first non-FEND byte found.
	 * 
	 * @param in
	 * @return
	 */
	private static byte skipFlushFends(ChannelBuffer in) {
		byte fendOrType;
		while (((fendOrType = in.readByte()) == FEND)) {
			// Keep looping
		}
		return fendOrType;
	}

	private Object handleType(ChannelBuffer in, Byte commandType) {
		// Now we can perform the correct logic given the type.
		switch (commandType) {
			case DATA_FRAME:
				if (LOG.isTraceEnabled()) {
					LOG.trace("Data frame detected.");
				}
				return handleDataFrame(in);
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
				return handleExtendedKissFrame(commandType, in);
		}
		return null;
	}

	private Object handleDataFrame(ChannelBuffer in) {
		byte[] frame = extractDataFromFrame(in);

		if (frame == null) {
			return null;
		}

		byte[] newData = editOutData(frame);
		if (newData != null) {
			return newData;
		}

		return frame;
	}

	/**
	 * 
	 * Allows a subclass to change the data that is to be written out just before it is sent.#
	 * 
	 * If the method returns null, the original data is written out.
	 * 
	 * @return
	 * 
	 * @param frame
	 * @return
	 */
	protected byte[] editOutData(byte[] frame) {
		return null;
	}

	protected byte[] extractDataFromFrame(ChannelBuffer in) {
		if (!in.readable()) {
			// Nothing here! Might need more data from the OS network buffer.
			if (LOG.isTraceEnabled()) {
				LOG.trace("No data remaining in the buffer when attempting, waiting for more data...");
			}
			return null;
		}

		byte next = (byte) 0x00;
		while ((next = in.readByte()) != FEND) {
			if (next == FESC) {
				// escape mode active
				next = in.readByte();
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
			if (!in.readable()) {
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

	protected final void frameHandlingComplete() {
		data = ArrayUtils.EMPTY_BYTE_ARRAY;
		currentlyHandling = null;
	}

	protected Object handleExtendedKissFrame(byte commandType, ChannelBuffer in) {
		// Corruption as this handler only expects standard KISS frames. Cancel frame handling and return true to end
		// this frame.
		LOG.error("Corrupt KISS frame; unknown command type: 0x" + Integer.toHexString(commandType & 0xFF));
		return null;
	}

	protected void setCurrentlyHandling(byte currentlyHandling) {
		this.currentlyHandling = currentlyHandling;
	}

}
