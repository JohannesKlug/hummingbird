package org.hbird.transport.protocols.hdlc;

import java.nio.ByteBuffer;

import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.commons.util.crc.CRC16CCITT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decodes an HDLC frame and returns the HDLC information section. Essentially, this is the packet or payload of the
 * frame.
 * 
 * @author Mark Doyle
 * 
 */
public class HdlcFrameDecoder {
	private static final Logger LOG = LoggerFactory.getLogger(HdlcFrameDecoder.class);

	public static enum FCS {
		CRC_CCITT, CRC_32
	};

	/** Whether the frame decoder should expect a checksum and calculate the validity of the frame. */
	private boolean useChecksum = true;

	private final FCS fcs = FCS.CRC_CCITT;

	// Not implemented yet
	@SuppressWarnings("unused")
	private byte address = 0;

	// Not implemented yet
	@SuppressWarnings("unused")
	private byte control = 0;

	/**
	 * Decodes a byte array as an HDLC frame.
	 * 
	 * @param dataIn
	 * @return raw decoded HDLC information byte array, that is, the packet in the HDLC frame.
	 */
	public final byte[] decode(byte[] dataIn) {
		ByteBuffer in = ByteBuffer.wrap(dataIn);

		// TODO Address and Control still to be implemented.
		address = in.get();
		control = in.get();

		if (useChecksum) {
			boolean corrupt = true;
			// TODO get checksum here and do calculations
			switch (fcs) {
				case CRC_CCITT:
					short crcCcitt = in.getShort();
					CRC16CCITT crc = new CRC16CCITT();
					crc.update(crcCcitt);
					if (crc.getValue() == crcCcitt) {
						corrupt = false;
					}
					break;
				case CRC_32:
					int crc32 = in.getInt();
					break;
				default:
					break;
			}

			if (corrupt) {
				LOG.error("CRC failure");
				return null;
			}
		}

		byte[] hdlcInformation = new byte[in.remaining()];
		in.get(hdlcInformation);

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
}
