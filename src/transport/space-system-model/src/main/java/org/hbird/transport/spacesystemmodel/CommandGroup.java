package org.hbird.transport.spacesystemmodel;

import java.math.BigDecimal;
import java.util.Set;

import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public interface CommandGroup extends TmTcGroup {

	Set<Parameter<?>> getArguments();
	
	/**
	 * Returns all integer based parameters.
	 * 
	 * @return List of all Integer based parameters.
	 */
	Set<Parameter<Integer>> getIntegerParameters();

	/**
	 * Returns all long based parameters.
	 * 
	 * @return List of all Long based parameters.
	 */
	Set<Parameter<Long>> getLongParameters();


	Set<Parameter<BigDecimal>> getBigDecimalParameters();

	Set<Parameter<String>> getStringParameters();

	Set<Parameter<Float>> getFloatParameters();

	Set<Parameter<Double>> getDoubleParameters();

	Set<Parameter<Byte[]>> getRawParameters();
	
	

	void addIntegerParameter(Parameter<Integer> parameter);

	void addLongParameter(Parameter<Long> parameter);

	void addBigDecimalParameter(Parameter<BigDecimal> parameter);

	void addFloatParameter(Parameter<Float> parameter);

	void addDoubleParameter(Parameter<Double> parameter);

	void addStringParameter(Parameter<String> parameter);

	void addRawParameter(Parameter<Byte[]> parameter);
}
