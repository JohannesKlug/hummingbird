package org.hbird.core.spacesystemmodel.util;

import java.util.List;

import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;

/**
 * Simple utility method for returning the parameters frmo a paramete group. This is only here for camel routes where
 * using this bean seems to be massively faster than using the simple expression language.
 * 
 * @author mark
 * 
 */
public class ParameterGroupParametersExtractor {

	public final static List<Parameter<?>> extractParameters(final ParameterGroup group) {
		return group.getAllParametersAsList();
	}

}