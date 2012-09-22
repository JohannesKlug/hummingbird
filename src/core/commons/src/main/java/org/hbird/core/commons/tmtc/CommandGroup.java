package org.hbird.core.commons.tmtc;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hbird.core.commons.tmtcgroups.HummingbirdCommandGroup;


@JsonDeserialize(as = HummingbirdCommandGroup.class)
public interface CommandGroup extends TmTcGroup {
	void setSendTime(long sendTime);

	long getSendTime();
}