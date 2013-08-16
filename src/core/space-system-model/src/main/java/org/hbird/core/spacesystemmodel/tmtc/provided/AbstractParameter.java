package org.hbird.core.spacesystemmodel.tmtc.provided;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;

public abstract class AbstractParameter<T> implements Parameter<T> {
	private static final long serialVersionUID = 1250249760314744228L;

	private final String qualifiedName;

	private final String name;

	private final String shortDescription;

	private final String longDescription;

	@JsonCreator
	public AbstractParameter(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription, @JsonProperty("longDescription") final String longDescription) {
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
	public String getQualifiedName() {
		return this.qualifiedName;
	}

}
