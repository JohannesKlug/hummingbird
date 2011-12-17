package org.hbird.spacesystempublisher.publishing;

import java.util.Map;

import org.hbird.spacesystempublisher.interfaces.SpaceSystemModelUpdate;
import org.hbird.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;
import org.springframework.stereotype.Service;

@Service(value = "SpaceSystemPublisher")
public class InMemorySpaceSystemPublisher implements SpaceSystemPublisher {

	private SpaceSystemModel model;
//	private SpaceSystemModelFactory spaceSystemFactory;

	public InMemorySpaceSystemPublisher() {
	}

//	public InMemorySpaceSystemPublisher(final SpaceSystemModelFactory factory, final String spaceSystemDefinitionFile) {
//		try {
//			factory.createSpaceSystemModel(spaceSystemDefinitionFile);
//		}
//		catch (InvalidParameterTypeException e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		catch (InvalidSpaceSystemDefinitionException e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//	}

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
//
//	public SpaceSystemModelFactory getSpaceSystemFactory() {
//		return spaceSystemFactory;
//	}
//
//	public void setSpaceSystemFactory(final SpaceSystemModelFactory spaceSystemFactory) {
//		this.spaceSystemFactory = spaceSystemFactory;
//	}

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
	public void fireUpdate(final SpaceSystemModelUpdate update) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


}
