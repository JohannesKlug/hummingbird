package org.hbird.transport.payloadcodec;

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



	@BeforeClass
	public static void setUp() throws Exception {
		ssm = new MockSpaceSystemModel();
		codec = new HummingbirdPayloadCodec(ssm);
	}

	@Test
	public void testDecodeParameterGroup() throws UnknownParameterGroupException {
		ssm.getIntParameter(MockSpaceSystemModel.SCID_PARAMETER_NAME).setValue(SCID_VALUE_1);
		ssm.getIntParameter(MockSpaceSystemModel.FUEL_PARAMETER_NAME).setValue(FUEL_VALUE_3814);
		ssm.getLongParameter(MockSpaceSystemModel.LASER_TEMP_PARAMETER_NAME).setValue(LASER_TEMP_VALUE_644283829990);
		
		// TODO finish
		Byte[] payload = new Byte[6];
		codec.decode(payload, null);
	}
	
	@Ignore
	@Test
	public void testEncodeParameterGroupBitSet() {
		
	}

}
