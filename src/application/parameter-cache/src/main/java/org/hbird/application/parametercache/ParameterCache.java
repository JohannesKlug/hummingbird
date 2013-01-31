package org.hbird.application.parametercache;

import org.hbird.core.spacesystemmodel.tmtc.Parameter;

public interface ParameterCache {
	Parameter<?> getParameterStatus(String qualifiedName);
}
