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

	/** Strand uses a Kiss frame encoder */
	private static ProtocolEncoder encoder = new KissSyncerEncoder();

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public ProtocolDecoder getDecoder(IoSession session) {
		return new KissSyncerDecoder();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtocolEncoder getEncoder(IoSession session) {
		return encoder;
	}

}
