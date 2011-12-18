package org.hbird.core.commons.util.typeconverters;

import org.apache.camel.Converter;
import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.commons.util.exceptions.InvalidBinaryStringException;

@Converter
public class ToByteArrayConverter {

	public static byte[] toByteArray(String binaryString) throws InvalidBinaryStringException {
		return BytesUtility.binaryStringToByteArray(binaryString);
	}
}
