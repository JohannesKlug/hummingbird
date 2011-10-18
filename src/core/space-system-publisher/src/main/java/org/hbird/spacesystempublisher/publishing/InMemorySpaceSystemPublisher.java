package org.hbird.spacesystempublisher.publishing;

import java.util.Map;

import org.hbird.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.SpaceSystemModelFactory;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;
import org.springframework.stereotype.Service;

@Service(value = "SpaceSystemPublisher")
public class InMemorySpaceSystemPublisher implements SpaceSystemPublisher {

	private SpaceSystemModel model;
	private SpaceSystemModelFactory spaceSystemFactory;

	public InMemorySpaceSystemPublisher() {
	}
	
	public InMemorySpaceSystemPublisher(SpaceSystemModelFactory factory, String spaceSystemDefinitionFile) {
		try {
			factory.createSpaceSystemModel(spaceSystemDefinitionFile);
		}
		catch (InvalidParameterTypeException | InvalidSpaceSystemDefinitionException e) {
			e.printStackTrace();
			System.exit(-1);
		}
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

	public SpaceSystemModelFactory getSpaceSystemFactory() {
		return spaceSystemFactory;
	}

	public void setSpaceSystemFactory(SpaceSystemModelFactory spaceSystemFactory) {
		this.spaceSystemFactory = spaceSystemFactory;
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
	public void setModel(SpaceSystemModel model) {
		this.model = model;
	}


}
