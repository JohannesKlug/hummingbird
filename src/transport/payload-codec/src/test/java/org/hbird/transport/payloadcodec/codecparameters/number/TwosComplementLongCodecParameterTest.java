package org.hbird.transport.payloadcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwosComplementLongCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameterTest.class);

	private static CodecParameter<Long> codec;

	private static final long TEST_LONG = 2305843397479642193l;
	private static final String TEST_LONG_STR_BE = "0010000000000000000000000101101001100110011101000011010001010001";
	private static BitSet TEST_LONG_BITSET_BE;

	private static final String TEST_MAX_LONG_STR = "0111111111111111111111111111111111111111111111111111111111111111";
	private static BitSet TEST_MAX_LONG_BITSET;
	private static final String TEST_MIN_LONG_STR = "1000000000000000000000000000000000000000000000000000000000000000";
	private static BitSet TEST_MIN_LONG_BITSET;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.info("--------- Setup -------------------------");
		TEST_LONG_BITSET_BE = BitSetUtility.stringToBitSet(TEST_LONG_STR_BE, true, true);
		System.out.println(BitSetUtility.binDump(TEST_LONG_BITSET_BE));
		TEST_MAX_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MAX_LONG_STR, true, true);
		TEST_MIN_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MIN_LONG_STR, true, true);
		LOG.info("-----------------------------------------------");
	}

	@Before
	public void setUp() throws Exception {
		Parameter<Long> parameterBigEndian = new HummingbirdParameter<Long>("test.beLongParameter", "beLongParaemter", "", "");
		Encoding enc = new Encoding(64, BinaryRepresentation.twosComplement);

		parameterBigEndian.setValue(TEST_LONG);
		codec = new TwosComplementLongCodecParameter(parameterBigEndian, enc);
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testValueFromBitSet() {
		codec.decode(TEST_LONG_BITSET_BE, 0);
		assertEquals(TEST_LONG, codec.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testMaxValueDecodeBitSet() {
		codec.decode(TEST_MAX_LONG_BITSET, 0);
		assertEquals(Long.MAX_VALUE, codec.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testMinValueDecodeBitSet() {
		codec.decode(TEST_MIN_LONG_BITSET, 0);
		assertEquals(Long.MIN_VALUE, codec.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testEncodetoBitSet() throws BitSetOperationException {
		codec.setValue(TEST_LONG);
		BitSet actual = new BitSet();
		codec.encodeToBitSet(actual, 0);

		assertEquals(actual, TEST_LONG_BITSET_BE);
	}

}
