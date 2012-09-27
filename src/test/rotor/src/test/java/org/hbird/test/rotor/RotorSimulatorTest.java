package org.hbird.test.rotor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RotorSimulatorTest {

	private RotorSimulator sim;

	@Mock
	private SpaceSystemPublisher mockPublisher;

	@Mock
	private ParameterGroup mockParameterGroup;

	@Mock
	private Parameter<Integer> mockAzimuthParameter;

	@Mock
	private Parameter<Integer> mockElevationParameter;

	@Before
	public void setupMockModel() throws UnknownParameterException, UnknownParameterGroupException {
		when(mockPublisher.getParameterGroup("Stock6.tm.PositionPayload")).thenReturn(mockParameterGroup);
		when(mockParameterGroup.getIntegerParameter("Stock6.tm.Azimuth")).thenReturn(mockAzimuthParameter);
		when(mockParameterGroup.getIntegerParameter("Stock6.tm.Elevation")).thenReturn(mockElevationParameter);
	}

	@Before
	public void setUpBefore() throws Exception {
		sim = new RotorSimulator();
		sim.setPublisher(mockPublisher);
	}

	@Test
	public void testTickNoSlew() throws UnknownParameterGroupException, UnknownParameterException {
		// Set targets to 0, should not cause a slew
		sim.slewRotor(0, 0);

		sim.tick();

		verify(mockAzimuthParameter).setValue(0);
		verify(mockElevationParameter).setValue(0);
	}

	@Test
	public void testTickWithSlew() throws UnknownParameterGroupException, UnknownParameterException, InterruptedException {
		// Set targets to 0, should not cause a slew
		sim.slewRotor(10, 9);

		// Give the rotor sim time to move to target.
		Thread.sleep(2000);

		// tick telemetry generation
		sim.tick();

		verify(mockAzimuthParameter).setValue(10);
		verify(mockElevationParameter).setValue(9);
	}

}
