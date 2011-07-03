package org.hbird.transport.spacesystemmodel.parameters;


public class IntegerParameter extends DefaultParameter<Integer> {
	enum encoding {
		unsigned, signed, twosComplement, onesComplement, binaryCodedDecimal, packedBinaryCodedDecimal
	};

	public IntegerParameter(final String name, final String shortDescription, final String longDescription,
			final long sizeInBits, final Endianness endianness) {

		super(name, shortDescription, longDescription, sizeInBits, endianness);
	}
}
