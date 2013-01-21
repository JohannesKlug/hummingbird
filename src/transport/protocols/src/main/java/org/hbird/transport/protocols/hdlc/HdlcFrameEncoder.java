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
	
	private byte address = 0;

	private byte control = 0;

	public final byte[] encode(byte[] dataIn, byte address, byte control) {
		ByteBuffer out = ByteBuffer.allocate(dataIn.length + 2);
		out.put(address);
		out.put(control);
		out.put(dataIn);
		return out.array();
	}
	
	public final byte[] encode (byte[] dataIn){
		return encode(dataIn, address, control);
	}
	
}
