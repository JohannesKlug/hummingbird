package org.hbird.transport.protocols.ip.udp;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class RawMinaCodec implements ProtocolCodecFactory {

	private static ProtocolEncoder encoder = new RawMinaEncoder();
	private static ProtocolDecoder decoder = new RawMinaDecoder();

	@Override
	public ProtocolDecoder getDecoder(org.apache.mina.core.session.IoSession arg0) throws Exception {
		return RawMinaCodec.decoder;

	}

	@Override
	public ProtocolEncoder getEncoder(org.apache.mina.core.session.IoSession arg0) throws Exception {
		return RawMinaCodec.encoder;
	}

}
