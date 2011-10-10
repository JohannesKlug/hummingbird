package org.hbird.spacesystempublisher.publishing;

import java.util.Map;

import org.hbird.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;
import org.springframework.stereotype.Service;

@Service(value = "SpaceSystemPublisher")
public class InMemorySpaceSystemPublisher implements SpaceSystemPublisher {

	private SpaceSystemModel model;

	public InMemorySpaceSystemPublisher() {
	}

	public InMemorySpaceSystemPublisher(final SpaceSystemModel model) {
		this.model = model;
	}

	@Override
	public Map<String, ParameterGroup> getParameterGroups() {
		return model.getParameterGroups();
	}

	@Override
	public Map<String, Encoding> getEncodings() {
		return model.getEncodings();
	}

}
