package org.hbird.core.spacesystemmodel.tmtc;

import java.util.HashMap;
import java.util.Map;

public class CommandVerification {

	private final Map<String, String> parameterComparisons = new HashMap<String, String>();

	public void addParameter(String qualifiedParameterName, String value) {
		parameterComparisons.put(qualifiedParameterName, value);
	}

	public final Map<String, String> getParameterComparisons() {
		return parameterComparisons;
	}

}
