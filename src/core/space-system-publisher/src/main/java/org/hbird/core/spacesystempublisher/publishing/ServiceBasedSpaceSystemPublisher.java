package org.hbird.core.spacesystempublisher.publishing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.SpaceSystemModelFactory;
import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
import org.hbird.core.spacesystempublisher.interfaces.PublisherClient;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link SpaceSystemPublisher} that uses a {@link SpaceSystemModelFactory} service interface to retrieve the model.
 * 
 * @author Mark Doyle
 * 
 */
public class ServiceBasedSpaceSystemPublisher implements SpaceSystemPublisher {
	private final static Logger LOG = LoggerFactory.getLogger(ServiceBasedSpaceSystemPublisher.class);

	/** {@link SpaceSystemModelFactory} used to retrieve the model */
	private SpaceSystemModelFactory factoryService;

	/** Cached Space system model */
	private SpaceSystemModel modelCache = null;

	private List<PublisherClient> clients;

	/**
	 * Retrieves and caches the space system model from the space system model factory service.
	 * 
	 * @throws UnavailableSpaceSystemModelException
	 */
	public void loadModel() throws UnavailableSpaceSystemModelException {
		LOG.debug("Loading space system model from SpaceSystemModelFactory service...");

		if (factoryService != null) {
			try {
				this.modelCache = factoryService.createSpaceSystemModel();
			}
			catch (InvalidSpaceSystemDefinitionException e) {
				throw new UnavailableSpaceSystemModelException("The publisher could not cache the space system model", e);
			}
			LOG.info("Model " + this.modelCache.getName() + " cached in publisher.");
		}
		else {
			LOG.warn("SpaceSystemModelFactoryService is not available or injected, cannot retrieve a space system model for loading and caching!");
		}
	}

	private void checkModelCache() throws UnavailableSpaceSystemModelException {
		if (modelCache == null) {
			loadModel();
		}
	}

	@Override
	public Map<String, ParameterGroup> getParameterGroups() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return modelCache.getParameterGroups();
	}

	@Override
	public List<ParameterGroup> getParameterGroupList() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return new ArrayList<ParameterGroup>(modelCache.getParameterGroupsCollection());
	}

	@Override
	public Map<String, CommandGroup> getCommands() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return modelCache.getCommands();
	}

	@Override
	public List<CommandGroup> getCommandList() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return new ArrayList<CommandGroup>(modelCache.getCommands().values());
	}

	@Override
	public Map<String, Encoding> getEncodings() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return modelCache.getEncodings();
	}

	/**
	 * @return the model
	 * @throws UnavailableSpaceSystemModelException
	 */
	public SpaceSystemModel getModel() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return modelCache;
	}

	@Override
	public Map<String, List<String>> getRestrictions() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return this.modelCache.getAllPayloadRestrictions();
	}

	@Override
	public CommandGroup getCommand(final String qualifiedName) throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return this.modelCache.getCommands().get(qualifiedName);
	}

	@Override
	public ParameterGroup getParameterGroup(final String qualifiedName) throws UnknownParameterGroupException, UnavailableSpaceSystemModelException {
		checkModelCache();
		return this.modelCache.getParameterGroup(qualifiedName);
	}

	@Override
	public List<Parameter<?>> getAllParameters() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return new ArrayList<Parameter<?>>(this.modelCache.getAllPayloadParameters().values());
	}

	@Override
	public Map<String, String> getCommandVerifiers(String qualifiedName) throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return this.modelCache.getCommandVerifiers(qualifiedName);
	}

	@Override
	public Map<String, Calibrator> getAllCalibrators() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return this.modelCache.getAllCalibrators();
	}

	@Override
	public Map<String, String> getAllUnitDescriptions() throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return modelCache.getAllUnitDescriptions();
	}

	@Override
	public String getUnitDescription(String qualifiedName) throws UnavailableSpaceSystemModelException {
		checkModelCache();
		return modelCache.getUnitDescription(qualifiedName);
	}

	@Override
	public void fireUpdate() {
		if (clients != null) {
			for (PublisherClient client : clients) {
				client.entireModelUpdated();
			}
		}
		else {
			if (LOG.isTraceEnabled()) {
				LOG.trace("No publisher clients to send mode update too");
			}
		}
	}

	public SpaceSystemModelFactory getFactoryService() {
		return factoryService;
	}

	public void setFactoryService(final SpaceSystemModelFactory factoryService) {
		this.factoryService = factoryService;
	}

	@Override
	public void modelUpdated() throws UnavailableSpaceSystemModelException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Publisher received notification that the factory space system model updated");
		}
		loadModel();
		fireUpdate();
	}

}
