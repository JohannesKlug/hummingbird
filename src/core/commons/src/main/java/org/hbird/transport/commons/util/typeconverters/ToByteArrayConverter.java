package org.hbird.transport.commons.util.typeconverters;

import org.apache.camel.Converter;
import org.hbird.transport.commons.util.BytesUtility;
import org.hbird.transport.commons.util.exceptions.InvalidBinaryStringException;

@Converter
public class ToByteArrayConverter {

	public static byte[] toByteArray(String binaryString) throws InvalidBinaryStringException {
		return BytesUtility.binaryStringToByteArray(binaryString);
	}
}
