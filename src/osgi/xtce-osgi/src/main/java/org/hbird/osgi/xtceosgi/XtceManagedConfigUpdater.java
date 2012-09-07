package org.hbird.osgi.xtceosgi;

import java.util.Dictionary;
import java.util.List;

import org.hbird.core.spacesystemmodel.interfaces.SpaceSystemModelUpdateListener;
import org.hbird.core.xtce.XtceSpaceSystemModelFactory;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XtceManagedConfigUpdater implements ManagedService {

	private final static Logger LOG = LoggerFactory.getLogger(XtceManagedConfigUpdater.class);

	private static final String SPACE_SYSTEM_MODLE_FILENAME_FIELD = "spaceSystemModelFilename";

	private XtceSpaceSystemModelFactory factory;

	private List<SpaceSystemModelUpdateListener> modelUpdateListeners;

	public void setFactory(final XtceSpaceSystemModelFactory factory) {
		this.factory = factory;
	}

	public void setModelUpdateListeners(final List<SpaceSystemModelUpdateListener> modelUpdateListeners) {
		this.modelUpdateListeners = modelUpdateListeners;
	}

	public void setSpaceSystemModelFilename(final String spaceSystemModelFilename) {
		factory.setSpaceSystemModelFilename(spaceSystemModelFilename);
	}

	private final void notifyModelUpdateListeners() {
		for (final SpaceSystemModelUpdateListener listener : modelUpdateListeners) {
			listener.modelChanged();
		}
	}

	private final void nulledModel() {
		this.setSpaceSystemModelFilename("");
		this.notifyModelUpdateListeners();
	}

	@Override
	// Suppressing rawtypes on Dictionary because we are running in OSGi which still supports Java 1.4 and therefore does
	// not use generics.
	public void updated(@SuppressWarnings("rawtypes") final Dictionary configuration) throws ConfigurationException {
		LOG.trace("Updater called with new configuration");
		if (configuration == null) {
			nulledModel();
			return;
		}

		setSpaceSystemModelFilename((String) configuration.get(SPACE_SYSTEM_MODLE_FILENAME_FIELD));
		notifyModelUpdateListeners();
	}

}
