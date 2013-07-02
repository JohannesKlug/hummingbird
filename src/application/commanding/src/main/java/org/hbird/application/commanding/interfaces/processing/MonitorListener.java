package org.hbird.application.commanding.interfaces.processing;

import org.hbird.application.commanding.provided.processing.CommandMonitor;

public interface MonitorListener {
	void commandCompleted(CommandMonitor monitor);
}
