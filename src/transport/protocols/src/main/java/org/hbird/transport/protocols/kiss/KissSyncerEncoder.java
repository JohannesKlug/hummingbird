package org.hbird.transport.protocols.kiss;

import static org.hbird.transport.protocols.kiss.KissConstants.FEND;
import static org.hbird.transport.protocols.kiss.KissConstants.FESC;
import static org.hbird.transport.protocols.kiss.KissConstants.TFEND;
import static org.hbird.transport.protocols.kiss.KissConstants.TFESC;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KissSyncerEncoder extends ProtocolEncoderAdapter {
	private static final Logger LOG = LoggerFactory.getLogger(KissSyncerEncoder.class);

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		if (message instanceof byte[]) {
			byte[] bytesin = (byte[]) message;
			IoBuffer buffer = createBuffer(bytesin);
			out.write(buffer);
		}
		else {
			// only accepting byte arrays!
			LOG.error("Received an " + message.getClass().getName() + " but this encoder only processes byte arrays");
		}
	}

	private static IoBuffer createBuffer(byte[] bytesin) {
		IoBuffer buffer = IoBuffer.allocate(bytesin.length * 2 + 2);

		buffer.put(FEND);
		for (byte b : buffer.array()) {
			if (b == FEND) {
				buffer.put(FESC);
				buffer.put(TFEND);
			}
			else if (b == FESC) {
				buffer.put(FESC);
				buffer.put(TFESC);

			}
			else {
				buffer.put(b);
			}
		}

		buffer.put(FEND);
		buffer.shrink();

		return buffer;
	}
}
