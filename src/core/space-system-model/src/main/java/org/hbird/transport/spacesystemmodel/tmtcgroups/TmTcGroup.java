package org.hbird.transport.spacesystemmodel.tmtcgroups;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelItem;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public interface TmTcGroup extends SpaceSystemModelItem {

	int getSizeInBits();

	Map<String, Parameter<?>> getAllParameters();

	Collection<Parameter<Integer>> getIntegerParameters();
	Collection<Parameter<Long>> getLongParameters();
	Collection<Parameter<BigDecimal>> getBigDecimalParameters();
	Collection<Parameter<String>> getStringParameters();
	Collection<Parameter<Float>> getFloatParameters();
	Collection<Parameter<Double>> getDoubleParameters();
	Collection<Parameter<Byte[]>> getRawParameters();


	Parameter<Integer> getIntegerParameter(String name) throws UnknownParameterGroupException;
	Parameter<Long> getLongParameter(String name) throws UnknownParameterGroupException;
	Parameter<Float> getFloatParameter(String name) throws UnknownParameterGroupException;
	Parameter<Double> getDoubleParameter(String name) throws UnknownParameterGroupException;
	Parameter<BigDecimal> getBigDecimalParameter(String name) throws UnknownParameterGroupException;
	Parameter<String> getStringParameter(String name) throws UnknownParameterGroupException;
	Parameter<Byte[]> getRawParameter(String name) throws UnknownParameterGroupException;


	void addIntegerParameter(Parameter<Integer> parameter);
	void addLongParameter(Parameter<Long> parameter);
	void addBigDecimalParameter(Parameter<BigDecimal> parameter);
	void addFloatParameter(Parameter<Float> parameter);
	void addDoubleParameter(Parameter<Double> parameter);
	void addStringParameter(Parameter<String> parameter);
	void addRawParameter(Parameter<Byte[]> parameter);

	void replaceParameterInGroup(Parameter<?> parameter) throws ParameterNotInGroupException;

	ParameterGroup copyAllParameterValues(final ParameterGroup sourceGroup) throws UnknownParameterGroupException;

	ParameterGroupReport getParameterReport();
}
