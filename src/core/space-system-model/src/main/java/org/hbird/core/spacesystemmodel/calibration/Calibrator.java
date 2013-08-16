package org.hbird.core.spacesystemmodel.calibration;

import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.CalibratedParameter;

public interface Calibrator {

	CalibratedParameter calibrateInt(Parameter<Integer> parameter);

	CalibratedParameter calibrateShort(Parameter<Short> parameter);

}
