package org.hbird.transport.protocols.mina;

import static org.junit.Assert.*;

import org.hbird.transport.protocols.mina.RawMinaCodec;
import org.junit.Test;

public class MinaProtocolEncoderTest {

	@Test
	public void test() {
		RawMinaCodec customCodec = new RawMinaCodec();
		
		assertTrue(org.apache.mina.filter.codec.ProtocolCodecFactory.class.isAssignableFrom(customCodec.getClass()));
		
	}

}
