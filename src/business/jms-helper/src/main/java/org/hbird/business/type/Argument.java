package org.hbird.business.type;

import org.hbird.business.buffers.ObjectBuffer;
import org.hbird.business.tasks.checks.ParameterNotSetException;
import org.hbird.business.tasks.checks.Range;
import org.hbird.business.tasks.checks.StaticValue;


/**
 * A command argument definition. The value itself is maintained some where else,
 * most likely in the header of an exchange.
 * 
 * The argument definition has a name which is a unique identification of the definition. A
 * descriotion can be used to describe the type.
 * 
 * The bit length defines the min / max value of the type.
 *
 */
public class Argument extends Named {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The length of the argument type in bits. */
	protected long bitLength = 64;
	
	protected String type;
	
	/** The unit of the argument. */
	protected String unit;
	
	protected Range range;
	
	protected Number value;
	
	/**
	 * Creates a new argument. 
	 * 
	 * @param name The name of the argument
	 * @param description The description of the argument.
	 * @param bitLength The length in bits of the argument.
	 */
	public Argument(String name, String description, String type, long bitLength, String unit, Range range) {
		super(name, description);
		this.type = type;
		this.bitLength = bitLength;
		this.unit = unit;
		this.range = range;
	}

	/**
	 * Method to get the value of the argument in the right format.
	 * 
	 * @param value The value expressed as a String object.
	 * @return The value expressed as the arguments type object, for example Long.
	 */
	public Object getValue() {
		return value;
	}
	
	public boolean validate(ObjectBuffer buffer) throws ParameterNotSetException {
		range.setParameter(new StaticValue(value));
		return range.validate(buffer);
	}

	public long getBitLength() {
		return bitLength;
	}

	public String getType() {
		return type;
	}

	public String getUnit() {
		return unit;
	}

	public Range getRange() {
		return range;
	}
	
	
}
