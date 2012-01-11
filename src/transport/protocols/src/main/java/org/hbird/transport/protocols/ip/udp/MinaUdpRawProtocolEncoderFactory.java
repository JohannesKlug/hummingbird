package org.hbird.transport.protocols.ip.udp;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.hbird.core.commons.util.BytesUtility;
import org.hbird.transport.protocols.ip.udp.exceptions.InvalidMiniUdpException;

public class MinaUdpRawProtocolEncoderFactory implements ProtocolCodecFactory {

	@Override
	public ProtocolEncoder getEncoder() throws Exception {
		return new ProtocolEncoder() {

			@Override
			public void encode(final IoSession session, final Object message, final ProtocolEncoderOutput out) throws Exception {

				if (message instanceof byte[]) {
					byte[] rawData = (byte[]) message;
					System.out.println("Encode: " + BytesUtility.decimalDump(rawData));
					ByteBuffer buf = ByteBuffer.allocate(rawData.length);
					buf.setAutoExpand(false);
					buf.put(rawData);
					buf.flip();
					out.write(buf);
				}
				else {
					throw new InvalidMiniUdpException();
				}
			}

			@Override
			public void dispose(final IoSession session) throws Exception {
				// TODO Auto-generated method stub

			}
		};
	}

	@Override
	public ProtocolDecoder getDecoder() throws Exception {
		return new ProtocolDecoder() {

			@Override
			public void finishDecode(final IoSession session, final ProtocolDecoderOutput out) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose(final IoSession session) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void decode(final IoSession session, final ByteBuffer in, final ProtocolDecoderOutput out) throws Exception {
				// System.out.println("Decode: " + BytesUtility.decimalDump(in.array()));
				// out.write(in.array());
			}
		};
	}

}
