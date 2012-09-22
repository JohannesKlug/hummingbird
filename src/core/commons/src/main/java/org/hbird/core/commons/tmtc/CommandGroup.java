package org.hbird.core.commons.tmtc;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hbird.core.commons.tmtcgroups.HummingbirdCommandGroup;

/**
 * The interface is deserialised as {@link HummingbirdCommandGroup} unless you provide your own Jackson JSON processor.
 * 
 * @author Mark Doyle
 * 
 */
@JsonDeserialize(as = HummingbirdCommandGroup.class)
public interface CommandGroup extends TmTcGroup {
	void setSendTime(long sendTime);

	long getSendTime();
}