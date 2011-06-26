/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelItem;
import org.hbird.transport.spacesystemmodel.parameters.types.ParameterType;

/**
 * Interface of a parameter container.
 */
public interface Parameter extends SpaceSystemModelItem {
	/**
	 * Returns the type of the parameter.
	 * 
	 * @return ParameterType The type of the parameter.
	 * 
	 */
	ParameterType getType();


	/**
	 * Returns the value of the parameter.
	 * 
	 * @return float The value of the parameter.
	 * 
	 */
	Number getValue();

	/**
	 * Returns the size of the Parameter in bits.
	 * 
	 * @return int representing the size in bits of this {@link Parameter}
	 */
	int getSizeInBits();


	/**
	 * Converts the parsed value to the type of this parameter and compares the value with the current value.
	 * 
	 * @param value
	 *            The value to be compared against.
	 * 
	 */
	boolean match(String value);

}
