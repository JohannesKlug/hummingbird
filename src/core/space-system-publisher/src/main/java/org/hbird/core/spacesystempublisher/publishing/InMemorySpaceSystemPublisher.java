package org.hbird.core.spacesystempublisher.publishing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystempublisher.interfaces.PublisherClient;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link SpaceSystemPublisher} that holds a {@link SpaceSystemModel} in memory at runtime.
 * 
 * @author Mark Doyle
 * 
 */
public class InMemorySpaceSystemPublisher implements SpaceSystemPublisher {
	private static final Logger LOG = LoggerFactory.getLogger(InMemorySpaceSystemPublisher.class);

	private SpaceSystemModel model;

	private List<PublisherClient> clients;

	public InMemorySpaceSystemPublisher() {
	}

	/**
	 * Creates the space system publisher with the provided {@link SpaceSystemModel} This model will be used to provide
	 * responses to all service requests regarding the space system.
	 * 
	 * @param model
	 */
	public InMemorySpaceSystemPublisher(final SpaceSystemModel model) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Instantiated InMemorySpaceSystemPublisher using space system model " + model.getName());
		}
		this.model = model;
	}

	@Override
	public Map<String, ParameterGroup> getParameterGroups() {
		return model.getParameterGroups();
	}

	@Override
	public List<ParameterGroup> getParameterGroupList() {
		return new ArrayList<ParameterGroup>(model.getParameterGroupsCollection());
	}

	@Override
	public Map<String, CommandGroup> getCommands() {
		return model.getCommands();
	}

	@Override
	public List<CommandGroup> getCommandList() {
		return new ArrayList<CommandGroup>(model.getCommands().values());
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
	 * @param model
	 *            the model to set
	 */
	public void setModel(final SpaceSystemModel model) {
		this.model = model;
	}

	@Override
	public Map<String, List<String>> getRestrictions() {
		return this.model.getAllPayloadRestrictions();
	}

	@Override
	public void fireUpdate() {
		for (PublisherClient client : clients) {
			client.entireModelUpdated();
		}
	}

	@Override
	public CommandGroup getCommand(final String qualifiedName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void modelUpdated() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ParameterGroup getParameterGroup(final String qualifiedName) throws UnknownParameterGroupException {
		return model.getParameterGroup(qualifiedName);
	}

	@Override
	public List<Parameter<?>> getAllParameters() {
		return new ArrayList<Parameter<?>>(model.getAllPayloadParameters().values());
	}

	@Override
	public void setClients(List<PublisherClient> clients) {
		this.clients = clients;
	}

	@Override
	public Map<String, String> getCommandVerifiers(String qualifiedName) {
		return model.getCommandVerifiers(qualifiedName);
	}

	@Override
	public Map<String, Calibrator> getAllCalibrators() {
		return model.getAllCalibrators();
	}

	@Override
	public Map<String, String> getAllUnitDescriptions() {
		return model.getAllUnitDescriptions();
	}

	@Override
	public String getUnitDescription(String qualifiedName) {
		return getAllUnitDescriptions().get((qualifiedName));
	}
}
