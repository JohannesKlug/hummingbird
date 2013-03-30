package org.hbird.osgi.xtceosgi;

import java.io.File;
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

	private static final String SPACE_SYSTEM_MODEL_FILENAME_FIELD = "spaceSystemModelFilename";

	private XtceSpaceSystemModelFactory factory;

	private List<SpaceSystemModelUpdateListener> modelUpdateListeners;

	private final void notifyModelUpdateListeners() {
		for (final SpaceSystemModelUpdateListener listener : modelUpdateListeners) {
			listener.modelChanged();
		}
	}

	@Override
	public void updated(final Dictionary configuration) throws ConfigurationException {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Updater called with new configuration");
		}

		if (configuration == null) {
			LOG.warn("Updater received a null configuration. Model will not be changed");
			return;
		}

		String spaceSystemModelFilename = (String) configuration.get(SPACE_SYSTEM_MODEL_FILENAME_FIELD);
		if (spaceSystemModelFilename != null && checkFile(spaceSystemModelFilename)) {
			configureFactoryModelFilename(spaceSystemModelFilename);
			notifyModelUpdateListeners();
		}
		else {
			throw new ConfigurationException(SPACE_SYSTEM_MODEL_FILENAME_FIELD,
					"Invalid space system model file. File does not exist, is not a file (you may have specified a directory), or is not readable");
		}
	}

	private static boolean checkFile(String file) {
		File check = new File(file);
		if (check.exists() & check.isFile() & check.canRead()) {
			if (LOG.isTraceEnabled()) {
				LOG.trace("File " + file + " is present and readable.");
			}
			return true;
		}
		return false;
	}

	public void setFactory(final XtceSpaceSystemModelFactory factory) {
		this.factory = factory;
	}

	public void setModelUpdateListeners(final List<SpaceSystemModelUpdateListener> modelUpdateListeners) {
		this.modelUpdateListeners = modelUpdateListeners;
	}

	public void configureFactoryModelFilename(final String spaceSystemModelFilename) {
		factory.setSpaceSystemModelFilename(spaceSystemModelFilename);
	}
}
