package org.hbird.application.webclient;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {
	private static final Logger LOG = LoggerFactory.getLogger(Activator.class);

	@Override
	public void start(final BundleContext context) throws Exception {
		LOG.info("Starting hbird web-client");
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
	}

}
