package org.hbird.transport.commons.util.typeconverters;

import java.util.BitSet;

import org.apache.camel.Converter;
import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;

@Converter
public class StringToBitSetConverter {
	
	@Converter
	public static BitSet toBitSet(String binaryString) throws BitSetOperationException {
		return BitSetUtility.stringToBitSet(binaryString, true, true);
	}
	
	@Converter
	public static BitSet toBitSet(String binaryString, boolean bigEndian) throws BitSetOperationException {
		return BitSetUtility.stringToBitSet(binaryString, bigEndian, bigEndian);
	}
}
