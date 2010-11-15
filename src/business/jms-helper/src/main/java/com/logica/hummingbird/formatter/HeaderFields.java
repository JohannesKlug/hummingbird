package org.hbird.formatter;

public interface HeaderFields {

	/** Standard fields that all messages should have. */
	public static final String NAME = "Name";
	public static final String VALUE = "Value";
	public static final String TYPE = "Type";
	public static final String TIMESTAMP = "Timestamp";
	
	/** Header fields for state parameters. */
	public static final String ISSTATEOF = "is State Of";
	public static final String RELEASETIME = "Release Time";
	public static final String TASK_OFF = "Task Off";
	public static final String EXECUTIONTIME = "Task Execution Time";
	
	public static final String ID = "JMSMessageId";
	
	/** Log message header fields. */
	public static final String LEVEL = "Log Level";

}
