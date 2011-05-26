/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.ContainerImpl;
import org.hbird.transport.spacesystemmodel.parameters.types.NumberParameterType;

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
public abstract class ParameterContainer extends ContainerImpl implements Parameter {
//	private static final Logger LOG = LoggerFactory.getLogger(ParameterContainer.class);

	/** The NumberParameterType of the parameter. */
	protected NumberParameterType type = null;

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
	public ParameterContainer(String name, String shortDescription, String longDescription, NumberParameterType type) {
		super(name, shortDescription, longDescription);
		this.type = type;
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
	public NumberParameterType getType() {
		return type;
	}

	/**
	 * Sets the type of the parameter.
	 * 
	 * @param type
	 *            The type to be set.
	 * 
	 */
	public void setType(NumberParameterType type) {
		this.type = type;
	}

	@Override
	public int getLength() {
		return length + (int) type.getSizeInBits();
	}
}
