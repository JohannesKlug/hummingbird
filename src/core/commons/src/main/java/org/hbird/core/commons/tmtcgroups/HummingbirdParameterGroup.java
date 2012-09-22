package org.hbird.core.commons.tmtcgroups;

import javax.xml.bind.annotation.XmlRootElement;

import org.hbird.core.commons.tmtc.ParameterGroup;

/**
 * TELEMETRY
 *
 * @author Mark Doyle
 * @author Johannes Klug
 */
@XmlRootElement()
public class HummingbirdParameterGroup extends HummingbirdTmTcGroup implements ParameterGroup {
	private static final long serialVersionUID = -6877917071118156741L;

	private long timeStamp = 0;

	public HummingbirdParameterGroup(final String qualifiedName, final String name, final String shortDescription, final String longDescription) {
		super(qualifiedName, name, shortDescription, longDescription);
	}

	@Override
	public long getTimeStamp() {
		return this.timeStamp;
	}

	@Override
	public void setTimeStamp(final long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
