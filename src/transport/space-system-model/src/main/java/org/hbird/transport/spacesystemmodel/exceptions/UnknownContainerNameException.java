/**
 * 
 */
package org.hbird.transport.spacesystemmodel.exceptions;

import java.util.Map;
import java.util.Set;

import org.hbird.transport.spacesystemmodel.Container;

/**
 * This is a checked exception class which will allow the client to take steps to 
 * rectify the situation.  There is a useful method included which will allow the
 * client to retrieve the available Container names.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class UnknownContainerNameException extends Exception {
	private static final long serialVersionUID = 3499163979287233832L;
	
	Map<String, Container> containers = null;

	/**
	 * 
	 */
	public UnknownContainerNameException(Map<String, Container> containers) {
		this.containers = containers;
	}

	/**
	 * @param message
	 */
	public UnknownContainerNameException(Map<String, Container> containers, String message) {
		super(message);
		this.containers = containers;
	}

	/**
	 * @param cause
	 */
	public UnknownContainerNameException(Map<String, Container> containers, Throwable cause) {
		super(cause);
		this.containers = containers;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnknownContainerNameException(Map<String, Container> containers, String message, Throwable cause) {
		super(message, cause);
		this.containers = containers;
	}
	
	public UnknownContainerNameException(String name) {
		super("Requested container not found in Space System Model. Offending contianer name: " + name);
	}

	public Set<String> getAvailableContainerNames() {
		return containers.keySet();
	}
}
