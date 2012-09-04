/**
 *
 */
package org.hbird.application.commanding.provided.info;

import java.util.List;

import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.core.commons.tmtc.CommandGroup;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;

/**
 * A Hbird provided implementation of the {@link CommandInformationService} interface.
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class HbirdPublisherBasedCommandInfo implements CommandInformationService {

	private SpaceSystemPublisher publisher;

	private List<CommandGroup> cachedCommands;


	public void init() {
		this.cachedCommands = publisher.getCommandList();
	}


	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<CommandGroup> getAllAllowedCommands() {
		return cachedCommands;
	}


	public SpaceSystemPublisher getPublisher() {
		return publisher;
	}


	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}


	@Override
	public CommandGroup getCommand(final String qualifiedName) {
		return publisher.getCommand(qualifiedName);
	}


}
