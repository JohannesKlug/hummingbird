package org.hbird.core.commons.tmtc;


public interface CommandGroup extends TmTcGroup {
	void setSendTime(long sendTime);

	long getSendTime();
}
