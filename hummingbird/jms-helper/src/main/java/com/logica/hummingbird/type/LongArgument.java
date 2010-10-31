package com.logica.hummingbird.type;

public class LongArgument extends Argument {

	protected Long upperLimit = null;
	
	protected Long lowerLimit = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LongArgument(String name, String description, long bitLength) {
		super(name, description, bitLength);
	}

	@Override
	public Object getValue(Object value) {
		return Long.parseLong((String)value);
	}

	@Override
	public boolean validate(Object value) {
		return (lowerLimit == null || lowerLimit <= (Long) value) && (upperLimit == null || (Long) value <= upperLimit);
	}
}
