package org.hbird.transport.protocols.kiss;

import static org.hbird.transport.protocols.kiss.KissConstants.DATA_FRAME;
import static org.hbird.transport.protocols.kiss.KissConstants.FEND;
import static org.hbird.transport.protocols.kiss.KissConstants.FESC;
import static org.hbird.transport.protocols.kiss.KissConstants.TFEND;
import static org.hbird.transport.protocols.kiss.KissConstants.TFESC;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.TransportMetadata;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KissFrameEncoderTest {

	private final ProtocolEncoderAdapter encoder = new KissSyncerEncoder();

	@Mock
	private ProtocolEncoderOutput mockOut;

	@Mock
	private IoSession mockSession;

	@Mock
	private TransportMetadata mockTransportMetadata;

	@Before
	public void setUp() throws Exception {
		when(mockSession.getTransportMetadata()).thenReturn(mockTransportMetadata);
		when(mockTransportMetadata.hasFragmentation()).thenReturn(false);
	}

	@Test
	public void testKissFrameEncode() throws Exception {
		byte[] testInput = new byte[] { 0x08, 0x1F };
		byte[] expectedOutput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FEND };

		encoder.encode(mockSession, testInput, mockOut);

		verify(mockOut).write(IoBuffer.wrap(expectedOutput));
	}

	@Test
	public void testKissFrameEncodeEscapedFendValidFrame() throws Exception {
		byte[] testInput = new byte[] { 0x08, 0x1F, (byte) 0xC0, 0x08 };
		byte[] expectedOutput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FESC, TFEND, 0x08, FEND };

		encoder.encode(mockSession, testInput, mockOut);

		verify(mockOut).write(IoBuffer.wrap(expectedOutput));
	}

	@Test
	public void testKissFrameEncodeEscapedEscapeValidFrame() throws Exception {
		byte[] testInput = new byte[] { 0x08, 0x1F, (byte) 0xDB, 0x08 };
		byte[] expectedOutput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FESC, TFESC, 0x08, FEND };

		encoder.encode(mockSession, testInput, mockOut);

		verify(mockOut).write(IoBuffer.wrap(expectedOutput));
	}

}
