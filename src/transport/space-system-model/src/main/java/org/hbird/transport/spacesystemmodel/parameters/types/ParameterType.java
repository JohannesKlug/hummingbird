package org.hbird.transport.spacesystemmodel.parameters.types;

import org.hbird.transport.spacesystemmodel.parameters.DefaultParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

/**
 * {@link Parameter}s must return their type as part of the interface definition. This Enum is used by Hummingbirds
 * {@link DefaultParameter} to accomplish this.
 * 
 * @author Mark Doyle
 * 
 */
public enum ParameterType {
	UInteger, Integer, ULong, Long, Float32, Float64, String
}