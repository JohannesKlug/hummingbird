package org.hbird.core.spacesystemmodel.tmtc;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hbird.core.spacesystemmodel.tmtc.provided.AbstractParameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.TelemeteredParameter;

/**
 * TODO I think there is no need for this interface, {@link AbstractParameter} is enough so far....
 * 
 * Parameter interface. <br>
 * Parameters are typed in Hummingbird which means they can model a Parameter using any primitive or class.
 * 
 * Jackson JSON annotations are configured so that objects of this interface are deserialised to
 * {@link TelemeteredParameter} concrete objects. See Jackson docs if you wish to provide a different method for
 * deserialisation.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 */
@JsonDeserialize(as = TelemeteredParameter.class)
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