package org.hbird.core.spacesystemmodel.calibration;

import java.util.ArrayList;
import java.util.List;

import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.CalibratedParameter;

/**
 * 
 * @author Mark Doyle
 * 
 */
public class PolynomialCalibrator implements Calibrator {

	private final List<Term> terms;

	public PolynomialCalibrator(Term... terms) {
		this.terms = new ArrayList<Term>(terms.length);
		for (Term t : terms) {
			this.terms.add(t);
		}
	}

	public PolynomialCalibrator(List<Term> terms) {
		this.terms = terms;
	}

	/**
	 * Calibrates {@link Number} parameters returning a new {@link CalibratedParameter} holding the result.
	 */
	@Override
	public CalibratedParameter calibrate(Parameter<?> parameter) throws CalibrationException {
		Object raw = parameter.getValue();
		if (raw instanceof Number) {
			double calibrated = calibrate(((Number) raw).doubleValue());
			return CalibratedParameter.createFromParameterAndValue(parameter, calibrated);
		}
		// This is a defensive exception, really the space system model factory should not allow a polynomial calibrator
		// to be associated to a non-number parameter.
		throw new CalibrationException(
				this.getClass().getName()
						+ " cannot calibrated a non-number parameter! The space system model has probably been defined incorrectly but really the space system model factory you have used should not allow this to happen.");
	}

	/**
	 * Performs the calibration calculation based upon this instances list of {@link Term}s.
	 * 
	 * @param raw
	 * @return
	 */
	private final double calibrate(double raw) {
		double calibrated = 0;
		for (Term term : terms) {
			calibrated += term.getCoefficient() * Math.pow(raw, term.getExponent());
		}
		return calibrated;
	}

}
