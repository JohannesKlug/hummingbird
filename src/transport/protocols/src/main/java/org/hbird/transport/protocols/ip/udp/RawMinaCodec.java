package org.hbird.transport.protocols.ip.udp;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class RawMinaCodec implements ProtocolCodecFactory {

	@Override
	public ProtocolDecoder getDecoder(org.apache.mina.core.session.IoSession arg0) throws Exception {
		return new RawMinaDecoder();

	}

	@Override
	public ProtocolEncoder getEncoder(org.apache.mina.core.session.IoSession arg0) throws Exception {
		return new ProtocolEncoder() {

			@Override
			public void dispose(org.apache.mina.core.session.IoSession arg0) throws Exception {
				System.out.println("Encoder.dispose");
				
			}

			@Override
			public void encode(org.apache.mina.core.session.IoSession iosession, Object object, ProtocolEncoderOutput out) throws Exception {
				System.out.println("Encoder.encode");
				if (object instanceof byte[]) {
					System.out.println("Byte array in input!");
					out.write(object);
				} else {
					System.out.println("No byte array in input");
				}
			}
		};
	}

}
