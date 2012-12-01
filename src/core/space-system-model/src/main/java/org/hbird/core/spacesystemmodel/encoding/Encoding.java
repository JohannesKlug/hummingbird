package org.hbird.core.spacesystemmodel.encoding;

import java.io.Serializable;
import java.nio.ByteOrder;

import javax.xml.bind.annotation.XmlRootElement;

// TODO Should this be an interface in commons? I think so. We are dealing with a concrete class here solely defined in the ssm module
@XmlRootElement()
public class Encoding implements Serializable {
	private static final long serialVersionUID = -3932706937964758588L;

	public enum BinaryRepresentation {
		unsigned, signMagnitude, twosComplement, onesComplement, binaryCodedDecimal, packedBinaryCodedDecimal, UTF8, UTF16, ASCII, IEEE754_1985, MILSTD_1750A
	}

	private int sizeInBits;
	private ByteOrder byteOrder;
	private BinaryRepresentation binaryRepresentation;

	public Encoding() {
	}

	public Encoding(final int sizeInBits, final BinaryRepresentation binaryRepresentation, ByteOrder orderOfBytes) {
		this.sizeInBits = sizeInBits;
		this.binaryRepresentation = binaryRepresentation;
		this.byteOrder = orderOfBytes;
	}

	/**
	 * BIG ENDIAN OK
	 * 
	 * @param sizeInBits
	 * @param binaryRep
	 */
	public Encoding(int sizeInBits, BinaryRepresentation binaryRep) {
		this(sizeInBits, binaryRep, ByteOrder.BIG_ENDIAN);
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

	public ByteOrder getByteOrder() {
		return byteOrder;
	}

	public void setByteOrder(ByteOrder byteOrder) {
		this.byteOrder = byteOrder;
	}

}
