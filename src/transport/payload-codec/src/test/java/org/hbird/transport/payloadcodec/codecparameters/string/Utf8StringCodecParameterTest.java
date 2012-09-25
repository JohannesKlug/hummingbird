package org.hbird.transport.payloadcodec.codecparameters.string;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

@RunWith(MockitoJUnitRunner.class)
public class Utf8StringCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(Utf8StringCodecParameterTest.class);

	private final String TEST_STRING;
	private final byte[] TEST_STRING_BYTES;
	private final BitSet TEST_STRING_BITSET;
	private final int TEST_STRING_LENGTH;

	@Mock
	Parameter<String> mockParameter;

	public Utf8StringCodecParameterTest() {
		TEST_STRING = "gaben"; // Lord of Steam.
		TEST_STRING_BYTES = TEST_STRING.getBytes(Charsets.UTF_8);
		TEST_STRING_LENGTH = TEST_STRING_BYTES.length * Byte.SIZE;
		TEST_STRING_BITSET = BitSetUtility.fromByteArray(TEST_STRING_BYTES);
	}

	@Test
	public void testEncodeToByteArray() {
		final Encoding enc = new Encoding(TEST_STRING_LENGTH, BinaryRepresentation.UTF8);
		final Uft8StringCodecParameter codec = new Uft8StringCodecParameter(mockParameter, enc);

		when(mockParameter.getValue()).thenReturn("gaben");

		byte[] result = new byte[TEST_STRING_BYTES.length];
		result = codec.encodeToByteArray(result, 0);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Encoding result = " + new String(result, Charsets.UTF_8));
		}

		assertArrayEquals(TEST_STRING_BYTES, result);
	}

}
