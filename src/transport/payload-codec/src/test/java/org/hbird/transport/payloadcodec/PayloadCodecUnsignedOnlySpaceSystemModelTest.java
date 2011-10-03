package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PayloadCodecUnsignedOnlySpaceSystemModelTest {

	private static PayloadCodec codec;
	private static SpaceSystemModel ssm;

	private static final int SCID_VALUE_1 = 3814;
	private static final String SCID_VALUE_1_AS_STRING = "00000000000000000000000000000001";

	private static final int FUEL_VALUE_3814 = 3814;
	private static final String FUEL_VALUE_3814_AS_STRING = "111011100110";

	private static final long LASER_TEMP_VALUE_644283829990 = 644283829990L;
	private static final String LASER_TEMP_644283829990_AS_STRING = "1001011000000010010011110000111011100110";

	private static final String COMPLETE_ENCODED_PAYLOAD_AS_STRING = "000000000000000000000000000000011110111001101001011000000010010011110000111011100110";
	private static final int COMPLETE_ENCODED_PAYLOAD_LENGTH = 84;
	private static BitSet completeEncodedPayloadBitset;


	@BeforeClass
	public static void setUp() throws Exception {
		ssm = new MockSpaceSystemModel();
		codec = new HummingbirdPayloadCodec(ssm);

		completeEncodedPayloadBitset = BitSetUtility.stringToBitSet(COMPLETE_ENCODED_PAYLOAD_AS_STRING, true, true);
		assertTrue(StringUtils.equals(COMPLETE_ENCODED_PAYLOAD_AS_STRING, BitSetUtility.bitSetToBinaryString(completeEncodedPayloadBitset, COMPLETE_ENCODED_PAYLOAD_LENGTH)));
	}


	@Test
	public void testParameterGroupFromBitSet() throws UnknownParameterGroupException {
		ParameterGroup actual = codec.decode(completeEncodedPayloadBitset, null);

		Integer scid = ssm.getIntParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).getValue();
		Integer fuel = ssm.getIntParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).getValue();
		Long laserTemp = ssm.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).getValue();

		assertEquals("SCID should have been decoded and set to " + SCID_VALUE_1, SCID_VALUE_1, scid.intValue());
		assertEquals("Fuel should have been decoded and set to " + FUEL_VALUE_3814, FUEL_VALUE_3814, fuel.intValue());
		assertEquals("laser should have been decoded and set to " + LASER_TEMP_VALUE_644283829990, LASER_TEMP_VALUE_644283829990, laserTemp.longValue());
	}

	@Ignore
	@Test
	public void testEncodeParameterGroupBitSet() {

	}

}
