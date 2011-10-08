package org.hbird.transport.spacesystemmodel.tmtcgroups;

import java.math.BigDecimal;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelItem;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public interface TmTcGroup extends SpaceSystemModelItem {

	String getName();

	Map<String, Parameter<?>> getAllParameters();

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


	void addIntegerParameter(String qualifiedName, Parameter<Integer> parameter);
	void addLongParameter(String qualifiedName, Parameter<Long> parameter);
	void addBigDecimalParameter(String qualifiedName, Parameter<BigDecimal> parameter);
	void addFloatParameter(String qualifiedName, Parameter<Float> parameter);
	void addDoubleParameter(String qualifiedName, Parameter<Double> parameter);
	void addStringParameter(String qualifiedName, Parameter<String> parameter);
	void addRawParameter(String qualifiedName, Parameter<Byte[]> parameter);

	void replaceParameterInGroup(String qualifiedName, Parameter<?> parameter) throws ParameterNotInGroupException;

	ParameterGroup copyAllParameterValues(final ParameterGroup sourceGroup) throws UnknownParameterGroupException, UnknownParameterException;

	ParameterGroupReport getParameterReport();
}
