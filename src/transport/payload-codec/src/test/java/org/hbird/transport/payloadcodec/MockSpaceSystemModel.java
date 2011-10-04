package org.hbird.transport.payloadcodec;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;

public class MockSpaceSystemModel implements SpaceSystemModel {
	private static final long serialVersionUID = -345641886444350845L;

	Map<String, ParameterGroup> groups = new HashMap<String, ParameterGroup>();
//	Map<String, Parameter<?>> parameters = new LinkedHashMap<String, Parameter<?>>();

	Map<String, Parameter<Integer>> intParams = new LinkedHashMap<String, Parameter<Integer>>();
	Map<String, Parameter<Long>> longParams = new LinkedHashMap<String, Parameter<Long>>();

	public static final String FUEL_PARAMETER_NAME = "Fuel";
	public static final String SCID_PARAMETER_NAME = "SCID";
	public static final String LASER_TEMP_PARAMETER_NAME = "Laser Temp";

	public MockSpaceSystemModel() {
		Parameter<Integer> fuelParam = new HummingbirdParameter<Integer>(FUEL_PARAMETER_NAME, "", "", 12, Endianness.BIG, Encoding.unsigned);
//		parameters.put(fuelParam.getName(), fuelParam);
		Parameter<Integer> spacecraftId = new HummingbirdParameter<Integer>(SCID_PARAMETER_NAME, "", "", 32, Endianness.BIG, Encoding.unsigned);
//		parameters.put(spacecraftId.getName(), spacecraftId);
		Parameter<Long> laserTemp = new HummingbirdParameter<Long>(LASER_TEMP_PARAMETER_NAME, "", "", 40, Endianness.LITTLE, Encoding.unsigned);
//		parameters.put(laserTemp.getName(), laserTemp);

		ParameterGroup testGroup = new HummingbirdParameterGroup("Test group", "", "");
		groups.put(testGroup.getName(), testGroup);

		intParams.put(spacecraftId.getName(), spacecraftId);
		testGroup.addIntegerParameter(intParams.get(spacecraftId.getName()));
		intParams.put(fuelParam.getName(), fuelParam);
		testGroup.addIntegerParameter(intParams.get(fuelParam.getName()));
		longParams.put(laserTemp.getName(), laserTemp);
		testGroup.addLongParameter(longParams.get(laserTemp.getName()));
	}

	@Override
	public ParameterGroup getParameterGroup(final String name) throws UnknownParameterGroupException {
		ParameterGroup group = groups.get(name);
		if(group == null) {
			throw new UnknownParameterGroupException(name);
		}
		return group;
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return groups.values();
	}

	@Override
	public Parameter<?> getParameter(final String name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Order not guaranteed!
	 */
	@Override
	public Map<String, Parameter<?>> getAllParameters() {
		HashMap<String, Parameter<?>> all = new HashMap<String, Parameter<?>>();
		all.putAll(intParams);
		all.putAll(longParams);
		return all;
	}

	@Override
	public Collection<Parameter<Integer>> getIntegerParameters() {
		return intParams.values();
	}

	@Override
	public Collection<Parameter<Long>> getLongParameters() {
		return longParams.values();
	}

	@Override
	public Map<Parameter<?>, List<Object>> getAllParameterRestrictions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Integer> getIntParameter(final String name) throws UnknownParameterGroupException {
		Parameter<Integer> p = intParams.get(name);
		if(p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	@Override
	public Parameter<Long> getLongParameter(final String name) throws UnknownParameterGroupException {
		Parameter<Long> p = longParams.get(name);
		if(p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	// Cast suppress reasoning: Parameter names must be unique so if a Param is found in a specific type collection
	// it is safe to cast.
	@Override
	@SuppressWarnings("unchecked")
	public void replaceParameterInModel(final Parameter<?> newParam) {
		if(intParams.containsKey(newParam.getName())) {
			intParams.put(newParam.getName(), (Parameter<Integer>) newParam);
		}
		else if(longParams.containsKey(newParam.getName())) {
			longParams.put(newParam.getName(), (Parameter<Long>) newParam);
		}
		else {
			System.out.println("MOCK MODEL CURRENTLY ONLY SUPPORTS LONG AND INT");
		}
	}

	@Override
	public final SpaceSystemModel deepClone(final SpaceSystemModel ssm) {
		return (SpaceSystemModel) SerializationUtils.clone(ssm);
	}

}
