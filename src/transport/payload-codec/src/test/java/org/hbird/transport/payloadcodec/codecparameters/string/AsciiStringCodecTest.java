package org.hbird.transport.payloadcodec.codecparameters.string;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

@RunWith(MockitoJUnitRunner.class)
public class AsciiStringCodecTest {
	private final static Logger LOG = LoggerFactory.getLogger(AsciiStringCodecTest.class);

	private final String TEST_STRING;
	private final byte[] TEST_STRING_BYTES;
	private final BitSet TEST_STRING_BITSET;
	private final int TEST_STRING_LENGTH;

	@Mock
	Parameter<String> mockParameter;

	public AsciiStringCodecTest() throws UnsupportedEncodingException {
		TEST_STRING = "gaben"; // Lord of Steam.
		TEST_STRING_BYTES = TEST_STRING.getBytes(Charsets.US_ASCII);
		TEST_STRING_LENGTH = TEST_STRING_BYTES.length * Byte.SIZE;
		TEST_STRING_BITSET = BitSetUtility.fromByteArray(TEST_STRING_BYTES);
	}

	@Test
	public void testDecodeByteArrayInt() {
		final ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

		final Encoding enc = new Encoding(TEST_STRING_LENGTH, BinaryRepresentation.ASCII);
		final AsciiStringCodecParameter codec = new AsciiStringCodecParameter(mockParameter, enc);
		codec.decode(TEST_STRING_BYTES, 0);

		verify(mockParameter).setValue(argument.capture());
		assertEquals(TEST_STRING, argument.getValue());
	}

	@Test
	public void testDecodeBitSetInt() {
		final ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

		final Encoding enc = new Encoding(TEST_STRING_LENGTH, BinaryRepresentation.ASCII);
		final AsciiStringCodecParameter codec = new AsciiStringCodecParameter(mockParameter, enc);
		codec.decode(TEST_STRING_BITSET, 0);

		verify(mockParameter).setValue(argument.capture());
		assertEquals(TEST_STRING, argument.getValue());
	}

	@Test
	public void testEncodeToByteArray() {
		final Encoding enc = new Encoding(TEST_STRING_LENGTH, BinaryRepresentation.ASCII);
		final AsciiStringCodecParameter codec = new AsciiStringCodecParameter(mockParameter, enc);

		when(mockParameter.getValue()).thenReturn("gaben");

		byte[] result = new byte[TEST_STRING_BYTES.length];
		result = codec.encodeToByteArray(result, 0);

		if(LOG.isDebugEnabled()) {
			LOG.debug("Encoding result = " + new String(result, Charsets.US_ASCII));
		}
	}

	@Test
	public void testEncodeToBitSet() {
		final Encoding enc = new Encoding(TEST_STRING_LENGTH, BinaryRepresentation.ASCII);
		final AsciiStringCodecParameter codec = new AsciiStringCodecParameter(mockParameter, enc);

		when(mockParameter.getValue()).thenReturn("gaben");

		BitSet result = new BitSet(TEST_STRING_BYTES.length * Byte.SIZE);
		result = codec.encodeToBitSet(result, 0);

		if(LOG.isDebugEnabled()) {
			LOG.debug("Encoding result = " + new String(BitSetUtility.toByteArray(result, enc.getSizeInBits()), Charsets.US_ASCII));
		}
	}
}
