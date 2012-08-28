package org.hbird.application.commanding.camel;

import org.apache.camel.Body;
import org.hbird.core.commons.tmtc.CommandGroup;
import org.joda.time.DateTime;

public class CommandSendTimeFilter {

	public static final boolean shouldSendNow(@Body final CommandGroup command) {
		boolean result = false;

		DateTime dateTime = new DateTime(command.getSendTime());
		if(dateTime.isBeforeNow() || dateTime.isEqualNow()) {
			result = true;
		}

		return result;
	}
}
