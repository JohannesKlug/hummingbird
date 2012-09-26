package org.hbird.test.rotor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.junit.Before;
import org.junit.Ignore;
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

	private final static int TGT_ZERO = 0;
	private final static int TGT_90 = 90;
	private final static int TGT_180 = 180;

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
		sim.slewRotor(TGT_ZERO, TGT_ZERO);

		sim.tick();

		verify(mockAzimuthParameter).setValue(TGT_ZERO);
		verify(mockElevationParameter).setValue(TGT_ZERO);
	}

	@Test
	@Ignore
	public void testTickWithSlew() throws UnknownParameterGroupException, UnknownParameterException {
		// Set targets to 0, should not cause a slew
		sim.slewRotor(TGT_180, TGT_90);

		sim.tick();

		verify(mockAzimuthParameter).setValue(TGT_180);
		verify(mockElevationParameter).setValue(TGT_90);
	}

}
