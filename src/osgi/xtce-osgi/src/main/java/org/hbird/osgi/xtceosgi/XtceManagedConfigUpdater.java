package org.hbird.osgi.xtceosgi;

import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hbird.core.spacesystemmodel.interfaces.SpaceSystemModelUpdateListener;
import org.hbird.core.xtce.XtceSpaceSystemModelFactory;

public class XtceManagedConfigUpdater {

	private XtceSpaceSystemModelFactory factory;

	private List<SpaceSystemModelUpdateListener> modelUpdateListeners;

	private String spaceSystemModelFilename;

	private final Lock lock = new ReentrantLock();

	public void update(final Dictionary props) {
		System.out.println("Config updated");
		String fileName = (String) props.get("spaceSystemModelFilename");
	}

	public void setFactory(final XtceSpaceSystemModelFactory factory) {
		this.factory = factory;
	}

	public void setModelUpdateListeners(final List<SpaceSystemModelUpdateListener> modelUpdateListeners) {
		this.modelUpdateListeners = modelUpdateListeners;
	}

	public void setSpaceSystemModelFilename(final String spaceSystemModelFilename) {
		System.out.println("GAYYYYBEN");
		factory.setSpaceSystemModelFilename(spaceSystemModelFilename);

		lock.lock();
		for (SpaceSystemModelUpdateListener listener : modelUpdateListeners) {
			listener.modelChanged();
		}
		lock.unlock();
	}

	public String getSpaceSystemModelFilename() {
		return spaceSystemModelFilename;
	}

}
