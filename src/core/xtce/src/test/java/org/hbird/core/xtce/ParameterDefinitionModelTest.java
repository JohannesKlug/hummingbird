package org.hbird.core.xtce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.calibration.PolynomialCalibrator;
import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.AbstractParameter;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Mark Doyle
 */
public class ParameterDefinitionModelTest {
	private static final String SSM_URL = "test-parameter-model.xml";

	private static final String INVALID_POLY_SSM_URL = "invalid-poly-model.xml";

	private static final double EXPECTED_LASER_CALIBRATION_VALUE = 70.0;

	private String qualifiedTmPrefix = null;

	private SpaceSystemModel ssm;

	@Before
	public void setUp() throws InvalidSpaceSystemDefinitionException {
		loadModel(SSM_URL);
		assertNotNull(ssm);

		qualifiedTmPrefix = ssm.getName() + ".tm.";
	}

	private final void loadModel(String uri) throws InvalidSpaceSystemDefinitionException {
		final URL url = CommandModelTest.class.getResource(uri);
		ssm = new XtceSpaceSystemModelFactory(url.getPath()).createSpaceSystemModel();
	}

	@Test
	public void testCalibratorCreated() throws UnknownParameterException {
		Parameter<Integer> laserParam = ssm.getIntParameter(qualifiedTmPrefix + "LASER_TEMP");
		assertNotNull(laserParam);

		Calibrator calibrator = ssm.getCalibrator(laserParam.getQualifiedName());
		assertNotNull(calibrator);

		assertTrue(calibrator instanceof PolynomialCalibrator);
	}

	@Test
	public void testCalibration() throws UnknownParameterException, CalibrationException {
		Parameter<Integer> laserParam = ssm.getIntParameter(qualifiedTmPrefix + "LASER_TEMP");
		laserParam.setValue(5);

		Calibrator calibrator = ssm.getCalibrator(laserParam.getQualifiedName());
		AbstractParameter<Double> caliParam = calibrator.calibrate(laserParam);

		assertEquals(EXPECTED_LASER_CALIBRATION_VALUE, caliParam.getValue(), 0.0);
	}

	@Test(expected = InvalidSpaceSystemDefinitionException.class)
	public void testInvalidPolynomialParameterAssociation() throws InvalidSpaceSystemDefinitionException {
		loadModel(INVALID_POLY_SSM_URL);
	}

	@Test
	public void testParameterUnit() throws UnknownParameterException {
		Parameter<Integer> laserParam = ssm.getIntParameter(qualifiedTmPrefix + "LASER_TEMP");
		assertNotNull(laserParam);

		String unit = ssm.getUnitDescription(laserParam.getQualifiedName());
		assertEquals("°C", unit);
	}

}
