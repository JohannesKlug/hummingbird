/**
 *
 */
package org.hbird.transport.spacesystemmodel.exceptions;

import java.util.Map;
import java.util.Set;

import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;

/**
 * This is a checked exception class which will allow the client to take steps to
 * rectify the situation.  There is a useful method included which will allow the
 * client to retrieve the available ParameterGroup names.
 *
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class UnknownParameterGroupException extends Exception {
	private static final long serialVersionUID = 3499163979287233832L;

	private Map<String, ParameterGroup> containers = null;

	/**
	 *
	 */
	public UnknownParameterGroupException(final Map<String, ParameterGroup> containers) {
		this.containers = containers;
	}


	/**
	 * @param cause
	 */
	public UnknownParameterGroupException(final Map<String, ParameterGroup> containers, final Throwable cause) {
		super(cause);
		this.containers = containers;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnknownParameterGroupException(final Map<String, ParameterGroup> containers, final String message, final Throwable cause) {
		super(message, cause);
		this.containers = containers;
	}

	public UnknownParameterGroupException(final String name) {
		super("Requested container not found in Space System Model. Offending contianer name: " + name);
	}

	public UnknownParameterGroupException(final Map<String, ParameterGroup> parameterGroups, final String string) {
		// TODO Auto-generated constructor stub
	}

	public Set<String> getAvailableContainerNames() {
		return containers.keySet();
	}
}
