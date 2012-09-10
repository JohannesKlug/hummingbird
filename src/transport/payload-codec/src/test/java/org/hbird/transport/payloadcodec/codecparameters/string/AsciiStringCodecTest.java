package org.hbird.transport.payloadcodec.codecparameters.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.base.Charsets;

@RunWith(MockitoJUnitRunner.class)
public class AsciiStringCodecTest {

	private final String TEST_STRING;
	private final byte[] TEST_STRING_BYTES;
	private final BitSet TEST_STRING_BITSET;
	private final int TEST_STRING_LENGTH;

	@Mock
	Parameter<String> mockParameter;

	public AsciiStringCodecTest() throws UnsupportedEncodingException {
		TEST_STRING = "gaben";
		TEST_STRING_BYTES = TEST_STRING.getBytes(Charsets.US_ASCII);
		TEST_STRING_LENGTH = TEST_STRING_BYTES.length * Byte.SIZE;
		TEST_STRING_BITSET = BitSetUtility.fromByteArray(TEST_STRING_BYTES);
	}


	@Ignore // Not yet implemented in AsciiStringCodecParameter
	@Test
	public void testDecodeByteArrayInt() {
		fail("Not yet implemented");
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

	@Ignore // Not yet implemented in AsciiStringCodecParameter
	@Test
	public void testEncodeToByteArray() {
		fail("Not yet implemented");
	}

	@Ignore // Not yet implemented in AsciiStringCodecParameter
	@Test
	public void testEncodeToBitSet() {
		fail("Not yet implemented");
	}

	@Ignore // Not yet implemented in AsciiStringCodecParameter
	@Test
	public void testAsciiStringCodec() {
		fail("Not yet implemented");
	}

}
