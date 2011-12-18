package org.hbird.transport.protocols.ccsds.transferframe.typeconverters;

import org.apache.camel.Converter;
import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.commons.util.exceptions.InvalidBinaryStringException;
import org.hbird.transport.protocols.ccsds.transferframe.data.FramePayload;

@Converter
public class ToFramePayloadConverter {

	@Converter
	public static FramePayload convertToFramePayload(String binaryString) throws InvalidBinaryStringException {
		byte[] payload = BytesUtility.binaryStringToByteArray(binaryString);
		FramePayload framePayload = new FramePayload(payload, false, 0); // TODO add a converter that handles timestamps!
		return framePayload;
	}
	
	@Converter
	public static FramePayload convertFromByteArray(byte[] payload) {
		return new FramePayload(payload, false, 0); // TODO add a converter that handles timestamps!
	}
}
