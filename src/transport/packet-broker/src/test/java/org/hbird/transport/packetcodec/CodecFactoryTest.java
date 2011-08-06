package org.hbird.transport.packetcodec;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.packetcodec.codecparameters.CodecParameter;
import org.hbird.transport.packetcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.packetcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.packetcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.packetcodec.exceptions.UnknownParameterTypeException;
import org.hbird.transport.packetcodec.exceptions.UnsupportedParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodecFactoryTest {

	private static final int BIT_SIZE_11 = 11;

	/** Big endian bitset representing 11bit 133 */
	private static final BitSet BITSET_11BIT_BE_133 = new BitSet(11);

	/** Big endian bitset representing 11bit -133 */
	private static final BitSet BITSET_11BIT_BE_NEG_891 = new BitSet(11);

	private static final long TEST_LONG = 2305843397479642193l;
	private static final String TEST_LONG_STR = "0010000000000000000000000101101001100110011101000011010001010001";
	private static BitSet TEST_LONG_BITSET = new BitSet();


	@BeforeClass
	public static void setupBitSets() throws BitSetOperationException {
		BITSET_11BIT_BE_133.set(3);
		BITSET_11BIT_BE_133.set(8);
		BITSET_11BIT_BE_133.set(10);

		BITSET_11BIT_BE_NEG_891.set(0);
		BITSET_11BIT_BE_NEG_891.set(3);
		BITSET_11BIT_BE_NEG_891.set(8);
		BITSET_11BIT_BE_NEG_891.set(10);

		TEST_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_LONG_STR, true, true);
	}

	@Test
	public void testDecorateUint11() throws UnsupportedParameterTypeException, UnknownParameterTypeException,
			UnexpectedParameterTypeException {
		Parameter<Integer> parameterUint11 = new HummingbirdParameter<Integer>("TestUint11", "", "", BIT_SIZE_11,
				Endianness.BIG, Encoding.unsigned);

		CodecParameter<Integer> codecAwareParameterUint11 = IntegerCodecFactory.decorateParameterWithCodec(parameterUint11);

		Integer result = codecAwareParameterUint11.decode(BITSET_11BIT_BE_133);

		assertEquals("Result should be equal to 133", 133, result.intValue());
	}


	@Test
	public void testDecorateInt11() throws UnsupportedParameterTypeException, UnknownParameterTypeException,
			UnexpectedParameterTypeException {
		Parameter<Integer> parameterInt11 = new HummingbirdParameter<Integer>("TestInt11", "", "", BIT_SIZE_11,
				Endianness.BIG, Encoding.twosComplement);

		CodecParameter<Integer> codecAwareParameterInt11 = IntegerCodecFactory.decorateParameterWithCodec(parameterInt11);

		Integer result = codecAwareParameterInt11.decode(BITSET_11BIT_BE_133);

		assertEquals("Result should be equal to 133", 133, result.intValue());
	}

	@Test
	public void testDecorateNegativeInt11() throws UnsupportedParameterTypeException, UnknownParameterTypeException,
			UnexpectedParameterTypeException {
		Parameter<Integer> parameterInt11 = new HummingbirdParameter<Integer>("TestInt11", "", "", BIT_SIZE_11,
				Endianness.BIG, Encoding.twosComplement);

		CodecParameter<Integer> codecAwareParameterInt11 = IntegerCodecFactory.decorateParameterWithCodec(parameterInt11);

		Integer result = codecAwareParameterInt11.decode(BITSET_11BIT_BE_NEG_891);

		assertEquals("Result should be equal to -891", -891, result.intValue());
	}


	@Test
	public void testDecorateLong55() throws UnsupportedParameterTypeException, UnknownParameterTypeException,
			UnexpectedParameterTypeException {
		Parameter<Long> parameterUint11 = new HummingbirdParameter<Long>("TestLong55", "", "", 64, Endianness.BIG,
				Encoding.twosComplement);

		CodecParameter<Long> codecAwareParameterLong55 = LongCodecFactory.decorateParameterWithCodec(parameterUint11);

		Long result = codecAwareParameterLong55.decode(TEST_LONG_BITSET);

		System.out.println(result);
		assertEquals("Result should be equal to " + TEST_LONG, TEST_LONG, result.longValue());
	}
}
