package org.hbird.application.halcyon.osgi;

import org.hbird.application.halcyon.HalcyonServletContextListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OsgiReady {
	private static final Logger LOG = LoggerFactory.getLogger(OsgiReady.class);

	private ServiceTracker serviceTracker;
	private final String serviceInterface;

	public OsgiReady(final String serviceInterface) {
		System.out.println("Instantiating OsgiReady Jersey resource using serivce " + serviceInterface);
		this.serviceInterface = serviceInterface;
	}

	protected ServiceTracker getServiceTracker() {
		if (serviceTracker == null) {
			cacheTracker();
		}
		return serviceTracker;
	}

	private final void cacheTracker() {
		System.out.println("Caching tracker");
		serviceTracker = new ServiceTracker(HalcyonServletContextListener.getBundleContext(), serviceInterface, null) {
			@Override
			public Object addingService(final ServiceReference reference) {
				if (LOG.isTraceEnabled()) {
					LOG.trace(serviceInterface + " from bundle " + reference.getBundle().getBundleId() + " service being added to jersey resource");
				}
				return super.addingService(reference);
			}

			@Override
			public void remove(final ServiceReference reference) {
				if (LOG.isTraceEnabled()) {
					LOG.trace(serviceInterface + " from bundle " + reference.getBundle().getBundleId() + " service being removed from jersey resource");
				}
				super.remove(reference);
			}

		};
		serviceTracker.open();
	}

}
