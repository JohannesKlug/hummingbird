package org.hbird.core.commons.util.typeconverters;

import java.util.BitSet;

import org.apache.camel.Converter;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.exceptions.BitSetOperationException;

@Converter
public class ToBitSetConverter {

	@Converter
	public static BitSet toBitSet(final String binaryString) throws BitSetOperationException {
		return BitSetUtility.stringToBitSet(binaryString, true, true);
	}

	@Converter
	public static BitSet toBitSet(final byte[] bytes) throws BitSetOperationException {
		return BitSetUtility.fromByteArray(bytes);
	}
}
