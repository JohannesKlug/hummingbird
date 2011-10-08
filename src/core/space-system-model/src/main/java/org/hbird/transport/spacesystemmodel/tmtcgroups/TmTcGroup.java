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

	Map<Long, Parameter<?>> getAllParameters();

	Map<Long, Parameter<Integer>> getIntegerParameters();
	Map<Long, Parameter<Long>> getLongParameters();
	Map<Long, Parameter<BigDecimal>> getBigDecimalParameters();
	Map<Long, Parameter<String>> getStringParameters();
	Map<Long, Parameter<Float>> getFloatParameters();
	Map<Long, Parameter<Double>> getDoubleParameters();
	Map<Long, Parameter<Byte[]>> getRawParameters();


	Parameter<Integer> getIntegerParameter(long id) throws UnknownParameterException;
	Parameter<Long> getLongParameter(long id) throws UnknownParameterException;
	Parameter<Float> getFloatParameter(long id) throws UnknownParameterException;
	Parameter<Double> getDoubleParameter(long id) throws UnknownParameterException;
	Parameter<BigDecimal> getBigDecimalParameter(long id) throws UnknownParameterException;
	Parameter<String> getStringParameter(long id) throws UnknownParameterException;
	Parameter<Byte[]> getRawParameter(long id) throws UnknownParameterException;
	Parameter<?> getParameter(long id) throws UnknownParameterException;


	void addIntegerParameter(long id, Parameter<Integer> parameter);
	void addLongParameter(long id, Parameter<Long> parameter);
	void addBigDecimalParameter(long id, Parameter<BigDecimal> parameter);
	void addFloatParameter(long id, Parameter<Float> parameter);
	void addDoubleParameter(long id, Parameter<Double> parameter);
	void addStringParameter(long id, Parameter<String> parameter);
	void addRawParameter(long id, Parameter<Byte[]> parameter);

	void replaceParameterInGroup(long id, Parameter<?> parameter) throws ParameterNotInGroupException;

	ParameterGroup copyAllParameterValues(final ParameterGroup sourceGroup) throws UnknownParameterGroupException, UnknownParameterException;

	ParameterGroupReport getParameterReport();
}
