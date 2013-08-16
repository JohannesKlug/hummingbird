package org.hbird.application.calibration;

import java.util.Map;

import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;

public class ServiceBasedCalibrator {

	private SpaceSystemPublisher publisherService;

	private final Map<String, Calibrator> calibrators;

	public ServiceBasedCalibrator() {
		calibrators = publisherService.getAllCalibrators();
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
		Calibrator calibrator = calibrators.get(parameter);

		if (calibrator != null) {
			return calibrator.calibrate(parameter);
		}

		return parameter;
	}
}
