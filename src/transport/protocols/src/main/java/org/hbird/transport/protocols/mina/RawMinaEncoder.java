package org.hbird.transport.protocols.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RawMinaEncoder implements ProtocolEncoder {
	private static final Logger LOG = LoggerFactory.getLogger(RawMinaCodec.class);

	@Override
	public void dispose(IoSession session) {
		// Do nothing.
	}

	@Override
	public void encode(IoSession iosession, Object object, ProtocolEncoderOutput out) {
		if (object instanceof byte[]) {
			out.write(IoBuffer.wrap((byte[]) object));
		}
		else {
			LOG.warn("No byte array in input! Got a " + object.getClass().getName());
		}
	}
}