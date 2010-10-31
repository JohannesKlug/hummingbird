package com.logica.hummingbird.type;


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
public abstract class Argument extends Named {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The length of the argument type in bits. */
	protected long bitLength = 64;
	
	/** The unit of the argument. */
	protected String unit;
	
	/**
	 * Creates a new argument. 
	 * 
	 * @param name The name of the argument
	 * @param description The description of the argument.
	 * @param bitLength The length in bits of the argument.
	 */
	public Argument(String name, String description, long bitLength) {
		super(name, description);
		this.bitLength = bitLength;
	}

	/**
	 * Method to get the value of the argument in the right format.
	 * 
	 * @param value The value expressed as a String object.
	 * @return The value expressed as the arguments type object, for example Long.
	 */
	public abstract Object getValue(Object value);
	
	public abstract boolean validate(Object value);
}
