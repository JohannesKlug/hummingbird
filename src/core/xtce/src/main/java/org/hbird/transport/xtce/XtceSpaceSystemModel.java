package org.hbird.transport.xtce;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;

/**
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class XtceSpaceSystemModel implements SpaceSystemModel {
	private static final long serialVersionUID = 2532805548202927668L;

	private String spacesystemmodelFilename;

	private final Map<String, ParameterGroup> parameterGroups = new HashMap<>();

	private final Map<String, Parameter<Integer>> integerParameters = new LinkedHashMap<>();
	private final Map<String, Parameter<Long>> longParameters = new LinkedHashMap<>();
	private final Map<String, Parameter<BigDecimal>> bigDecimalParameters = new LinkedHashMap<>();
	private final Map<String, Parameter<Float>> floatParameters = new LinkedHashMap<>();
	private final Map<String, Parameter<Double>> doubleParameters = new LinkedHashMap<>();
	private final Map<String, Parameter<String>> stringParameters = new LinkedHashMap<>();
	private final Map<String, Parameter<Byte[]>> rawParameters = new LinkedHashMap<>();

	private final Map<Parameter<?>, List<Object>> restrictions = new HashMap<>();


	public XtceSpaceSystemModel() {
	}


	@Override
	public Parameter<?> getParameter(final String name) {
		return getAllParameters().get(name);
	}

	@Override
	public ParameterGroup getParameterGroup(final String name) throws UnknownParameterGroupException {
		final ParameterGroup container = parameterGroups.get(name);

		if (container == null) {
			throw new UnknownParameterGroupException(parameterGroups, "Your container lookup for '" + name
					+ "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}


	@Override
	public Map<String, Parameter<?>> getAllParameters() {
		HashMap<String, Parameter<?>> all = new HashMap<String, Parameter<?>>();
		all.putAll(integerParameters);
		all.putAll(longParameters);
		return all;
	}

	public String getSpaceSystemModelFilePath() {
		return this.spacesystemmodelFilename;
	}

	@Override
	public Map<Parameter<?>, List<Object>> getAllParameterRestrictions() {
		return restrictions;
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return parameterGroups.values();
	}

	@Override
	public Collection<Parameter<Integer>> getIntegerParameters() {
		return integerParameters.values();
	}

	@Override
	public Collection<Parameter<Long>> getLongParameters() {
		return longParameters.values();
	}

	@Override
	public Parameter<Integer> getIntParameter(final String name) throws UnknownParameterGroupException {
		Parameter<Integer> p = integerParameters.get(name);
		if(p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	@Override
	public Parameter<Long> getLongParameter(final String name) throws UnknownParameterGroupException {
		Parameter<Long> p = longParameters.get(name);
		if(p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	@Override
	public final SpaceSystemModel deepClone(final SpaceSystemModel ssm) {
		return (SpaceSystemModel) SerializationUtils.clone(ssm);
	}

	@Override
	public void replaceParameterInModel(final Parameter<?> newParameter) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}