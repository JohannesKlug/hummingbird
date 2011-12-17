package org.hbird.spacesystempublisher.interfaces;

import java.util.Map;

import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;


public interface SpaceSystemPublisher {
	Map<String, ParameterGroup> getParameterGroups();
	Map<String, Encoding> getEncodings();

	void fireUpdate(SpaceSystemModelUpdate update);
}
