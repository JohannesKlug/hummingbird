package org.hbird.application.parametercache;

import java.util.HashMap;
import java.util.Map;

import org.hbird.core.spacesystemmodel.tmtc.Parameter;

public class InMemoryParameterCache implements ParameterCache {

	private static final Map<String, Parameter<?>> parameterMap = new HashMap<String, Parameter<?>>();

	public void handleParameterUpdate(Parameter<?> parameter) {
		parameterMap.put(parameter.getQualifiedName(), parameter);
	}

	/**
	 * Returns the requested {@link ParameterStatus} from the cache.
	 * 
	 * @param qualifiedName
	 * @return
	 */
	@Override
	public Parameter<?> getParameterStatus(String qualifiedName) {
		return parameterMap.get(qualifiedName);
	}

}
