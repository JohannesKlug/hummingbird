package org.hbird.core.xtce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;
import java.util.Map;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mark Doyle
 *
 */
public class CommandModelTest {

	private static final String SSM_URL = "TestSat-all-uints.xml";

	private SpaceSystemModel ssm;

	@Before
	public void setUp() throws InvalidSpaceSystemDefinitionException {
		final URL url = CommandModelTest.class.getResource(SSM_URL);
		ssm = new XtceSpaceSystemModelFactory(url.getPath()).createSpaceSystemModel();
		assertNotNull(ssm);
	}

	@Test
	public void testCommandDefinition() throws UnknownParameterException {
		assertEquals("TestSat-all-uints", ssm.getName());
		CommandModelTest.verifyCommands(ssm.getCommands());
	}

	/**
	 * @throws UnknownParameterException
	 *
	 */
	private static void verifyCommands(final Map<String, ParameterGroup> commands) throws UnknownParameterException {
		assertEquals(1, commands.size());
		final ParameterGroup openLatchCommand = commands.get("TestSat-all-uints.tc.OPEN_LATCH");
		assertNotNull(openLatchCommand);
		assertNull(openLatchCommand.getShortDescription());
		assertNull(openLatchCommand.getLongDescription());
		assertEquals("TestSat-all-uints.tc.OPEN_LATCH", openLatchCommand.getQualifiedName());
		assertEquals("OPEN_LATCH", openLatchCommand.getName());

		final Map<String, Parameter<?>> arguments = openLatchCommand.getAllParameters();
		assertEquals(2, arguments.size());

		final Parameter<?> scidArg = openLatchCommand.getParameter("TestSat-all-uints.tc.SC_ID_CONSTANT");
		assertNotNull(scidArg);
		assertEquals("SC_ID_CONSTANT", scidArg.getName());

		final Parameter<?> doorLatchArg = openLatchCommand.getParameter("TestSat-all-uints.tc.DOOR_LATCH_FLAG");
		assertNotNull(doorLatchArg);
		assertEquals("DOOR_LATCH_FLAG", doorLatchArg.getName());
	}

}
