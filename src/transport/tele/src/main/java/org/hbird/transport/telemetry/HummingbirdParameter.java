package org.hbird.transport.telemetry;

public interface HummingbirdParameter {

	Class<? extends Object> getClassType();

	String getName();

	Object getValue();

	String getShortDescription();

	String getLongDescription();
	
	int compareTo(HummingbirdParameter rightHandSide) throws NotComparableTypeException;
	
	boolean asBoolean();
}
