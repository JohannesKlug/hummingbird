package org.hbird.transport.xtce;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	private static final Logger LOG = LoggerFactory.getLogger(XtceSpaceSystemModel.class);

	private final Map<Long, ParameterGroup> parameterGroups = new HashMap<>();

	private final Map<Long, List<Object>> restrictions = new HashMap<>();

	public XtceSpaceSystemModel() {
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return parameterGroups.values();
	}

	@Override
	public ParameterGroup getParameterGroup(final long id) throws UnknownParameterGroupException {
		final ParameterGroup container = parameterGroups.get(id);

		if (container == null) {
			throw new UnknownParameterGroupException(parameterGroups, "Your container lookup for '" + id
					+ "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	/**
	 * Iterates over all the parameter groups and creates a list of all their parameters.
	 *
	 * @throws UnknownParameterException
	 */
	@Override
	public Map<Long, Parameter<?>> getAllParameters() {
		Map<Long, Parameter<?>> allParameters = new HashMap<>();
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Long parameterId : pg.getAllParameters().keySet()) {
				allParameters.put(parameterId, pg.getAllParameters().get(parameterId));
			}
		}
		return allParameters;
	}

	@Override
	public Parameter<?> getParameter(final long id) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			if (pg.getAllParameters().containsKey(id)) {
				return pg.getParameter(id);
			}
		}
		throw new UnknownParameterException(id);
	}

	@Override
	public Parameter<Integer> getIntParameter(final long id) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			if (pg.getIntegerParameters().containsKey(id)) {
				return pg.getIntegerParameter(id);
			}
		}
		throw new UnknownParameterException(id);
	}

	@Override
	public Parameter<Long> getLongParameter(final long id) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			if (pg.getLongParameters().containsKey(id)) {
				return pg.getLongParameter(id);
			}
		}
		throw new UnknownParameterException(id);
	}

	@Override
	public Map<Long, List<Object>> getAllPayloadRestrictions() {
		return restrictions;
	}

	@Override
	public void replaceParameterInModel(final long id, final Parameter<?> newParameter) throws UnknownParameterException {
		for (ParameterGroup pg : this.parameterGroups.values()) {
			if(pg.getAllParameters().put(id, newParameter) != null) {
				// Parameter replaced, no need to iterate over the rest of the parameters.
				break;
			}
		}
		throw new UnknownParameterException(newParameter.getName());
	}

	@Override
	public Map<Long, Parameter<Integer>> getAllIntegerParameters() {
		Map<Long, Parameter<Integer>> allParameters = new HashMap<>();
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Long parameterId : pg.getIntegerParameters().keySet()) {
				allParameters.put(parameterId, pg.getIntegerParameters().get(parameterId));
			}
		}
		return allParameters;
	}

	@Override
	public Map<Long, Parameter<Long>> getAllLongParameters() {
		Map<Long, Parameter<Long>> allParameters = new HashMap<>();
		for (ParameterGroup pg : this.parameterGroups.values()) {
			for (Long parameterId : pg.getLongParameters().keySet()) {
				allParameters.put(parameterId, pg.getLongParameters().get(parameterId));
			}
		}
		return allParameters;
	}

	@Override
	public Parameter<BigDecimal> getBigDecimalParameter(final long id) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<String> getStringParameter(final long id) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Float> getFloatParameter(final long id) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Double> getDoubleParameter(final long id) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Byte[]> getRawParameter(final long id) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Long, Parameter<BigDecimal>> getAllBigDecimalParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Long, Parameter<Float>> getAllFloatParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Long, Parameter<Double>> getAllDoubleParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Long, Parameter<String>> getAllStringParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Long, Parameter<Byte[]>> getAllRawParameters() {
		throw new UnsupportedOperationException();
	}

}