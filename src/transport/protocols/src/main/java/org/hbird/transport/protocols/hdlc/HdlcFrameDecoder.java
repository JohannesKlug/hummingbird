package org.hbird.transport.protocols.hdlc;

import java.nio.ByteBuffer;

import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.commons.util.crc.CRC16CCITT;
import org.hbird.transport.protocols.hdlc.exceptions.CrcFailureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decodes an HDLC frame and returns the HDLC information section.
 * 
 * <p>
 * <a href="http://en.wikipedia.org/wiki/High-Level_Data_Link_Control">HDLC</a>
 * </p>
 * 
 * @author Mark Doyle
 * 
 */
public class HdlcFrameDecoder {
	private static final int SHORT_SIZE_BYTES = Short.SIZE / Byte.SIZE;

	private static final Logger LOG = LoggerFactory.getLogger(HdlcFrameDecoder.class);

	public static enum FCS {
		CRC_CCITT, CRC_32
	};

	/** Whether the frame decoder should expect a checksum and calculate the validity of the frame. */
	private boolean useChecksum = true;

	private final FCS fcs = FCS.CRC_CCITT;

	private byte address = 0;

	private byte control = 0;

	private boolean useAddressAndControl = true;

	/**
	 * Perform any calculations on a read only version of the byteBuffer before decoding takes place.
	 * By default nothing is carried out, but users using a customised version of HDLC can extend this class and
	 * implement the method.
	 * 
	 * @param in
	 */
	protected void predecode(ByteBuffer in) {
		// Do nothing by default
	}

	/**
	 * Decodes a byte array as an HDLC frame.
	 * 
	 * @param dataIn
	 * @return raw decoded HDLC information byte array, that is, the packet in the HDLC frame.
	 * @throws CrcFailureException
	 */
	public final byte[] decode(byte[] dataIn) throws CrcFailureException {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Decoding " + BytesUtility.hexDump(dataIn));
		}

		ByteBuffer in = ByteBuffer.wrap(dataIn);

		if (!in.hasRemaining()) {
			// TODO handle this better?
			LOG.warn("Empty Byte buffer passed to the HDLC decoder, will ignore this and return an empty byte array.");
			return new byte[0];
		}

		predecode(in.asReadOnlyBuffer());

		if (useAddressAndControl) {
			// TODO Address and Control still to be implemented.
			address = in.get();
			control = in.get();
		}

		byte[] hdlcInformation = null;

		if (useChecksum) {
			int infoSize;
			switch (fcs) {
				case CRC_CCITT:
					infoSize = in.remaining() - SHORT_SIZE_BYTES;
					hdlcInformation = new byte[infoSize];
					in.get(hdlcInformation);
					long crcCcitt = in.getShort() & 0xFFFF;
					CRC16CCITT crc = new CRC16CCITT();
					byte[] crcData = ByteBuffer.allocate(1 + 1 + infoSize).put(address).put(control).put(hdlcInformation).array();
					crc.update(crcData, 0, crcData.length);
					if (crc.getValue() != crcCcitt) {
						throw new CrcFailureException("HLDC Frame CRC check failed. CRC = " + crcCcitt + ". CRC calculation value = " + crc.getValue());
					}
					break;
				case CRC_32:
					throw new UnsupportedOperationException("CRC_32 not yet implemented, file an issue");
				default:
					break;
			}
		}
		else {
			hdlcInformation = new byte[in.remaining()];
			in.get(hdlcInformation);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("HDLC information = " + BytesUtility.hexDump(hdlcInformation));
		}

		return hdlcInformation;
	}

	/**
	 * Getter for {@link HdlcFrameDecoder#useChecksum}
	 * 
	 * @return {@link HdlcFrameDecoder#useChecksum}
	 */
	public boolean isUseChecksum() {
		return useChecksum;
	}

	/**
	 * Setter for {@link HdlcFrameDecoder#useChecksum}
	 * 
	 * @param boolean to set {@link HdlcFrameDecoder#useChecksum}
	 */
	public void setUseChecksum(boolean useChecksum) {
		this.useChecksum = useChecksum;
	}

	public boolean isUseAddressAndControl() {
		return useAddressAndControl;
	}

	public void setUseAddressAndControl(boolean useAddressAndControl) {
		this.useAddressAndControl = useAddressAndControl;
	}

}
