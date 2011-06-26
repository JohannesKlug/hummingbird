/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.parameters.types.ParameterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The abstract base class for all parameter <b><i>containers</i></b>. The class is intended to be subtyped for each
 * simple Java type type.
 * 
 * A parameter is the leaf of the container tree. Each parameter has a type, which defines among others the length in
 * bits.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public abstract class DefaultParameter implements Parameter {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultParameter.class);

	private final String name;
	private final String shortDescription;
	private final String longDescription;

	/** The NumberParameterType of the parameter. */
	protected ParameterType type = null;

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

	/**
	 * Sets the value of the parameter.
	 * 
	 * @param value
	 *            The value to be set.
	 * 
	 */
	abstract public void setValue(double value);

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
}
