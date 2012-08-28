package org.hbird.core.spacesystemmodel.tmtcgroups;

import org.hbird.core.commons.tmtc.CommandGroup;

public class HummingbirdCommandGroup extends HummingbirdTmTcGroup implements CommandGroup {
	private static final long serialVersionUID = 1524916260066501266L;

	private long sendTime;

	public HummingbirdCommandGroup(final String qualifiedName, final String name, final String shortDescription, final String longDescription) {
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
