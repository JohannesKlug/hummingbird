package org.hbird.application.parameterarchive.interfaces;

import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;

public interface ParameterArchiver {

	void archiveParameter(Parameter<?> parameter);

	void archiveParameter(ParameterGroup parameterGroup);
}
