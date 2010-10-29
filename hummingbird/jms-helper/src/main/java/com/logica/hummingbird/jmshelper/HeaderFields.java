package com.logica.hummingbird.jmshelper;

public interface HeaderFields {

	/** Standard fields that all messages should have. */
	public static final String NAME = "Name";
	public static final String VALUE = "Value";
	public static final String TYPE = "Type";
	public static final String TIMESTAMP = "Timestamp";
	
	/** Header fields for state parameters. */
	public static final String ISSTATEOF = "isStateOf";
	public static final String RELEASETIME = "ReleaseTime";
	public static final String TASK_OFF = "TaskOff";
	public static final String EXECUTIONTIME = "TaskExecutionTime";

	
}
