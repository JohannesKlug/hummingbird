package org.hbird.transport.protocols.hdlc;

import java.nio.ByteBuffer;

/**
 * Encodes an HDLC frame
 * 
 * @author Johannes Klug
 * @author Mark Doyle
 * 
 */
public class HdlcFrameEncoder {

	// TODO Add checksum support.
	private boolean useChecksum = true;

	private final byte address = 0;

	private final byte control = 0;

	public final byte[] encode(byte[] dataIn, byte address, byte control) {
		ByteBuffer out = ByteBuffer.allocate(dataIn.length + 2);
		out.put(address);
		out.put(control);
		out.put(dataIn);
		if (useChecksum) {
			byte[] checksum = calculateChecksum(address, control, dataIn);
		}
		return out.array();
	}

	private byte[] calculateChecksum(byte address2, byte control2, byte[] dataIn) {
		throw new UnsupportedOperationException("Checksum not implemented in HDLC encoder");
	}

	public final byte[] encode(byte[] dataIn) {
		return encode(dataIn, address, control);
	}

	public boolean isUseChecksum() {
		return useChecksum;
	}

	public void setUseChecksum(boolean useChecksum) {
		this.useChecksum = useChecksum;
	}
}
