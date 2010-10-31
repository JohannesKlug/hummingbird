package com.logica.hummingbird.type;

public class IntArgument extends Argument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Integer upperLimit = null;
	
	protected Integer lowerLimit = null;
	
	public IntArgument(String name, String description, long bitLength) {
		super(name, description, bitLength);
	}

	@Override
	public Object getValue(Object value) {
		return Integer.parseInt((String)value);
	}
	
	@Override
	public boolean validate(Object value) {
		return (lowerLimit == null || lowerLimit <= (Integer) value) && (upperLimit == null || (Integer) value <= upperLimit);
	}
}
