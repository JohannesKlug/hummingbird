package org.hbird.core.spacesystemmodel.calibration;

import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.AbstractParameter;

public interface Calibrator {
	AbstractParameter<Double> calibrate(Parameter<?> parameter) throws CalibrationException;
}
