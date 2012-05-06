package org.hbird.core.spacesystempublisher.interfaces;

import java.util.List;
import java.util.Map;

import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.encoding.Encoding;


public interface SpaceSystemPublisher {
	Map<String, ParameterGroup> getParameterGroups();
	Map<String, ParameterGroup> getCommands();
	List<ParameterGroup> getParameterGroupList();
	List<ParameterGroup> getCommandList();
	Map<String, Encoding> getEncodings();
	Map<String, List<String>> getRestrictions();

	void fireUpdate(SpaceSystemModelUpdate update);
}
