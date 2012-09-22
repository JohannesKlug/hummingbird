package org.hbird.core.commons.tmtcgroups;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hbird.core.commons.tmtc.CommandGroup;

@XmlRootElement()
public class HummingbirdCommandGroup extends HummingbirdTmTcGroup implements CommandGroup {
	private static final long serialVersionUID = 1524916260066501266L;

	private long sendTime;

	@JsonCreator
	public HummingbirdCommandGroup(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription, @JsonProperty("longDescription") final String longDescription) {
		super(qualifiedName, name, shortDescription, longDescription);
	}

	@Override
	public long getSendTime() {
		return this.sendTime;
	}

	@Override
	public void setSendTime(final long sendTime) {
		this.sendTime = sendTime;
	}

}
