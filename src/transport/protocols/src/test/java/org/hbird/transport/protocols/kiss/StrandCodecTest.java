package org.hbird.transport.protocols.kiss;

import static org.junit.Assert.assertNotNull;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.hbird.transport.protocols.kiss.KissMinaCodecFactory;
import org.junit.Test;

public class StrandCodecTest {

	private final ProtocolCodecFactory factory = new KissMinaCodecFactory();

	@Test
	public void testGetDecoder() throws Exception {
		ProtocolDecoder decoder = factory.getDecoder(null);
		assertNotNull(decoder);
	}

	@Test
	public void testGetEncoder() throws Exception {
		ProtocolEncoder encoder = factory.getEncoder(null);
		assertNotNull(encoder);
	}
}
