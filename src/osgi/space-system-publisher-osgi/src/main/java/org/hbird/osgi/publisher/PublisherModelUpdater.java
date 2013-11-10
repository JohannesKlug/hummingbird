package org.hbird.osgi.publisher;

import org.hbird.core.spacesystemmodel.SpaceSystemModelUpdateListener;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherModelUpdater implements SpaceSystemModelUpdateListener {
	private final static Logger LOG = LoggerFactory.getLogger(PublisherModelUpdater.class);

	private SpaceSystemPublisher publisher;

	@Override
	public void modelChanged() {
		if (publisher != null) {
			try {
				publisher.modelUpdated();
			}
			catch (UnavailableSpaceSystemModelException e) {
				LOG.warn("The publisher cannot access a space system model due to {0}", e.getMessage());
			}
		}
		else {
			LOG.error("Could not update space system model as the publisher/publisher service no longer exists!");
		}
	}

	public SpaceSystemPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

}
