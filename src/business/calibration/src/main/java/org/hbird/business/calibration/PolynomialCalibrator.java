package org.hbird.business.calibration;

import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class PolynomialCalibrator {
	
	private Map<String, List<Double>> calibrationsMap;

	public PolynomialCalibrator(Map<String, List<Double>> calibrationsMap) {
		this.calibrationsMap = calibrationsMap;
	}
	
	public Parameter<Double> calibrateParameter(Parameter<?> parameterIn) {
		List<Double> calibrationPolynomial = calibrationsMap.get(parameterIn.getQualifiedName());
		
//		if (calibrationPolynomial != null) {
			// calibration polynomial found
			
			double value = Double.parseDouble(parameterIn.getValue().toString());

			double outValue = 0;
			int term = 0;
			for (Double currentPolynomial : calibrationPolynomial) {
				outValue += currentPolynomial * Math.pow(value, term);
				term++;
			}
			Parameter<Double> parameter = new HummingbirdParameter<Double>("", "", "", "");
			parameter.setValue(outValue);
			return parameter;
//			parameterIn = parameter;
//		}
//		return (Parameter<Double>) parameterIn;
	}

}
