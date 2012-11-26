package org.hbird.transport.protocols.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RawMinaEncoder implements ProtocolEncoder {
	private final static Logger LOG = LoggerFactory.getLogger(RawMinaCodec.class);

	@Override
	public void dispose(IoSession session) {
		// Do nothing.
	}

	@Override
	public void encode(IoSession iosession, Object object, ProtocolEncoderOutput out) {
		if (object instanceof byte[]) {
			byte[] inBytes = (byte[]) object;
			IoBuffer buf = IoBuffer.allocate(inBytes.length);
			buf.put(inBytes);
			buf.flip();
			out.write(buf);
		}
		else {
			LOG.warn("No byte array in input");
		}
	}
}