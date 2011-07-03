package org.hbird.transport.spacesystemmodel.parameters;


/**
 * The abstract base class for all {@link Parameter}s. The class is intended to be subtyped for each concrete type.
 * 
 * A parameter is the leaf of the Space System Model tree.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 */
public abstract class DefaultParameter<T> implements Parameter<T> {

	private final String name;
	private final String shortDescription;
	private final String longDescription;
	private final long sizeInBits;
	private final Endianness endianness;
	private T value;


	/**
	 * Constructor of the Parameter class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * @param type
	 *            The parameter type.
	 * 
	 */
	public DefaultParameter(final String name, final String shortDescription, final String longDescription, final long sizeInBits, final Endianness endianness) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.sizeInBits = sizeInBits;
		this.endianness = endianness;
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
	public long getSizeInBits() {
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

	@Override
	public boolean isValue(final Object obj) {
		if (value.equals(obj)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Endianness getEndianness() {
		return this.endianness;
	}

}
