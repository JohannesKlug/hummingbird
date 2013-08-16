package org.hbird.core.spacesystemmodel.calibration;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public CalibratedParameter calibrateInt(Parameter<Integer> parameter) {
		int raw = parameter.getValue();
		double calibrated = 0;
		for (Term term : terms) {
			calibrated += term.getCoefficient() * Math.pow(raw, term.getExponent());
		}

		CalibratedParameter calibratedParameter = new CalibratedParameter(parameter.getQualifiedName(), parameter.getName(), parameter.getShortDescription(),
				parameter.getLongDescription());
		calibratedParameter.setValue(calibrated);

		return calibratedParameter;
	}

	@Override
	public CalibratedParameter calibrateShort(Parameter<Short> parameter) {
		throw new UnsupportedOperationException("Not implemented yet! File an issue report");
	}

}
