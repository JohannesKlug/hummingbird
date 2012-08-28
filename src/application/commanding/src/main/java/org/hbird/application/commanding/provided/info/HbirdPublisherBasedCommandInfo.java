/**
 *
 */
package org.hbird.application.commanding.provided.info;

import java.util.List;

import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.core.commons.tmtc.ParameterGroup;
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

	private List<ParameterGroup> cachedCommands;


	public void init() {
		this.cachedCommands = publisher.getCommandList();
	}


	/**
	 * @{inheritDoc}
	 */
	@Override
	public List<ParameterGroup> getAllAllowedCommands() {
		return cachedCommands;
	}


}
