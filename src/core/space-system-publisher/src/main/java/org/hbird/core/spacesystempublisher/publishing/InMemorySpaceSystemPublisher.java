package org.hbird.core.spacesystempublisher.publishing;

import java.util.List;
import java.util.Map;

import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemModelUpdate;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
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
	public Map<String, ParameterGroup> getCommands() {
		return model.getCommands();
	}

	@Override
	public Map<String, Encoding> getEncodings() {
		return model.getEncodings();
	}

	/**
	 * @return the model
	 */
	public SpaceSystemModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(final SpaceSystemModel model) {
		this.model = model;
	}

	@Override
	public Map<String, List<String>> getRestrictions() {
		return this.model.getAllPayloadRestrictions();
	}

	@Override
	public void fireUpdate(final SpaceSystemModelUpdate update) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


}
