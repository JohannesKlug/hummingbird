package org.hbird.application.halcyon.osgi;

import org.hbird.application.halcyon.WebAppContextListener;
import org.osgi.util.tracker.ServiceTracker;

public class OsgiReady{

	private ServiceTracker cachedTracker;
	private final String serviceInterface;

	public OsgiReady(final String serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	protected ServiceTracker getServiceTracker() {
		if(cachedTracker == null) {
			cachedTracker = new ServiceTracker(WebAppContextListener.getBundleContext(), serviceInterface, null);
		}
		cachedTracker.open();
		return cachedTracker;
	}

}
