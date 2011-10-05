package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.BitSet;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.junit.BeforeClass;
import org.junit.Test;

public class PayloadCodecTest {

	private static PayloadCodec codec;
	private static SpaceSystemModel ssm;
	
	private static long testsBurned = 0;

	private static final int SCID_VALUE_1 = 1;
	private static final String SCID_VALUE_1_AS_STRING = "0000000000000000000000000000001";
	private static final int SCID_VALUE_1073807361 = 1073807361;
	private static final String SCID_VALUE_1073807361_AS_STRING = "1000000000000010000000000000001";

	private static final int FUEL_VALUE_3814 = 3814;
	private static final String FUEL_VALUE_3814_AS_STRING = "111011100110";

	private static final long LASER_TEMP_VALUE_94528016102 = 94528016102L;
	private static final String LASER_TEMP_94528016102_AS_STRING = "0001011000000010010011110000111011100110";

	// formatter:off
	private static final int[] TEST_UINT_31_VALUES = { 0, 1, Integer.MAX_VALUE, (int) Math.pow(2, 29) + (int) Math.pow(2, 1), (int) Math.pow(2, 25),
			(int) Math.pow(2, 18), (int) Math.pow(2, 10), (int) Math.pow(2, 8) };

	private static final int[] TEST_UINT_12_VALUES = { 0, 1, (int) Math.pow(2, 12) - 1, (int) Math.pow(2, 11) - 1 + (int) Math.pow(2, 1), (int) Math.pow(2, 3),
			(int) Math.pow(2, 10) };

	private static final long[] TEST_UINT_40_VALUES = { 0, 1, (long) Math.pow(2, 40) - 1, (long) Math.pow(2, 38) - 1 + (int) Math.pow(2, 1),
			(long) Math.pow(2, 18), (long) Math.pow(2, 10) };

	// formatter:on

	@BeforeClass
	public static void setUp() throws BitSetOperationException, UnsupportedParameterEncodingException, UnknownParameterEncodingException,
			UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException {
		ssm = new MockSpaceSystemModel();
		codec = new HummingbirdPayloadCodec(ssm);
	}

	@Test
	public void testParameterGroupFromBitSet() throws Exception {
		String bitSetString = SCID_VALUE_1_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet rawIn = BitSetUtility.stringToBitSet(bitSetString, true, true);

		ParameterGroup actual = codec.decode(rawIn, null);

		Integer scid = actual.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).getValue();
		Integer fuel = actual.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).getValue();
		Long laserTemp = actual.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).getValue();

		assertEquals("SCID should have been decoded and set to " + SCID_VALUE_1, SCID_VALUE_1, scid.intValue());
		assertEquals("Fuel should have been decoded and set to " + FUEL_VALUE_3814, FUEL_VALUE_3814, fuel.intValue());
		assertEquals("laser should have been decoded and set to " + LASER_TEMP_VALUE_94528016102, LASER_TEMP_VALUE_94528016102, laserTemp.longValue());
	}

	@Test
	public void feelTheBurn() throws BitSetOperationException, UnknownParameterGroupException {
		long start = System.currentTimeMillis();
		int burnLevel = 10000;
		for (int i = 0; i < burnLevel; i++) {
			testEncode();
		}
		long end = System.currentTimeMillis();
		System.out.println("Completed " + testsBurned + " tests in " + (end - start) + " ms");
		System.out.println(testsBurned/((end-start)/1000) + " payloads encoded per second");
	}

	@Test
	public void testEncode() throws BitSetOperationException, UnknownParameterGroupException {
		for (int scIdValue : TEST_UINT_31_VALUES) {
			for (int fuelValue : TEST_UINT_12_VALUES) {
				for (long laserValue : TEST_UINT_40_VALUES) {
					String scIdBinaryString = Integer.toBinaryString(scIdValue);
					scIdBinaryString = padLeadingZeros(31, scIdBinaryString);

					String fuelBinaryString = Integer.toBinaryString(fuelValue);
					fuelBinaryString = padLeadingZeros(12, fuelBinaryString);

					String laserBinaryString = Long.toBinaryString(laserValue);
					laserBinaryString = padLeadingZeros(40, laserBinaryString);

					BitSet expected = BitSetUtility.stringToBitSet(scIdBinaryString + fuelBinaryString + laserBinaryString, true, true);
					ParameterGroup testGroup = setTestGroupParameterValues(scIdValue, fuelValue, laserValue);
					// System.out.println("Test number: " + testNumber + ". scId: " + scIdValue + ", fuel: " + fuelValue
					// + ", laser: " + laserValue );
					encodeAndAssert(testGroup, expected);
					testsBurned++;
				}
			}
		}
	}

	private String padLeadingZeros(int lengthInBits, String binaryStringIn) {
		String binaryString = String.format("%" + lengthInBits + "s", binaryStringIn);
		binaryString = binaryString.replace(' ', '0');
		return binaryString;
	}

	private void encodeAndAssert(ParameterGroup testGroup, BitSet expected) {
		BitSet actual = codec.encodeToBitSet(testGroup);
		assertEquals("Encoded BitSet should match " + expected, expected, actual);
	}

	@Test
	public void testEncodeParameterGroupBitSet() throws UnknownParameterGroupException, BitSetOperationException {
		ParameterGroup testGroup = ssm.getParameterGroup(MockSpaceSystemModel.TEST_GROUP_NAME);

		testGroup.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).setValue(SCID_VALUE_1);
		testGroup.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).setValue(FUEL_VALUE_3814);
		testGroup.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).setValue(LASER_TEMP_VALUE_94528016102);

		String bitSetString = SCID_VALUE_1_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet expected = BitSetUtility.stringToBitSet(bitSetString, true, true);

		encodeAndAssert(testGroup, expected);
	}

	private ParameterGroup setTestGroupParameterValues(int scIdValue, int fuelValue, long laserValue) throws UnknownParameterGroupException {
		ParameterGroup testGroup = ssm.getParameterGroup(MockSpaceSystemModel.TEST_GROUP_NAME);
		testGroup.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).setValue(scIdValue);
		testGroup.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).setValue(fuelValue);
		testGroup.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).setValue(laserValue);
		return testGroup;
	}

	@Test
	public void testEncodeParameterGroupBitSet2() throws UnknownParameterGroupException, BitSetOperationException {
		ParameterGroup testGroup = ssm.getParameterGroup(MockSpaceSystemModel.TEST_GROUP_NAME);

		testGroup.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).setValue(SCID_VALUE_1073807361);
		testGroup.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).setValue(FUEL_VALUE_3814);
		testGroup.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).setValue(LASER_TEMP_VALUE_94528016102);

		String bitSetString = SCID_VALUE_1073807361_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet expected = BitSetUtility.stringToBitSet(bitSetString, true, true);

		encodeAndAssert(testGroup, expected);
	}

}
