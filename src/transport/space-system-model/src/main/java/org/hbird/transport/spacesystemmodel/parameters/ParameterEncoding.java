package org.hbird.transport.spacesystemmodel.parameters;

/**
 * How the Parameter should be encoding and decoded, that is, how it represents the data.
 * 
 * @author Mark Doyle
 * 
 */
public enum ParameterEncoding {
	unsigned, signMagnitude, twosComplement, onesComplement, binaryCodedDecimal, packedBinaryCodedDecimal
}
