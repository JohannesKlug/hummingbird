package org.hbird.core.commons.tmtc;

import org.joda.time.DateTime;


public interface CommandGroup extends TmTcGroup {
	void setSendTime(DateTime sendTime);
}
