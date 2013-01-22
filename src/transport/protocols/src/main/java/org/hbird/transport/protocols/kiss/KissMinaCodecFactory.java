package org.hbird.transport.protocols.kiss;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 
 * Provides mina codecs for KISS frames.
 * 
 * 
 * @see ProtocolCodecFactory
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * @author Christopher Bridges
 * 
 */
public class KissMinaCodecFactory implements ProtocolCodecFactory {

	/** Strand uses a Kiss frame decoder as the first line codec */
	private static ProtocolDecoder decoder = new KissSyncerDecoder();

	/** Strand uses a Kiss frame encoder */
	private static ProtocolEncoder encoder = new KissSyncerEncoder();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtocolDecoder getDecoder(IoSession session) {
		return decoder;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtocolEncoder getEncoder(IoSession session) {
		return encoder;
	}

}
