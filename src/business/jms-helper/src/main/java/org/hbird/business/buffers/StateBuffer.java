package org.hbird.business.buffers;


/**
 * Class for buffering state parameters. The last value of all states,
 * identified through their name, is buffered.
 */
public class StateBuffer extends ObjectBuffer {

	public boolean getState(String name) {
		return (Boolean) buffer.get(name);
	}
}
