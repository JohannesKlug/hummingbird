package org.hbird.transport.spacesystemmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;


/**
 * TODO The standard interface of a ParameterGroup.
 */
public interface ParameterGroup extends TmTcGroup, Serializable {


	/**
	 * Get all the Parameters that belong to this ParameterGroup
	 *
	 * @return List of off Parameters belonging to this Group.
	 */
	Collection<Parameter<?>> getAllParameters();

	void addRestriction(Object payloadLayoutId);

	Object getRestriction();

	/**
	 * Returns all integer based parameters.
	 *
	 * @return List of all Integer based parameters.
	 */
	Collection<Parameter<Integer>> getIntegerParameters();

	/**
	 * Returns all long based parameters.
	 *
	 * @return List of all Long based parameters.
	 */
	Collection<Parameter<Long>> getLongParameters();


	Collection<Parameter<BigDecimal>> getBigDecimalParameters();

	Collection<Parameter<String>> getStringParameters();

	Collection<Parameter<Float>> getFloatParameters();

	Collection<Parameter<Double>> getDoubleParameters();

	Collection<Parameter<Byte[]>> getRawParameters();

	void addIntegerParameter(Parameter<Integer> parameter);

	void addLongParameter(Parameter<Long> parameter);

	void addBigDecimalParameter(Parameter<BigDecimal> parameter);

	void addFloatParameter(Parameter<Float> parameter);

	void addDoubleParameter(Parameter<Double> parameter);

	void addStringParameter(Parameter<String> parameter);

	void addRawParameter(Parameter<Byte[]> parameter);

	void replaceParameterInGroup(Parameter<?> parameter) throws ParameterNotInGroupException;


}
