package org.hbird.tasks.checks;

import java.io.Serializable;

import org.apache.camel.Message;

import org.hbird.buffers.ObjectBuffer;


/**
 * A configurable value can be
 * 1. Static, i.e. set ones and never changed.
 * 2. Dynamic based on another parameter, i.e. change when another parameter changes.
 * 3. Dynamic based on a message header field value.
 *
 */
public abstract class ConfigurableValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract Number getValue(ObjectBuffer in);
	
	public void configure(Message in) {		
		/** Do null. */
	};
}
