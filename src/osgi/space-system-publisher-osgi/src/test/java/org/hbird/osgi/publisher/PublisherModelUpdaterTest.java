package org.hbird.osgi.publisher;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PublisherModelUpdaterTest {

	@Mock
	private SpaceSystemPublisher mockPublisher;

	private PublisherModelUpdater updater;

	@Before
	public void test() {
		updater = new PublisherModelUpdater();
		updater.setPublisher(mockPublisher);
	}

	@Test
	public void testModelChanged() {
		updater.modelChanged();

		verify(mockPublisher, times(1)).modelUpdated();
	}

}
