package org.hbird.osgi.xtceosgi;

import java.io.File;
import java.util.Dictionary;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hbird.core.spacesystemmodel.SpaceSystemModelUpdateListener;
import org.hbird.core.xtce.XtceSpaceSystemModelFactory;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XtceManagedConfigUpdater implements ManagedService {

	private final static Logger LOG = LoggerFactory.getLogger(XtceManagedConfigUpdater.class);

	private static final String SPACE_SYSTEM_MODEL_FILENAME_FIELD = "spaceSystemModelFilename";

	private XtceSpaceSystemModelFactory factory;

	private List<SpaceSystemModelUpdateListener> modelUpdateListeners;

	@Override
	public void updated(final Dictionary configuration) {
		String dummyModelPath = this.getClass().getResource("DummyModel.xml").getPath();
		factory.setSpaceSystemModelFilename(dummyModelPath);

		if (LOG.isTraceEnabled()) {
			LOG.trace("Updater called with new configuration");
		}

		if (configuration == null) {
			LOG.warn("Updater received a null configuration. Model will not be changed");
			return;
		}

		String spaceSystemModelFilename = (String) configuration.get(SPACE_SYSTEM_MODEL_FILENAME_FIELD);
		if (StringUtils.isNotBlank(spaceSystemModelFilename)) {
			if (checkFile(spaceSystemModelFilename)) {
				factory.setSpaceSystemModelFilename(spaceSystemModelFilename);
				notifyModelUpdateListeners();
			}
			else {
				LOG.warn("Could not update the Space System Model as the configured filename, {0}, refers to an invalid or protected file.",
						spaceSystemModelFilename);
			}
		}
		else {
			LOG.warn("Could not update the Space System Model as the configured filename is blank!");
		}
	}

	private final void notifyModelUpdateListeners() {
		for (final SpaceSystemModelUpdateListener listener : modelUpdateListeners) {
			listener.modelChanged();
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

}
