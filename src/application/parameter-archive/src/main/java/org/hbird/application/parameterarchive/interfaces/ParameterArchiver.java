package org.hbird.application.parameterarchive.interfaces;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;

public interface ParameterArchiver {

	void archiveParameter(Parameter<?> parameter);

	void archiveParameter(ParameterGroup parameterGroup);
}
