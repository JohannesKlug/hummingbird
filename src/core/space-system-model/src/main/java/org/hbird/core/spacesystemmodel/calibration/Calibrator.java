package org.hbird.core.spacesystemmodel.calibration;

import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.CalibratedParameter;

public interface Calibrator {
	CalibratedParameter calibrate(Parameter<?> parameter) throws CalibrationException;
}
