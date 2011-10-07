package org.hbird.transport.spacesystemmodel.parameters;

import java.io.Serializable;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelItem;

/**
 * Parameter interface. <br>
 * Parameters are typed in Hummingbird which means they can model a Parameter using any primitive or class.
 */
public interface Parameter<T> extends SpaceSystemModelItem, Serializable {

	/**
	 * Returns the value of this parameter.
	 *
	 * @return The value of this parameter.
	 *
	 */
	T getValue();

	/**
	 * Set the value of this Parameter.
	 *
	 * @param value
	 *            the value of this Parameter
	 */
	void setValue(T value);

	/**
	 * TODO can we implement comparable or equals/hash
	 * Checks the incoming object for equality with this Parameters value.
	 *
	 * @param obj
	 * @return
	 */
	boolean isValue(Object obj);

}
