package org.hbird.core.commons.tmtc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;

public interface TmTcGroup extends SpaceSystemModelItem {

	String getName();

	Map<String, Parameter<?>> getAllParameters();
	List<Parameter<?>> getAllParametersAsList();

	Map<String, Parameter<Integer>> getIntegerParameters();
	Map<String, Parameter<Long>> getLongParameters();
	Map<String, Parameter<BigDecimal>> getBigDecimalParameters();
	Map<String, Parameter<String>> getStringParameters();
	Map<String, Parameter<Float>> getFloatParameters();
	Map<String, Parameter<Double>> getDoubleParameters();
	Map<String, Parameter<Byte[]>> getRawParameters();


	Parameter<Integer> getIntegerParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<Long> getLongParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<Float> getFloatParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<Double> getDoubleParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<BigDecimal> getBigDecimalParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<String> getStringParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<Byte[]> getRawParameter(String qualifiedName) throws UnknownParameterException;
	Parameter<?> getParameter(String qualifiedName) throws UnknownParameterException;


	void addIntegerParameter(Parameter<Integer> parameter);
	void addLongParameter(Parameter<Long> parameter);
	void addBigDecimalParameter(Parameter<BigDecimal> parameter);
	void addFloatParameter(Parameter<Float> parameter);
	void addDoubleParameter(Parameter<Double> parameter);
	void addStringParameter(Parameter<String> parameter);
	void addRawParameter(Parameter<Byte[]> parameter);

	ParameterGroupReport getParameterReport();
}
