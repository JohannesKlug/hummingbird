package org.hbird.core.commons.tmtcgroups;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.TmTcGroup;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;

@XmlRootElement()
public abstract class HummingbirdTmTcGroup implements TmTcGroup {
	private static final long serialVersionUID = 7331716323505575390L;

	protected final String qualifiedName;
	protected final String name;
	protected final String shortDescription;
	protected final String longDescription;

	protected final Map<String, Parameter<?>> parameters = new LinkedHashMap<String, Parameter<?>>();
	protected Map<String, Parameter<Integer>> integerParameters;
	protected Map<String, Parameter<Long>> longParameters;
	protected Map<String, Parameter<Float>> floatParameters;
	protected Map<String, Parameter<Double>> doubleParameters;
	protected Map<String, Parameter<BigDecimal>> bigDecimalParameters;
	protected Map<String, Parameter<String>> stringParameters;
	protected Map<String, Parameter<Byte[]>> rawParameters;


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
	public HummingbirdTmTcGroup(final String qualifiedName, final String name, final String shortDescription, final String longDescription) {
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
	public void addIntegerParameter(final Parameter<Integer> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.integerParameters == null) {
			this.integerParameters = new LinkedHashMap<String, Parameter<Integer>>();
		}
		this.integerParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}

	@Override
	public void addLongParameter(final Parameter<Long> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.longParameters == null) {
			this.longParameters = new LinkedHashMap<String, Parameter<Long>>();
		}
		this.longParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}

	@Override
	public void addBigDecimalParameter(final Parameter<BigDecimal> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.bigDecimalParameters == null) {
			this.bigDecimalParameters = new LinkedHashMap<String, Parameter<BigDecimal>>();
		}
		this.bigDecimalParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}

	@Override
	public void addFloatParameter(final Parameter<Float> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.floatParameters == null) {
			this.floatParameters = new LinkedHashMap<String, Parameter<Float>>();
		}
		this.floatParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}

	@Override
	public void addDoubleParameter(final Parameter<Double> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.doubleParameters == null) {
			this.doubleParameters = new LinkedHashMap<String, Parameter<Double>>();
		}
		this.doubleParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}

	@Override
	public void addStringParameter(final Parameter<String> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.stringParameters == null) {
			this.stringParameters = new LinkedHashMap<String, Parameter<String>>();
		}
		this.stringParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}

	@Override
	public void addRawParameter(final Parameter<Byte[]> parameter) {
		final String qualifiedName = parameter.getQualifiedName();
		validateQualifiedName(qualifiedName);
		if (this.rawParameters == null) {
			this.rawParameters = new LinkedHashMap<String, Parameter<Byte[]>>();
		}
		this.rawParameters.put(qualifiedName, parameter);
		this.parameters.put(qualifiedName, parameter);
	}


	@Override
	public Parameter<Integer> getIntegerParameter(final String qualifiedName) throws UnknownParameterException {
		final Parameter<Integer> p = integerParameters == null ? null : integerParameters.get(qualifiedName);
		validateParameterNotNull(p, qualifiedName);
		return p;
	}

	@Override
	public Parameter<Long> getLongParameter(final String qualifiedName) throws UnknownParameterException {
		final Parameter<Long> p = longParameters == null ? null : longParameters.get(qualifiedName);
		validateParameterNotNull(p, qualifiedName);
		return p;
	}

	@Override
	public Parameter<?> getParameter(final String qualifiedName) throws UnknownParameterException {
		final Parameter<?> p = parameters.get(qualifiedName);
		validateParameterNotNull(p, qualifiedName);
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
		final Parameter<String> p = stringParameters == null ? null : stringParameters.get(qualifiedName);
		validateParameterNotNull(p, qualifiedName);
		return p;
	}

	public void validateQualifiedName(final String qualifiedName) throws NullPointerException {
		if (qualifiedName == null) {
			throw new NullPointerException("Parameter qualifed name is null");
		}
	}

	public void validateParameterNotNull(final Parameter<?> p, final String qualifiedName) throws UnknownParameterException {
		if (p == null) {
			throw new UnknownParameterException(qualifiedName);
		}
	}

	@Override
	public Parameter<Byte[]> getRawParameter(final String qualifiedName) throws UnknownParameterException {
		final Parameter<Byte[]> p = rawParameters == null ? null : rawParameters.get(qualifiedName);
		validateParameterNotNull(p, qualifiedName);
		return p;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("HummingbirdParameterGroup [qualifiedName=");
		builder.append(qualifiedName);
		builder.append(", name=");
		builder.append(name);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append(", longDescription=");
		builder.append(longDescription);
		builder.append(", integerParameters=");
		builder.append(integerParameters);
		builder.append(", longParameters=");
		builder.append(longParameters);
		builder.append(", floatParameters=");
		builder.append(floatParameters);
		builder.append(", doubleParameters=");
		builder.append(doubleParameters);
		builder.append(", bigDecimalParameters=");
		builder.append(bigDecimalParameters);
		builder.append(", stringParameters=");
		builder.append(stringParameters);
		builder.append(", rawParameters=");
		builder.append(rawParameters);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<Parameter<?>> getAllParametersAsList() {
		return new ArrayList<Parameter<?>>(this.parameters.values());
	}

}
