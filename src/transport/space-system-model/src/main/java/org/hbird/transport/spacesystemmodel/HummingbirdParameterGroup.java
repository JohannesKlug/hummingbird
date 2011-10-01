package org.hbird.transport.spacesystemmodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.parameters.Parameter;

/**
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class HummingbirdParameterGroup implements ParameterGroup {
	private final String name;
	private final String shortDescription;
	private final String longDescription;

	private List<Parameter<Integer>> integerParameters;
	private List<Parameter<Long>> longParameters;
	private List<Parameter<Float>> floatParameters;
	private List<Parameter<Double>> doubleParameters;
	private List<Parameter<BigDecimal>> bigDecimalParameters;
	private List<Parameter<String>> stringParameters;
	private List<Parameter<Byte[]>> rawParameters;


	/**
	 * The restrictions defining when this container should process. Each restriction is a parameter / string pair. The
	 * parameter will convert the string based on its type and compare itself against the resulting value. If the string
	 * is invalid then this will always count as a failed match.
	 */
	protected Map<Parameter<?>, Object> restrictions = new HashMap<Parameter<?>, Object>();

	/** List of Parameters belonging to this Group */
	private final List<Parameter<?>> parameters = new ArrayList<Parameter<?>>();

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
	public void addRestriction(final Object payloadLayoutId) {
		// TODO Auto-generated method stub

	}


	@Override
	public Object getRestriction() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getSizeInBits() {
		int length = 0;
		// TODO

		return length;
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
	public List<Parameter<?>> getParameters() {
		return this.parameters;
	}

	@Override
	public List<Parameter<Integer>> getIntegerParameters() {
		return integerParameters;
	}

	@Override
	public List<Parameter<Long>> getLongParameters() {
		return longParameters;
	}

	@Override
	public List<Parameter<Float>> getFloatParameters() {
		return floatParameters;
	}

	@Override
	public List<Parameter<Double>> getDoubleParameters() {
		return doubleParameters;
	}

	@Override
	public List<Parameter<BigDecimal>> getBigDecimalParameters() {
		return bigDecimalParameters;
	}

	@Override
	public List<Parameter<String>> getStringParameters() {
		return stringParameters;
	}

	@Override
	public List<Parameter<Byte[]>> getRawParameters() {
		return rawParameters;
	}


	@Override
	public void addIntegerParameter(final Parameter<Integer> parameter) {
		if (this.integerParameters == null) {
			this.integerParameters = new ArrayList<Parameter<Integer>>();
		}
		this.integerParameters.add(parameter);
	}


	@Override
	public void addLongParameter(final Parameter<Long> parameter) {
		if (this.longParameters == null) {
			this.longParameters = new ArrayList<Parameter<Long>>();
		}
		this.longParameters.add(parameter);
	}


	@Override
	public void addBigDecimalParameter(final Parameter<BigDecimal> parameter) {
		// TODO Auto-generated method stub

	}


	@Override
	public void addFloatParameter(final Parameter<Float> parameter) {
		// TODO Auto-generated method stub

	}


	@Override
	public void addDoubleParameter(final Parameter<Double> parameter) {
		// TODO Auto-generated method stub

	}


	@Override
	public void addStringParameter(final Parameter<String> parameter) {
		// TODO Auto-generated method stub

	}


	@Override
	public void addRawParameter(final Parameter<Byte[]> parameter) {
		// TODO Auto-generated method stub

	}


}
