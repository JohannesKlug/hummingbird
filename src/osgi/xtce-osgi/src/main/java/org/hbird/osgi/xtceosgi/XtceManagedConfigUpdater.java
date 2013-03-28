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
	public void updated(final Dictionary configuration) throws ConfigurationException {
		LOG.trace("Updater called with new configuration");
		if (configuration == null) {
			nulledModel();
			return;
		}

		String spaceSystemModelFilename = (String) configuration.get(SPACE_SYSTEM_MODEL_FILENAME_FIELD);
		if (checkFile(spaceSystemModelFilename)) {
			setSpaceSystemModelFilename(spaceSystemModelFilename);
			notifyModelUpdateListeners();
		}
		else {
			throw new ConfigurationException(SPACE_SYSTEM_MODEL_FILENAME_FIELD,
					"Invalid space system model file. File does not exist, is not a file (you may hav specified a directory), or is not readable");
		}
	}

	private static boolean checkFile(String file) {
		File check = new File(file);
		if (check.exists() & check.isFile() & check.canRead()) {
			return true;
		}
		return false;
	}

}
