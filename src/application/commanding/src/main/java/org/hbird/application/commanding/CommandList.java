package org.hbird.application.commanding;

import java.util.List;

import org.hbird.core.commons.tmtc.ParameterGroup;

/**
 * This POJO is used to cache a list of commands. You can wire it up anyway you wish.
 * Using hardcoded, a file, or a service for example.
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class CommandList {

	private List<ParameterGroup> commands;

	public List<ParameterGroup> getCommands() {
		return commands;
	}

	public void setCommands(final List<ParameterGroup> commands) {
		System.out.println("Got " + commands.size() + " commands.");
		this.commands = commands;
	}

}
