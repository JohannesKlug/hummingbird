package org.hbird.osgi.publisher;

import org.hbird.core.spacesystemmodel.SpaceSystemModelUpdateListener;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherModelUpdater implements SpaceSystemModelUpdateListener {
	private final static Logger LOG = LoggerFactory.getLogger(PublisherModelUpdater.class);

	private SpaceSystemPublisher publisher;

	@Override
	public void modelChanged() {
		if (publisher != null) {
			publisher.modelUpdated();
		}
		else {
			LOG.error("Could not update publisher as it no longer exists!");
		}
	}

	public SpaceSystemPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

}
