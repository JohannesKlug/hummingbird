/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.types.ParameterType;

/**
 * The float container encodes / decodes a float parameter from the data stream.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class FloatParameter extends DefaultParameter<Double> {

	/**
	 * Constructor of the FloatParameter class.
	 * 
	 * @param name
	 *            The name of the container. Used as the unique identifier of the container.
	 * @param shortDescription
	 *            A one-line description, tooltip style, of the container.
	 * @param longDescription
	 *            A full description of the container, help style.
	 * @param NumberParameterType
	 *            The type of the container. The type defines the length and behaviour of the parameter.
	 * @param value
	 *            The initial value.
	 * @throws InvalidParameterTypeException
	 */
	public FloatParameter(final String name, final String shortDescription, final String longDescription, final ParameterType type, final double value)
			throws InvalidParameterTypeException {
		super(name, shortDescription, longDescription, type);
	}

	@Override
	public boolean match(final String value) {
		return (this.getValue().doubleValue() == Double.parseDouble(value));
	}

}


// @Override
// public BitSet unmarshall(BitSet packet) {
// value = this.getType().getNumberBehaviour().valueFromBitSet(packet);
//
// for (ParameterObserver paramObserver : updatedParameterObservers) {
// paramObserver.updated(name, value.doubleValue(), shortDescription, longDescription);
// }
//
// return packet.get((int) type.getSizeInBits(), packet.length() + 1);
// }

// @Override
// public int marshall(BitSet packet, int offset) throws BitSetOperationException {
// packet = this.getType().getNumberBehaviour().insertIntoBitSet(getValue(), packet, offset);
//
// return offset + (int) type.getSizeInBits();
// }
