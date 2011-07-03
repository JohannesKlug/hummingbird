package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelItem;

/**
 * Parameter interface. <br>
 * Paramters are typed in Hummingbird which means they can model a Parameter using any primitive or class.
 */
public interface Parameter<T> extends SpaceSystemModelItem {

	/**
	 * The Endianness or byte order of the binary data this Parameter represents. This is part of the Parameter
	 * interface as it will be required by clients of Parameter.
	 */
	enum Endianness {
		BIG, LITTLE
	};


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
	 * Returns the size of the Parameter in bits.
	 * 
	 * @return int representing the size in bits of this {@link Parameter}
	 */
	long getSizeInBits();

	/**
	 * Returns the byte order of the binary data this Parameter represents.
	 * 
	 * @return endiannness of the binary data this Parameter represents.
	 */
	Endianness getEndianness();

	boolean isValue(Object obj);
}
