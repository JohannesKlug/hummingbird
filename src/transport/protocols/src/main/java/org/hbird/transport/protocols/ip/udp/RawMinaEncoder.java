package org.hbird.transport.protocols.ip.udp;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

final class RawMinaEncoder implements ProtocolEncoder {

	@Override
	public void dispose(IoSession arg0) {
		System.out.println("Encoder.dispose");

	}

	@Override
	public void encode(IoSession iosession, Object object, ProtocolEncoderOutput out) {
		System.out.println("Encoder.encode");
		if (object instanceof byte[]) {
			System.out.println("Byte array in input!");
			byte[] inBytes = (byte[]) object;
			IoBuffer buf = IoBuffer.allocate(inBytes.length);
			buf.put(inBytes);
			buf.flip();
			out.write(buf);
		}
		else {
			System.out.println("No byte array in input");
		}
	}
}