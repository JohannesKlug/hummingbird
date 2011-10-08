package org.hbird.transport.spacesystemmodel.tmtcgroups;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterException;
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

	private final String qualifiedName;
	private final String name;
	private final String shortDescription;
	private final String longDescription;

	private final Map<String, Parameter<?>> parameters = new LinkedHashMap<>();
	private Map<String, Parameter<Integer>> integerParameters;
	private Map<String, Parameter<Long>> longParameters;
	private Map<String, Parameter<Float>> floatParameters;
	private Map<String, Parameter<Double>> doubleParameters;
	private Map<String, Parameter<BigDecimal>> bigDecimalParameters;
	private Map<String, Parameter<String>> stringParameters;
	private Map<String, Parameter<Byte[]>> rawParameters;

	private final ParameterGroupReport parameterReport = new ParameterGroupReport();

	/** List of Parameters belonging to this Group */

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
	public HummingbirdParameterGroup(final String qualifiedName, final String name, final String shortDescription, final String longDescription) {
		this.name = name;
		this.qualifiedName = qualifiedName;
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
	public Map<String, Parameter<?>> getAllParameters() {
		return parameters;
	}

	@Override
	public Map<String, Parameter<Integer>> getIntegerParameters() {
		return integerParameters;
	}

	@Override
	public Map<String, Parameter<Long>> getLongParameters() {
		return longParameters;
	}

	@Override
	public Map<String, Parameter<Float>> getFloatParameters() {
		return floatParameters;
	}

	@Override
	public Map<String, Parameter<Double>> getDoubleParameters() {
		return doubleParameters;
	}

	@Override
	public Map<String, Parameter<BigDecimal>> getBigDecimalParameters() {
		return bigDecimalParameters;
	}

	@Override
	public Map<String, Parameter<String>> getStringParameters() {
		return stringParameters;
	}

	@Override
	public Map<String, Parameter<Byte[]>> getRawParameters() {
		return rawParameters;
	}

	@Override
	public void addIntegerParameter(final String qualifiedName, final Parameter<Integer> parameter) {
		if (this.integerParameters == null) {
			this.integerParameters = new LinkedHashMap<>();
		}
		this.integerParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
		this.parameterReport.incrementIntCount();
	}

	@Override
	public void addLongParameter(final String qualifiedName, final Parameter<Long> parameter) {
		if (this.longParameters == null) {
			this.longParameters = new LinkedHashMap<>();
		}
		this.longParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
		this.parameterReport.incrementLongCount();
	}

	@Override
	public void addBigDecimalParameter(final String qualifiedName, final Parameter<BigDecimal> parameter) {
		if (this.bigDecimalParameters == null) {
			this.bigDecimalParameters = new LinkedHashMap<>();
		}
		this.bigDecimalParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
		this.parameterReport.incrementBigDecimalCount();
	}

	@Override
	public void addFloatParameter(final String qualifiedName, final Parameter<Float> parameter) {
		if (this.floatParameters == null) {
			this.floatParameters = new LinkedHashMap<>();
		}
		this.floatParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
		this.parameterReport.incrementFloatCount();
	}

	@Override
	public void addDoubleParameter(final String qualifiedName, final Parameter<Double> parameter) {
		if (this.doubleParameters == null) {
			this.doubleParameters = new LinkedHashMap<>();
		}
		this.doubleParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
		this.parameterReport.incrementDoubleCount();
	}

	@Override
	public void addStringParameter(final String qualifiedName, final Parameter<String> parameter) {
		if (this.stringParameters == null) {
			this.stringParameters = new LinkedHashMap<>();
		}
		this.stringParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
		this.parameterReport.incrementStringCount();
	}

	@Override
	public void addRawParameter(final String qualifiedName, final Parameter<Byte[]> parameter) {
		if (this.rawParameters == null) {
			this.rawParameters = new LinkedHashMap<>();
		}
		this.rawParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
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
	public void replaceParameterInGroup(final String qualifiedName, final Parameter<?> parameter) throws ParameterNotInGroupException {
		String pname = parameter.getName();
		if (integerParameters.containsKey(pname)) {
			integerParameters.put(qualifiedName, (Parameter<Integer>) parameter);
		}
		else if (longParameters.containsKey(pname)) {
			longParameters.put(qualifiedName, (Parameter<Long>) parameter);
		}
		else if (bigDecimalParameters.containsKey(pname)) {
			bigDecimalParameters.put(qualifiedName, (Parameter<BigDecimal>) parameter);
		}
		else if (floatParameters.containsKey(pname)) {
			floatParameters.put(qualifiedName, (Parameter<Float>) parameter);
		}
		else if (doubleParameters.containsKey(pname)) {
			doubleParameters.put(qualifiedName, (Parameter<Double>) parameter);
		}
		else if (stringParameters.containsKey(pname)) {
			stringParameters.put(qualifiedName, (Parameter<String>) parameter);
		}
		else if (rawParameters.containsKey(pname)) {
			rawParameters.put(qualifiedName, (Parameter<Byte[]>) parameter);
		}
		else {
			throw new ParameterNotInGroupException(parameter);
		}

		if (parameters.containsKey(pname)) {
			parameters.put(qualifiedName, parameter);
		}
	}

	@Override
	public Parameter<Integer> getIntegerParameter(final String qualifiedName) throws UnknownParameterException {
		Parameter<Integer> p = integerParameters.get(qualifiedName);
		if (p == null) {
			throw new UnknownParameterException(qualifiedName);
		}
		return p;
	}

	@Override
	public Parameter<Long> getLongParameter(final String qualifiedName) throws UnknownParameterException {
		Parameter<Long> p = longParameters.get(qualifiedName);
		if (p == null) {
			throw new UnknownParameterException(qualifiedName);
		}
		return p;
	}

	@Override
	public ParameterGroup copyAllParameterValues(final ParameterGroup sourceGroup) throws UnknownParameterGroupException, UnknownParameterException {
		// Ints
		for(String qualifiedName : integerParameters.keySet()) {
			getIntegerParameter(qualifiedName).setValue(sourceGroup.getIntegerParameter(qualifiedName).getValue());
		}

		for(String qualifiedName : longParameters.keySet()) {
			getLongParameter(qualifiedName).setValue(sourceGroup.getLongParameter(qualifiedName).getValue());
		}
		// FIXME Add support for other types.

		return this;
	}


	@Override
	public Parameter<?> getParameter(final String qualifiedName) throws UnknownParameterException {
		Parameter<?> p = parameters.get(qualifiedName);
		if (p == null) {
			throw new UnknownParameterException(qualifiedName);
		}
		return p;
	}

	@Override
	public String getQualifiedName() {
		return this.qualifiedName;
	}

	@Override
	public Parameter<Float> getFloatParameter(final String qualifiedName) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Double> getDoubleParameter(final String qualifiedName) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<BigDecimal> getBigDecimalParameter(final String qualifiedName) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<String> getStringParameter(final String qualifiedName) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter<Byte[]> getRawParameter(final String qualifiedName) throws UnknownParameterException {
		throw new UnsupportedOperationException();
	}



}
