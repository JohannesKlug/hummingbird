package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.parameters.types.ParameterType;

/**
 * The abstract base class for all {@link Parameter}s. The class is intended to be subtyped for each concrete type.
 * 
 * A parameter is the leaf of the Space System Model tree.
 * 
 * Each parameter has a type, which defines among others the length in bits.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public abstract class DefaultParameter<T> implements Parameter<T> {

	private final String name;
	private final String shortDescription;
	private final String longDescription;

	private T value;

	/** The Type of the parameter. */
	private ParameterType type = null;

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
	public DefaultParameter(final String name, final String shortDescription, final String longDescription, final ParameterType type) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.type = type;
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
	public ParameterType getType() {
		return type;
	}

	/**
	 * Sets the type of the parameter.
	 * 
	 * @param type
	 *            The type to be set.
	 * 
	 */
	public void setType(final ParameterType type) {
		this.type = type;
	}

	@Override
	public int getSizeInBits() {
		return this.getSizeInBits();
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
		builder.append(", type=");
		builder.append(type);
		builder.append(", value=");
		builder.append(value);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append("]");
		return builder.toString();
	};


}
