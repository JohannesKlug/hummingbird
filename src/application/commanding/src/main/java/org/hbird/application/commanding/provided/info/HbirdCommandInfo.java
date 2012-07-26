/**
 *
 */
package org.hbird.application.commanding.provided.info;

import java.util.List;

import org.hbird.application.commanding.CommandList;
import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.core.commons.tmtc.ParameterGroup;

/**
 * A Hbird provided implementation of the {@link CommandInformationService} interface.
 * It delegates responsibility of gathering the necessary data to it's {@link CommandList} POJO.
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class HbirdCommandInfo implements CommandInformationService {

	/** Object responsible for gathering the command list data **/
	private CommandList commandList;

	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<ParameterGroup> getAllCommands() {
		return commandList.getCommands();
	}

	public void setCommandList(final CommandList commandList) {
		this.commandList = commandList;
	}

}
