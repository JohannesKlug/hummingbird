package org.hbird.transport.spacesystemmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;


/**
 * Interface to create Space System Model factories.
 *
 * The models are created based on an underlying space system model, defining the structure of the space system,
 * including the telemetry and command structures. The space system can be expressed in different ways, such as through
 * the OMG/CCSDS XTCE, ESA MIB/PUS model, or any other DSL. The model factory implementation will depend on a data
 * structure in a specific format, but hides this implementation to the monitoring component.
 */
public interface SpaceSystemModel extends Serializable {

	String HUMMINGBIRD_PROCESSED_HEADER = "HEADER";

	// Parameter Group related
	ParameterGroup getParameterGroup(String name) throws UnknownParameterGroupException;
	Collection<ParameterGroup> getAllParameterGroups();

	// Parameter related
	Parameter<?> getParameter(String name);
	Parameter<Integer> getIntParameter(String name) throws UnknownParameterGroupException;
	Parameter<Long> getLongParameter(String name) throws UnknownParameterGroupException;
	Parameter<BigDecimal> getBigDecimalParameter(String name);
	Parameter<String> getStringParameter(String name);
	Parameter<Float> getFloatParameter(String name);
	Parameter<Double> getDoubleParameter(String name);
	Parameter<Byte[]> getRawParameter(String name);
	Map<String, Parameter<?>> getAllParameters();
	void replaceParameterInModel(final Parameter<?> newParameter);

	Collection<Parameter<Integer>> getIntegerParameters();
	Collection<Parameter<Long>> getLongParameters();


	// Payload restriction related
	Map<Long, List<Object>> getAllPayloadRestrictions();


	// Utility
//	SpaceSystemModel deepClone(final SpaceSystemModel ssm);
}