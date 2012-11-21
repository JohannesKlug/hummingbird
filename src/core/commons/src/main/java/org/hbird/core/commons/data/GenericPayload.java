package org.hbird.core.commons.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class GenericPayload implements Serializable {
	private static final long serialVersionUID = 7823269614387628654L;

	public byte[] payload;
	public List<String> layoutIdentifiers = new ArrayList<String>();
	public long timeStamp;

	public GenericPayload(final byte[] payload, final String layoutIdentifier, final long timeStamp) {
		this.payload = ArrayUtils.clone(payload);
		this.layoutIdentifiers.add(layoutIdentifier);
		this.timeStamp = timeStamp;
	}

	public GenericPayload(final byte[] payload, final List<String> layoutIdentifiers, final long timeStamp) {
		this.payload = ArrayUtils.clone(payload);
		this.layoutIdentifiers = layoutIdentifiers;
		this.timeStamp = timeStamp;
	}

	public byte[] getPayload() {
		return payload;
	}

	public List<String> getLayoutIdentifiers() {
		return layoutIdentifiers;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

}
