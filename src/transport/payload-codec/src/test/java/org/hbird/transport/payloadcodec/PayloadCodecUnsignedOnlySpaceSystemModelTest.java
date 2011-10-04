package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.BitSet;

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
import org.junit.Ignore;
import org.junit.Test;

public class PayloadCodecUnsignedOnlySpaceSystemModelTest {

	private static PayloadCodec codec;
	private static SpaceSystemModel ssm;

	private static final int SCID_VALUE_1 = 1;
	private static final String SCID_VALUE_1_AS_STRING = "00000000000000000000000000000001";

	private static final int FUEL_VALUE_3814 = 3814;
	private static final String FUEL_VALUE_3814_AS_STRING = "111011100110";

	private static final long LASER_TEMP_VALUE_644283829990 = 94528016102L;
	private static final String LASER_TEMP_644283829990_AS_STRING = "0110011101110000111100100100000001101000";

	private static final String COMPLETE_ENCODED_PAYLOAD_AS_STRING = "000000000000000000000000000000011110111001100110011101110000111100100100000001101000";
	private static final int COMPLETE_ENCODED_PAYLOAD_LENGTH = 84;
	private static BitSet completeEncodedPayloadBitset;


	@BeforeClass
	public static void setUp() throws BitSetOperationException, UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException  {
		ssm = new MockSpaceSystemModel();
		codec = new HummingbirdPayloadCodec(ssm);

		completeEncodedPayloadBitset = BitSetUtility.stringToBitSet(COMPLETE_ENCODED_PAYLOAD_AS_STRING, true, true);
		assertTrue(StringUtils.equals(COMPLETE_ENCODED_PAYLOAD_AS_STRING, BitSetUtility.bitSetToBinaryString(completeEncodedPayloadBitset, COMPLETE_ENCODED_PAYLOAD_LENGTH)));
	}


	@Test
	public void testParameterGroupFromBitSet() throws Exception {
		ParameterGroup actual = codec.decode(completeEncodedPayloadBitset, null);

		Integer scid = actual.getIntegerParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).getValue();
		Integer fuel = actual.getIntegerParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).getValue();
		Long laserTemp = actual.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).getValue();

		assertEquals("SCID should have been decoded and set to " + SCID_VALUE_1, SCID_VALUE_1, scid.intValue());
		assertEquals("Fuel should have been decoded and set to " + FUEL_VALUE_3814, FUEL_VALUE_3814, fuel.intValue());
		assertEquals("laser should have been decoded and set to " + LASER_TEMP_VALUE_644283829990, LASER_TEMP_VALUE_644283829990, laserTemp.longValue());
	}

	@Ignore
	@Test
	public void testEncodeParameterGroupBitSet() {

	}

}
