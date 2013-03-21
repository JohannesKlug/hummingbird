package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.BitSet;
import java.util.Collection;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.exceptions.BitSetOperationException;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.tmtc.provided.HummingbirdParameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.testsupport.MockSpaceSystemModel;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayloadCodecTest {
	private final static Logger LOG = LoggerFactory.getLogger(PayloadCodecTest.class);

	private static PayloadCodec codec;

	private static SpaceSystemModel ssm;

	private static final int SCID_VALUE_1 = 1;

	private static final String SCID_VALUE_1_AS_STRING = "0000000000000000000000000000001";

	private static final int SCID_VALUE_1073807361 = 1073807361;

	private static final String SCID_VALUE_1073807361_AS_STRING = "1000000000000010000000000000001";

	private static final int FUEL_VALUE_3814 = 3814;

	private static final String FUEL_VALUE_3814_AS_STRING = "111011100110";

	private static final long LASER_TEMP_VALUE_94528016102 = 94528016102L;

	private static final String LASER_TEMP_94528016102_AS_STRING = "0001011000000010010011110000111011100110";

	// @formatter:off
	private static final int[] TEST_UINT_31_VALUES = { 0,
													   1,
													   Integer.MAX_VALUE,
													   (int) Math.pow(2, 29) + (int) Math.pow(2, 1),
													   (int) Math.pow(2, 25),
													   (int) Math.pow(2, 18),
													   (int) Math.pow(2, 10),
													   (int) Math.pow(2, 8)};

	private static final int[] TEST_UINT_12_VALUES = { 0,
													   1,
													   (int) Math.pow(2, 12) - 1,
													   (int) Math.pow(2, 11) - 1 + (int) Math.pow(2, 1),
													   (int) Math.pow(2, 3),
													   (int) Math.pow(2, 10)};

	private static final long[] TEST_UINT_40_VALUES = { 0,
														1,
														(long) Math.pow(2, 40) - 1,
														(long) Math.pow(2, 38) - 1 + (int) Math.pow(2, 1),
														(long) Math.pow(2, 18),
														(long) Math.pow(2, 10)};

	// @formatter:on

	private static final long TIMESTAMP = 5478;

	@BeforeClass
	public static void setUp() {
		ssm = new MockSpaceSystemModel();
		codec = new InMemoryPayloadCodec(ssm.getParameterGroups(), null, ssm.getEncodings(), ssm.getAllPayloadRestrictions());
	}

	@Test
	public void testDecodeBitSet() throws Exception {
		String bitSetString = SCID_VALUE_1_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet rawIn = BitSetUtility.stringToBitSet(bitSetString, true, true);

		ParameterGroup actual = codec.decode(rawIn, MockSpaceSystemModel.INTEGER_RESTRICTION_ID_LIST, 0);

		// Check the return is a plain parameter, i.e., not a decorated CodecParameter but just the HummingbirdParameter
		// used as an exchange type.
		Collection<Parameter<?>> decodedParameters = actual.getAllParameters().values();
		for (Parameter<?> p : decodedParameters) {
			assertFalse("Return Parameter " + p.getName() + " should not be an instance of CodecParameter<?>, i.e., not decorated",
					(p instanceof CodecParameter<?>));
			assertTrue("Return Parameter " + p.getName()
					+ " should be an instance of HummingbirdParameter<?> (for this test, i.e., using Hummingbird default implementations of Parameter<?>",
					(p instanceof HummingbirdParameter<?>));
		}

		// Now check the values have been decoded.
		Integer scid = actual.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_QUALIFIED_NAME).getValue();
		Integer fuel = actual.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_QUALIFIED_NAME).getValue();
		Long laserTemp = actual.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_QUALIFIED_NAME).getValue();

		assertEquals("SCID should have been decoded and set to " + SCID_VALUE_1, SCID_VALUE_1, scid.intValue());
		assertEquals("Fuel should have been decoded and set to " + FUEL_VALUE_3814, FUEL_VALUE_3814, fuel.intValue());
		assertEquals("laser should have been decoded and set to " + LASER_TEMP_VALUE_94528016102, LASER_TEMP_VALUE_94528016102, laserTemp.longValue());

	}

	@Test
	public void feelTheBurn() throws BitSetOperationException, UnknownParameterGroupException, UnknownParameterException {
		int burnLevel = 500;
		for (int i = 0; i < burnLevel; i++) {
			testEncode();
		}
	}

	@Test
	public void testEncode() throws BitSetOperationException, UnknownParameterGroupException, UnknownParameterException {
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
					encodeAndAssert(testGroup, expected);
				}
			}
		}
	}

	private static String padLeadingZeros(final int lengthInBits, final String binaryStringIn) {
		String binaryString = String.format("%" + lengthInBits + "s", binaryStringIn);
		binaryString = binaryString.replace(' ', '0');
		return binaryString;
	}

	private static void encodeAndAssert(final ParameterGroup testGroup, final BitSet expected) {
		GenericPayload actualGenericPayload = codec.encodeToGenericPayload(testGroup);
		BitSet actual = BitSetUtility.fromByteArray(actualGenericPayload.payload);
		// assertArrayEquals(expectedBytes, actualGenericPayload.payload);
		assertEquals("Encoded BitSet should match " + expected, expected, actual);
	}

	@Test
	public void testEncodeParameterGroupBitSet() throws UnknownParameterGroupException, UnknownParameterException, BitSetOperationException {
		ParameterGroup testGroup = ssm.getParameterGroup(MockSpaceSystemModel.TEST_GROUP_QUALIFIED_NAME);

		testGroup.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_QUALIFIED_NAME).setValue(SCID_VALUE_1);
		testGroup.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_QUALIFIED_NAME).setValue(FUEL_VALUE_3814);
		testGroup.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_QUALIFIED_NAME).setValue(LASER_TEMP_VALUE_94528016102);

		String bitSetString = SCID_VALUE_1_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet expected = BitSetUtility.stringToBitSet(bitSetString, true, true);

		encodeAndAssert(testGroup, expected);
	}

	private static ParameterGroup setTestGroupParameterValues(final int scIdValue, final int fuelValue, final long laserValue)
			throws UnknownParameterGroupException, UnknownParameterException {
		ParameterGroup testGroup = ssm.getParameterGroup(MockSpaceSystemModel.TEST_GROUP_QUALIFIED_NAME);
		testGroup.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_QUALIFIED_NAME).setValue(scIdValue);
		testGroup.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_QUALIFIED_NAME).setValue(fuelValue);
		testGroup.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_QUALIFIED_NAME).setValue(laserValue);
		LOG.debug("Set test parameter values to: " + scIdValue + " :: " + fuelValue + " :: " + laserValue);
		return testGroup;
	}

	@Test
	public void testEncodeParameterGroupBitSet2() throws UnknownParameterGroupException, BitSetOperationException, UnknownParameterException {
		ParameterGroup testGroup = ssm.getParameterGroup(MockSpaceSystemModel.TEST_GROUP_QUALIFIED_NAME);

		testGroup.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_QUALIFIED_NAME).setValue(SCID_VALUE_1073807361);
		testGroup.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_QUALIFIED_NAME).setValue(FUEL_VALUE_3814);
		testGroup.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_QUALIFIED_NAME).setValue(LASER_TEMP_VALUE_94528016102);

		String bitSetString = SCID_VALUE_1073807361_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet expected = BitSetUtility.stringToBitSet(bitSetString, true, true);

		encodeAndAssert(testGroup, expected);
	}

	@Test
	public void testDecodeWithRestriction() throws BitSetOperationException, UnknownParameterGroupException, UnknownParameterException {

		String bitSetString = SCID_VALUE_1_AS_STRING + FUEL_VALUE_3814_AS_STRING + LASER_TEMP_94528016102_AS_STRING;
		BitSet rawIn = BitSetUtility.stringToBitSet(bitSetString, true, true);

		ParameterGroup actual = codec.decode(rawIn, MockSpaceSystemModel.INTEGER_RESTRICTION_ID_LIST, TIMESTAMP);

		assertNotNull(actual);

		// Now check the values have been decoded.
		Integer scid = actual.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_QUALIFIED_NAME).getValue();
		Integer fuel = actual.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_QUALIFIED_NAME).getValue();
		Long laserTemp = actual.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_QUALIFIED_NAME).getValue();

		assertEquals("Timestamps should match", TIMESTAMP, actual.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_QUALIFIED_NAME).getReceivedTime());
		assertEquals("Timestamps should match", TIMESTAMP, actual.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_QUALIFIED_NAME).getReceivedTime());
		assertEquals("Timestamps should match", TIMESTAMP, actual.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_QUALIFIED_NAME).getReceivedTime());

		assertEquals("SCID should have been decoded and set to " + SCID_VALUE_1, SCID_VALUE_1, scid.intValue());
		assertEquals("Fuel should have been decoded and set to " + FUEL_VALUE_3814, FUEL_VALUE_3814, fuel.intValue());
		assertEquals("laser should have been decoded and set to " + LASER_TEMP_VALUE_94528016102, LASER_TEMP_VALUE_94528016102, laserTemp.longValue());

	}

}
