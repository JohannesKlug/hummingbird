package org.hbird.application.calibration;

import java.util.Map;

import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;

public class InMemoryCalibrator {
	private Map<String, Calibrator> calibrators;

	public InMemoryCalibrator(Map<String, Calibrator> calibrators) {
		this.calibrators = calibrators;
	}

	/**
	 * When given a parameter this method performs the calibration with the calibrator associated with the parameter. If
	 * there is no associated calibration the the raw parameter is simply returned.
	 * 
	 * @param parameter
	 * @return
	 * @throws CalibrationException
	 */
	public Parameter<?> calibrate(Parameter<?> parameter) throws CalibrationException {
		if (calibrators == null) {
			throw new CalibrationException("Cannot perform calibration on " + parameter.getQualifiedName() + " as there is no calibration data available.");
		}

		Calibrator calibrator = calibrators.get(parameter.getQualifiedName());

		if (calibrator != null) {
			return calibrator.calibrate(parameter);
		}

		return parameter;
	}

	public Map<String, Calibrator> getCalibrators() {
		return calibrators;
	}

	public void setCalibrators(Map<String, Calibrator> calibrators) {
		this.calibrators = calibrators;
	}

}
