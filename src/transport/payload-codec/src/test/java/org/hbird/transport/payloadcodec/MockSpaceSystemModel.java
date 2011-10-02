package org.hbird.transport.payloadcodec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;

public class MockSpaceSystemModel implements SpaceSystemModel {
	
	Map<String, ParameterGroup> groups = new HashMap<String, ParameterGroup>();
	Map<String, Parameter<?>> parameters = new LinkedHashMap<String, Parameter<?>>();
	
	Map<String, Parameter<Integer>> intParams = new LinkedHashMap<String, Parameter<Integer>>();
	Map<String, Parameter<Long>> longParams = new LinkedHashMap<String, Parameter<Long>>();
	
	public static final String FUEL_PARAMETER_NAME = "Fuel";
	public static final String SCID_PARAMETER_NAME = "SCID";
	public static final String LASER_TEMP_PARAMETER_NAME = "Laser Temp";
	
	public MockSpaceSystemModel() {
		Parameter<Integer> fuelParam = new HummingbirdParameter<Integer>(FUEL_PARAMETER_NAME, "", "", 12, Endianness.BIG, Encoding.unsigned);
		parameters.put(fuelParam.getName(), fuelParam);
		Parameter<Integer> spacecraftId = new HummingbirdParameter<Integer>(SCID_PARAMETER_NAME, "", "", 32, Endianness.BIG, Encoding.unsigned);
		parameters.put(spacecraftId.getName(), spacecraftId);
		Parameter<Long> laserTemp = new HummingbirdParameter<Long>(LASER_TEMP_PARAMETER_NAME, "", "", 40, Endianness.LITTLE, Encoding.unsigned);
		parameters.put(laserTemp.getName(), laserTemp);

		ParameterGroup testGroup = new HummingbirdParameterGroup("Test group", "", "");
		groups.put(testGroup.getName(), testGroup);

		testGroup.addIntegerParameter(spacecraftId);
		intParams.put(spacecraftId.getName(), spacecraftId);
		testGroup.addIntegerParameter(fuelParam);
		intParams.put(fuelParam.getName(), fuelParam);
		testGroup.addLongParameter(laserTemp);
		longParams.put(laserTemp.getName(), laserTemp);
	}

	@Override
	public ParameterGroup getParameterGroup(String name) throws UnknownParameterGroupException {
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
	public Parameter<?> getParameter(String name) {
		Parameter<?> p = parameters.get(name);
		return p;
	}

	@Override
	public Map<String, Parameter<?>> getAllParameters() {
		return this.parameters;
	}

	@Override
	public List<Parameter<Integer>> getIntegerParameters() {
		return new LinkedList<Parameter<Integer>>(intParams.values());
	}

	@Override
	public List<Parameter<Long>> getLongParameters() {
		return new LinkedList<Parameter<Long>>(longParams.values()); 
	}

	@Override
	public Map<Parameter<?>, List<Object>> getAllParameterRestrictions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Integer> getIntParameter(String name) throws UnknownParameterGroupException {
		Parameter<Integer> p = intParams.get(name);
		if(p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	@Override
	public Parameter<Long> getLongParameter(String name) throws UnknownParameterGroupException {
		Parameter<Long> p = longParams.get(name);
		if(p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

}
