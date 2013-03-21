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
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KissFrameDecoderTest {

	private final CumulativeProtocolDecoder decoder = new KissSyncerDecoder();

	@Mock
	private ProtocolDecoderOutput mockOut;

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
	public void testKissFrameDecode() throws Exception {
		byte[] testInput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeRubbishEitherSide() throws Exception {
		byte[] testInput = new byte[] { 0x45, 0x10, FEND, DATA_FRAME, 0x08, 0x1F, FEND, 0x0F };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeDoubleFendAtStart() throws Exception {
		byte[] testInput = new byte[] { FEND, FEND, DATA_FRAME, 0x08, 0x1F, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeDoubleFendWithRubbish() throws Exception {
		byte[] testInput = new byte[] { 0x45, FEND, FEND, DATA_FRAME, 0x08, 0x1F, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeEscapedFendValidFrame() throws Exception {
		byte[] testInput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FESC, TFEND, 0x08, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F, (byte) 0xC0, 0x08 };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeEscapedEscapeValidFrame() throws Exception {
		byte[] testInput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FESC, TFESC, 0x08, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F, (byte) 0xDB, 0x08 };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeEscapedEscapeNoisyFrame() throws Exception {
		byte[] testInput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FESC, 0x08, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F, 0x08 };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeEscapedFendNoisyFrame() throws Exception {
		byte[] testInput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, FESC, (byte) 0xFF, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F, (byte) 0xFF };

		decoder.decode(mockSession, IoBuffer.wrap(testInput), mockOut);

		verify(mockOut).write(expectedOutput);
	}

	@Test
	public void testKissFrameDecodeBackToBackFrames() throws Exception {
		byte[] testInput = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F, (byte) 0xFF, FEND, FEND, DATA_FRAME, 0x08, 0x1F, (byte) 0x33, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F, (byte) 0xFF };
		byte[] expectedOutput2 = new byte[] { 0x08, 0x1F, (byte) 0x33 };

		IoBuffer wrappedInput = IoBuffer.wrap(testInput);

		decoder.decode(mockSession, wrappedInput, mockOut);
		verify(mockOut).write(expectedOutput);

		decoder.decode(mockSession, wrappedInput, mockOut);
		verify(mockOut).write(expectedOutput2);
	}

	@Test
	public void testKissFrameDecodeSplitFrame() throws Exception {
		byte[] testInputPart1 = new byte[] { FEND, DATA_FRAME, 0x08, 0x1F };
		byte[] testInputPart2 = new byte[] { 0x0F, 0x54, FEND };
		byte[] expectedOutput = new byte[] { 0x08, 0x1F, 0x0F, 0x54 };

		decoder.decode(mockSession, IoBuffer.wrap(testInputPart1), mockOut);
		decoder.decode(mockSession, IoBuffer.wrap(testInputPart2), mockOut);

		verify(mockOut).write(expectedOutput);
	}
}
