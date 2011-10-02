package org.hbird.transport.spacesystemmodel;

public class ParameterGroupReport {

	int intParameters = 0;
	int longParameters = 0;
	int bigDecimalParameters;
	int floatParameters = 0;
	int doubleParameters = 0;
	int stringParameters = 0;
	int rawParameters = 0;

	public ParameterGroupReport(int numberIntParameters, int numberLongParameters, int numberBigDecimalParameters, int numberFloatParameters,
			int numberDoubleParameters, int numberStringParameters, int numberRawParameters) {
		this.intParameters = numberIntParameters;
		this.longParameters = numberLongParameters;
		this.bigDecimalParameters = numberBigDecimalParameters;
		this.floatParameters = numberFloatParameters;
		this.doubleParameters = numberDoubleParameters;
		this.stringParameters = numberStringParameters;
		this.rawParameters = numberRawParameters;
	}

	public ParameterGroupReport() {
	}

	public void incrementIntCount() {
		this.intParameters++;
	}

	public void incrementLongCount() {
		this.longParameters++;
	}

	public void incrementBigDecimalCount() {
		this.bigDecimalParameters++;
	}

	public void incrementFloatCount() {
		this.floatParameters++;
	}

	public void incrementDoubleCount() {
		this.doubleParameters++;
	}

	public void incrementStringCount() {
		this.stringParameters++;
	}

	public void incrementRawCount() {
		this.rawParameters++;
	}

	public int getNumberIntParameters() {
		return intParameters;
	}

	public int getNumberLongParameters() {
		return longParameters;
	}

	public int getNumberBigDecimalParameters() {
		return bigDecimalParameters;
	}

	public int getNumberFloatParameters() {
		return floatParameters;
	}

	public int getNumberDoubleParameters() {
		return doubleParameters;
	}

	public int getNumberStringParameters() {
		return stringParameters;
	}

	public int getNumberRawParameters() {
		return rawParameters;
	}

}
