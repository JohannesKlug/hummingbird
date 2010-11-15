package org.hbird.telemetry;

public class DefaultSpaceParameter implements HummingbirdParameter {

	private String name;
	private Class<?> clazz;
	private Object value;
	private String shortDescription = null;
	private String longDescription = null;

	public DefaultSpaceParameter(String name, Class<?> clazz, Object value) {
		super();
		this.name = name;
		this.clazz = clazz;
		this.value = value;
	}

	public DefaultSpaceParameter(String name, Class<?> clazz, Object value, String shortDescription, String longDescription) {
		super();
		this.name = name;
		this.clazz = clazz;
		this.value = value;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	@Override
	public Class<?> getClassType() {
		return clazz;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getValue() {
		return value;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parameter [clazz=");
		builder.append(clazz);
		builder.append(", name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(HummingbirdParameter rightHandSide) throws NotComparableTypeException {
		int returnValue = 0;

		if (this.clazz == Double.class && rightHandSide.getValue().getClass() == Double.class) {
			Double thisValue = (Double) this.value;
			Double rightValue = (Double) rightHandSide.getValue();

			if (thisValue < rightValue) {
				returnValue = -1;
			}
			else if (thisValue > rightValue) {
				returnValue = 1;
			}
		}
		else if (this.clazz == Integer.class && rightHandSide.getValue().getClass() == Integer.class) {
			Integer thisValue = (Integer) this.value;
			Integer rightValue = (Integer) rightHandSide.getValue();

			if (thisValue < rightValue) {
				returnValue = -1;
			}
			else if (thisValue > rightValue) {
				returnValue = 1;
			}
		}
		else if (this.clazz == Integer.class && rightHandSide.getValue().getClass() == Double.class) {
			Integer thisValue = (Integer) this.value;
			Double rightValue = (Double) rightHandSide.getValue();

			if (thisValue < rightValue) {
				returnValue = -1;
			}
			else if (thisValue > rightValue) {
				returnValue = 1;
			}
		}
		else if (this.clazz == Double.class && rightHandSide.getValue().getClass() == Integer.class) {
			Double thisValue = (Double) this.value;
			Integer rightValue = (Integer) rightHandSide.getValue();

			if (thisValue < rightValue) {
				returnValue = -1;
			}
			else if (thisValue > rightValue) {
				returnValue = 1;
			}
		}
		else if (this.clazz == Long.class && rightHandSide.getValue().getClass() == Long.class) {
			Long thisValue = (Long) this.value;
			Long rightValue = (Long) rightHandSide.getValue();

			if (thisValue < rightValue) {
				returnValue = -1;
			}
			else if (thisValue > rightValue) {
				returnValue = 1;
			}
		}
		else if (this.clazz == Boolean.class && rightHandSide.getValue().getClass() == Boolean.class) {
			Boolean thisValue = (Boolean) this.value;
			Boolean rightValue = (Boolean) rightHandSide.getValue();

			if (thisValue != rightValue) {
				returnValue = -1;
			}
		}
		else if (this.clazz == String.class && rightHandSide.getValue().getClass() == String.class) {
			String thisValue = (String) this.value;
			String rightValue = (String) rightHandSide.getValue();

			returnValue = thisValue.compareTo(rightValue);
		}
		else if (this.clazz == Short.class && rightHandSide.getValue().getClass() == Short.class) {
			Short thisValue = (Short) this.value;
			Short rightValue = (Short) rightHandSide.getValue();

			if (thisValue < rightValue) {
				returnValue = -1;
			}
			else if (thisValue > rightValue) {
				returnValue = 1;
			}
		}
		else {
			throw new NotComparableTypeException();
		}

		return returnValue;
	}
	
	public boolean asBoolean() {
		return (Boolean) value;
	}
}
