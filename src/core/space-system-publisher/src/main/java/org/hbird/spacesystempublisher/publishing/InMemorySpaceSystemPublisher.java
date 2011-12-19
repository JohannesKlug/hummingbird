package org.hbird.spacesystempublisher.publishing;

import java.util.List;
import java.util.Map;

import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.spacesystempublisher.interfaces.SpaceSystemModelUpdate;
import org.hbird.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
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
