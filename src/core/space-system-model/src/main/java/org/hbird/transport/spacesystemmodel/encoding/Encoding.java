package org.hbird.transport.spacesystemmodel.encoding;

public class Encoding {

	public enum BinaryRepresentation {
		unsigned, signMagnitude, twosComplement, onesComplement, binaryCodedDecimal, packedBinaryCodedDecimal, UTF8, UTF16, IEEE754_1985, MILSTD_1750A
	}

	private int sizeInBits;
	private BinaryRepresentation binaryRepresentation;

	public Encoding(final int sizeInBits, final BinaryRepresentation binaryRepresentation) {
		this.sizeInBits = sizeInBits;
		this.binaryRepresentation = binaryRepresentation;
	}

	public int getSizeInBits() {
		return sizeInBits;
	}

	public void setSizeInBits(final int sizeInBits) {
		this.sizeInBits = sizeInBits;
	}

	public BinaryRepresentation getBinaryRepresentation() {
		return binaryRepresentation;
	}

	public void setBinaryRepresentation(final BinaryRepresentation binaryRepresentation) {
		this.binaryRepresentation = binaryRepresentation;
	}

}
