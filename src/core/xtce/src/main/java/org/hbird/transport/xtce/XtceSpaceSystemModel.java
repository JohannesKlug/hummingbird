package org.hbird.transport.xtce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterException;
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

	private final Map<Long, List<Object>> restrictions = new HashMap<>();

	public XtceSpaceSystemModel() {
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return parameterGroups.values();
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

	/**
	 * Iterates over all the parameter groups and creates a list of all their parameters.
	 */
	@Override
	public Collection<Parameter<?>> getAllParameters() {
		List<Parameter<?>> allParameters = new ArrayList<>();
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<?> p : pg.getAllParameters().values()) {
				allParameters.add(p);
			}
		}
		return allParameters;
	}

	@Override
	public Parameter<?> getParameter(final String name) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<?> p : pg.getAllParameters().values()) {
				if (StringUtils.equals(name, p.getName())) {
					return p;
				}
			}
		}
		throw new UnknownParameterException(name);
	}

	@Override
	public Parameter<Integer> getIntParameter(final String name) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<Integer> p : pg.getIntegerParameters()) {
				if (StringUtils.equals(name, p.getName())) {
					return p;
				}
			}
		}
		throw new UnknownParameterException(name);
	}

	@Override
	public Parameter<Long> getLongParameter(final String name) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<Long> p : pg.getLongParameters()) {
				if (StringUtils.equals(name, p.getName())) {
					return p;
				}
			}
		}
		throw new UnknownParameterException(name);
	}

	@Override
	public Map<Long, List<Object>> getAllPayloadRestrictions() {
		return restrictions;
	}

	@Override
	public void replaceParameterInModel(final Parameter<?> newParameter) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<?> p : pg.getAllParameters().values()) {
				if (StringUtils.equals(newParameter.getName(), p.getName())) {
					p = newParameter;
					return;
				}
			}
		}
		throw new UnknownParameterException(newParameter.getName());
	}

	@Override
	public Parameter<BigDecimal> getBigDecimalParameter(final String name) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<String> getStringParameter(final String name) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Float> getFloatParameter(final String name) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Double> getDoubleParameter(final String name) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Byte[]> getRawParameter(final String name) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Parameter<Integer>> getAllIntegerParameters() {
		List<Parameter<Integer>> parameters = new ArrayList<>();
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<Integer> p : pg.getIntegerParameters()) {
				parameters.add(p);
			}
		}
		return parameters;
	}

	@Override
	public Collection<Parameter<Long>> getAllLongParameters() {
		List<Parameter<Long>> parameters = new ArrayList<>();
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Parameter<Long> p : pg.getLongParameters()) {
				parameters.add(p);
			}
		}
		return parameters;
	}

}