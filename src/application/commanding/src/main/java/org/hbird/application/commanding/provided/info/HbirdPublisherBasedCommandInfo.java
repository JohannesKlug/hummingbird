/**
 *
 */
package org.hbird.application.commanding.provided.info;

import java.util.List;

import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
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

	/**
	 * @throws UnavailableSpaceSystemModelException
	 * @{inheritDoc
	 */
	@Override
	public List<CommandGroup> getAllAllowedCommands() throws UnavailableSpaceSystemModelException {
		return publisher.getCommandList();
	}

	public SpaceSystemPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public CommandGroup getCommand(final String qualifiedName) throws UnavailableSpaceSystemModelException {
		return publisher.getCommand(qualifiedName);
	}

}
