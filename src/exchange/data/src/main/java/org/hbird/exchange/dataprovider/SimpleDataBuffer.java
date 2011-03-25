package org.hbird.exchange.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.hbird.exchange.type.Command;
import org.hbird.exchange.type.Parameter;

/**
 * A simple class for buffering data. The buffer must be populated through
 * its interfaces, and will return the buffered values. 
 * */
public class SimpleDataBuffer implements IDataProvider {

	/** The parameter 'buffer'. */
	protected Map<String, Parameter> parameters = new HashMap<String, Parameter>();

	/** The command 'buffer'. */
	protected Map<String, Command> commands = new HashMap<String, Command>();

	public void addParameter(Parameter parameter) {
		parameters.put("name=" + parameter.getName(), parameter);
	}

	@Override
	public Parameter getParameter(String selector) {
		return parameters.get(selector);
	}

	public void addCommand(Command command) {
		commands.put(command.getName(), command);
	}

	@Override
	public Command getCommand(String name) {
		return null;
	}
}
