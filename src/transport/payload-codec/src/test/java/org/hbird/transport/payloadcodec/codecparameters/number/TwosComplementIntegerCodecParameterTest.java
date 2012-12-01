package org.hbird.transport.payloadcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.HummingbirdParameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwosComplementIntegerCodecParameterTest {

	private TwosComplementIntegerCodecParameter codec;

	@Test
	public void testEncodeSingleByteFullRange() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "byteGaben", "", "");
		Encoding enc = new Encoding(Byte.SIZE, BinaryRepresentation.twosComplement);
		codec = new TwosComplementIntegerCodecParameter(p, enc);

		for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
			p.setValue(i);
			byte[] value = { (byte) i };
			BitSet expected = BitSetUtility.fromByteArray(value);
			encodeAndAssert(codec, expected);
		}
	}

	@Test
	public void testEncodeShortFullRange() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "shortGaben", "", "");
		Encoding enc = new Encoding(Short.SIZE, BinaryRepresentation.twosComplement);
		codec = new TwosComplementIntegerCodecParameter(p, enc);

		for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
			p.setValue(i);
			ByteBuffer buffer = ByteBuffer.allocate(2);
			buffer.putShort((short) i);
			BitSet expected = BitSetUtility.fromByteArray(buffer.array());
			encodeAndAssert(codec, expected);
		}
	}

	@Test
	public void testEncodeIntegerFullRange() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "intGaben", "", "");
		Encoding enc = new Encoding(Integer.SIZE, BinaryRepresentation.twosComplement);
		codec = new TwosComplementIntegerCodecParameter(p, enc);

		for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += 21845) {
			p.setValue((int) i);
			ByteBuffer buffer = ByteBuffer.allocate(4);
			buffer.putInt((int) i);
			BitSet expected = BitSetUtility.fromByteArray(buffer.array());
			encodeAndAssert(codec, expected);
		}
	}

	private static void encodeAndAssert(CodecParameter<Integer> codec, BitSet expected) {
		BitSet actual = new BitSet();
		codec.encodeToBitSet(actual, 0);
		assertEquals("The codec encoding result should match this bitset: " + expected, expected, actual);
	}

}
