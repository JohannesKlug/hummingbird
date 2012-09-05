package org.hbird.osgi.publisher.provided;

import org.hbird.core.spacesystemmodel.interfaces.SpaceSystemModelUpdateListener;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;

public class PublisherModelUpdater implements SpaceSystemModelUpdateListener {

	private SpaceSystemPublisher publisher;

	@Override
	public void modelChanged() {
		publisher.modelUpdated();
	}

	public SpaceSystemPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

}
