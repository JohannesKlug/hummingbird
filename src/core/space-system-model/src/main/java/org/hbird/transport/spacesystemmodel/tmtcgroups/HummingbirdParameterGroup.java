package org.hbird.transport.spacesystemmodel.tmtcgroups;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

/**
 * TELEMETRY
 *
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class HummingbirdParameterGroup implements ParameterGroup {
	private static final long serialVersionUID = 7810839127277387757L;

	private final String name;
	private final String shortDescription;
	private final String longDescription;

	private Map<Long, Parameter<Integer>> integerParameters;
	private Map<Long, Parameter<Long>> longParameters;
	private Map<Long, Parameter<Float>> floatParameters;
	private Map<Long, Parameter<Double>> doubleParameters;
	private Map<Long, Parameter<BigDecimal>> bigDecimalParameters;
	private Map<Long, Parameter<String>> stringParameters;
	private Map<Long, Parameter<Byte[]>> rawParameters;

	private final ParameterGroupReport parameterReport = new ParameterGroupReport();

	/** List of Parameters belonging to this Group */
	private final Map<Long, Parameter<?>> parameters = new LinkedHashMap<Long, Parameter<?>>();

	/**
	 * Constructor of the ParameterGroup class.
	 *
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 *
	 */
	public HummingbirdParameterGroup(final String name, final String shortDescription, final String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
	}

	@Override
	public Map<Long, Parameter<?>> getAllParameters() {
		return parameters;
	}

	@Override
	public Map<Long, Parameter<Integer>> getIntegerParameters() {
		return integerParameters;
	}

	@Override
	public Map<Long, Parameter<Long>> getLongParameters() {
		return longParameters;
	}

	@Override
	public Map<Long, Parameter<Float>> getFloatParameters() {
		return floatParameters;
	}

	@Override
	public Map<Long, Parameter<Double>> getDoubleParameters() {
		return doubleParameters;
	}

	@Override
	public Map<Long, Parameter<BigDecimal>> getBigDecimalParameters() {
		return bigDecimalParameters;
	}

	@Override
	public Map<Long, Parameter<String>> getStringParameters() {
		return stringParameters;
	}

	@Override
	public Map<Long, Parameter<Byte[]>> getRawParameters() {
		return rawParameters;
	}

	@Override
	public void addIntegerParameter(final long id, final Parameter<Integer> parameter) {
		if (this.integerParameters == null) {
			this.integerParameters = new LinkedHashMap<Long, Parameter<Integer>>();
		}
		this.integerParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementIntCount();
	}

	@Override
	public void addLongParameter(final long id, final Parameter<Long> parameter) {
		if (this.longParameters == null) {
			this.longParameters = new LinkedHashMap<Long, Parameter<Long>>();
		}
		this.longParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementLongCount();
	}

	@Override
	public void addBigDecimalParameter(final long id, final Parameter<BigDecimal> parameter) {
		if (this.bigDecimalParameters == null) {
			this.bigDecimalParameters = new LinkedHashMap<Long, Parameter<BigDecimal>>();
		}
		this.bigDecimalParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementBigDecimalCount();
	}

	@Override
	public void addFloatParameter(final long id, final Parameter<Float> parameter) {
		if (this.floatParameters == null) {
			this.floatParameters = new LinkedHashMap<Long, Parameter<Float>>();
		}
		this.floatParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementFloatCount();
	}

	@Override
	public void addDoubleParameter(final long id, final Parameter<Double> parameter) {
		if (this.doubleParameters == null) {
			this.doubleParameters = new LinkedHashMap<Long, Parameter<Double>>();
		}
		this.doubleParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementDoubleCount();
	}

	@Override
	public void addStringParameter(final long id, final Parameter<String> parameter) {
		if (this.stringParameters == null) {
			this.stringParameters = new LinkedHashMap<Long, Parameter<String>>();
		}
		this.stringParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementStringCount();
	}

	@Override
	public void addRawParameter(final long id, final Parameter<Byte[]> parameter) {
		if (this.rawParameters == null) {
			this.rawParameters = new LinkedHashMap<Long, Parameter<Byte[]>>();
		}
		this.rawParameters.put(id, parameter);
		this.parameters.put(id, parameter);
		this.parameterReport.incrementRawCount();
	}

	@Override
	public ParameterGroupReport getParameterReport() {
		return this.parameterReport;
	}

	// Cast suppress reasoning: Parameter names must be unique so if a Param is found in a specific type collection
	// it is safe to cast.
	@SuppressWarnings("unchecked")
	@Override
	public void replaceParameterInGroup(final long id, final Parameter<?> parameter) throws ParameterNotInGroupException {
		String pname = parameter.getName();
		if (integerParameters.containsKey(pname)) {
			integerParameters.put(id, (Parameter<Integer>) parameter);
		}
		else if (longParameters.containsKey(pname)) {
			longParameters.put(id, (Parameter<Long>) parameter);
		}
		else if (bigDecimalParameters.containsKey(pname)) {
			bigDecimalParameters.put(id, (Parameter<BigDecimal>) parameter);
		}
		else if (floatParameters.containsKey(pname)) {
			floatParameters.put(id, (Parameter<Float>) parameter);
		}
		else if (doubleParameters.containsKey(pname)) {
			doubleParameters.put(id, (Parameter<Double>) parameter);
		}
		else if (stringParameters.containsKey(pname)) {
			stringParameters.put(id, (Parameter<String>) parameter);
		}
		else if (rawParameters.containsKey(pname)) {
			rawParameters.put(id, (Parameter<Byte[]>) parameter);
		}
		else {
			throw new ParameterNotInGroupException(parameter);
		}

		if (parameters.containsKey(pname)) {
			parameters.put(id, parameter);
		}
	}

	@Override
	public Parameter<Integer> getIntegerParameter(final long id) throws UnknownParameterGroupException {
		Parameter<Integer> p = integerParameters.get(name);
		if (p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	@Override
	public Parameter<Long> getLongParameter(final long id) throws UnknownParameterGroupException {
		Parameter<Long> p = longParameters.get(name);
		if (p == null) {
			throw new UnknownParameterGroupException(name);
		}
		return p;
	}

	@Override
	public ParameterGroup copyAllParameterValues(final ParameterGroup sourceGroup) throws UnknownParameterGroupException {
		// Ints
		for(long id : integerParameters.keySet()) {
			getIntegerParameter(id).setValue(sourceGroup.getIntegerParameter(id).getValue());
		}

		for(long id : longParameters.keySet()) {
			getLongParameter(id).setValue(sourceGroup.getLongParameter(id).getValue());
		}
		// FIXME Add support for other types.

		return this;
	}

	@Override
	public Parameter<Float> getFloatParameter(final long id) throws UnknownParameterGroupException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Double> getDoubleParameter(final long id) throws UnknownParameterGroupException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<BigDecimal> getBigDecimalParameter(final long id) throws UnknownParameterGroupException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<String> getStringParameter(final long id) throws UnknownParameterGroupException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Byte[]> getRawParameter(final long id) throws UnknownParameterGroupException {
		throw new UnsupportedOperationException();
	}

}
