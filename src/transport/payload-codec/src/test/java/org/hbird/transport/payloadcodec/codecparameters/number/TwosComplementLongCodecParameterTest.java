package org.hbird.transport.payloadcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.codecparameters.number.TwosComplementLongCodecParameter;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwosComplementLongCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameterTest.class);
	
	private static CodecParameter<Long> codecParameter;
	
	private static final long TEST_LONG = 2305843397479642193l;
	private static final String TEST_LONG_STR = "0010000000000000000000000101101001100110011101000011010001010001";
	private static BitSet TEST_LONG_BITSET;
	
	private static final String TEST_MAX_LONG_STR = "0111111111111111111111111111111111111111111111111111111111111111";
	private static BitSet TEST_MAX_LONG_BITSET;
	private static final String TEST_MIN_LONG_STR = "1000000000000000000000000000000000000000000000000000000000000000";
	private static BitSet TEST_MIN_LONG_BITSET;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.info("--------- Setup stuff -------------------------");
		TEST_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_LONG_STR, true, true);
		TEST_MAX_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MAX_LONG_STR, true, true);
		TEST_MIN_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MIN_LONG_STR, true, true);
		LOG.info("-----------------------------------------------");
	}

	@Before
	public void setUp() throws Exception {
		Parameter<Long> parameter = new HummingbirdParameter<Long>("", "", "", 64, Endianness.BIG, Encoding.twosComplement);
		parameter.setValue(TEST_LONG);
		codecParameter = new TwosComplementLongCodecParameter(parameter);
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testValueFromBitSet() {
		codecParameter.decode(TEST_LONG_BITSET, 0);
		assertEquals(TEST_LONG, codecParameter.getValue().longValue());
	}
	
	@SuppressWarnings("static-method")
	@Test
	public final void testMaxValueFromBitSet() {
		codecParameter.decode(TEST_MAX_LONG_BITSET, 0);
		assertEquals(Long.MAX_VALUE, codecParameter.getValue().longValue());
	}
	
	@SuppressWarnings("static-method")
	@Test
	public final void testMinValueFromBitSet() {
		codecParameter.decode(TEST_MIN_LONG_BITSET, 0);
		assertEquals(Long.MIN_VALUE, codecParameter.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testInsertIntoBitSet() throws BitSetOperationException {
		codecParameter.setValue(TEST_LONG);
		BitSet actual = new BitSet();
		codecParameter.encodeToBitSet(actual, 0);
		assertEquals(TEST_LONG, codecParameter.getValue().longValue());
	}

}
