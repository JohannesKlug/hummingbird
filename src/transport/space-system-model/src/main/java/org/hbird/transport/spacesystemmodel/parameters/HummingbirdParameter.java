package org.hbird.transport.spacesystemmodel.parameters;


/**
 * The Hummingbird implementation of the {@link Parameter}.
 * 
 * This is a generic class that is able to represent a parameter of any primitive or class.
 * 
 * @author Mark Doyle
 */
public class HummingbirdParameter<T> implements Parameter<T> {
	private static final long serialVersionUID = 4723421286629148964L;
	
	private final String name;
	private final String shortDescription;
	private final String longDescription;
	private final int sizeInBits;
	private final Encoding encoding;
	private T value;

	/**
	 * 
	 * @param name
	 * @param shortDescription
	 * @param longDescription
	 * @param sizeInBits
	 * @param endianness
	 * @param encoding
	 */
	public HummingbirdParameter(final String name, final String shortDescription, final String longDescription,
			final int sizeInBits, final Encoding encoding) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.sizeInBits = sizeInBits;
		this.encoding = encoding;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
	}

	@Override
	public int getSizeInBits() {
		return this.sizeInBits;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(final T value) {
		this.value = value;
	}

	@Override
	public boolean isValue(final Object obj) {
		if (value == null) {
			return false;
		}
		if (value.equals(obj)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Encoding getEncoding() {
		return this.encoding;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultParameter [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append("]");
		return builder.toString();
	}


}
