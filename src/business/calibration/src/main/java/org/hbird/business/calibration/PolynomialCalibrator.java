package org.hbird.business.calibration;

import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class PolynomialCalibrator {
	
	private Map<String, List<Integer>> calibrationsMap;

	public PolynomialCalibrator(Map<String, List<Integer>> calibrationsMap) {
		this.calibrationsMap = calibrationsMap;
	}
	
	public Parameter<?> calibrateParameter(Parameter<?> parameterIn) {
		List<Integer> calibrationPolynomial = calibrationsMap.get(parameterIn.getQualifiedName());
		
		if (calibrationPolynomial != null) {
			// calibration polynomial found
			
			double value = (Double) parameterIn.getValue();
			
			double outValue = 0;
			int term = 0;
			for (Integer currentPolynomial : calibrationPolynomial) {
				outValue += currentPolynomial * Math.pow(value, term);
				term++;
			}
			Parameter<Double> parameter = new HummingbirdParameter<Double>("", "", "", "");
			parameter.setValue(outValue);
			parameterIn = parameter;
		}
		// Is return this a problem?
		return parameterIn;
	}

}
