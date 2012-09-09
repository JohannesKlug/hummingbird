package org.hbird.core.commons.tmtc;



/**
 * Parameter interface. <br>
 * Parameters are typed in Hummingbird which means they can model a Parameter using any primitive or class.
 */
public interface Parameter<T> extends SpaceSystemModelItem {

	String getName();

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

	long getReceivedTime();

	void setReceivedTime(long timestamp);

	boolean isReadOnly();
}