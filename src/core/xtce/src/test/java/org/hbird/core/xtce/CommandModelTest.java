package org.hbird.core.xtce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;
import java.util.Map;

import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mark Doyle
 * 
 */
public class CommandModelTest {

	private static final String SSM_URL = "TestSat-all-uints.xml";
	private static final String STRAND_SSM_URL = "Strand1.xml";

	private SpaceSystemModel ssm;
	private SpaceSystemModel strandSsm;

	@Before
	public void setUp() throws InvalidSpaceSystemDefinitionException {
		final URL url = CommandModelTest.class.getResource(SSM_URL);
		ssm = new XtceSpaceSystemModelFactory(url.getPath()).createSpaceSystemModel();
		assertNotNull(ssm);
		final URL strandUrl = CommandModelTest.class.getResource(STRAND_SSM_URL);
		strandSsm = new XtceSpaceSystemModelFactory(strandUrl.getPath()).createSpaceSystemModel();
		assertNotNull(strandSsm);
	}

	@Test
	public void testCommandDefinition() throws UnknownParameterException {
		assertEquals("TestSat-all-uints", ssm.getName());
		CommandModelTest.verifyCommands(ssm.getCommands());
		assertEquals("Strand-1", strandSsm.getName());
		verifyStrandCommands(strandSsm.getCommands());
	}

	private void verifyStrandCommands(Map<String, CommandGroup> commands) {
		assertEquals(1, commands.size());
		CommandGroup warpCommand = commands.get("Strand-1.tc.PSB Switch 3 WARP valve On time");
		assertNotNull(warpCommand);

		assertEquals("There should be 4 arguments to the warp command", 4, warpCommand.getAllParameters().size());

		for (Parameter<?> p : warpCommand.getAllParametersAsList()) {
			assertNotNull("There must be an Encoding in the encodings map for each parameter", strandSsm.getEncodings().get(p.getQualifiedName()));
		}
	}

	/**
	 * @throws UnknownParameterException
	 * 
	 */
	private static void verifyCommands(final Map<String, CommandGroup> commands) throws UnknownParameterException {
		assertEquals(1, commands.size());
		final CommandGroup openLatchCommand = commands.get("TestSat-all-uints.tc.OPEN_LATCH");
		assertNotNull(openLatchCommand);

		assertNull(openLatchCommand.getShortDescription());
		assertNull(openLatchCommand.getLongDescription());

		assertEquals("TestSat-all-uints.tc.OPEN_LATCH", openLatchCommand.getQualifiedName());
		assertEquals("OPEN_LATCH", openLatchCommand.getName());

		final Map<String, Parameter<?>> arguments = openLatchCommand.getAllParameters();
		assertEquals(2, arguments.size());

		final Parameter<?> scidArg = openLatchCommand.getParameter("TestSat-all-uints.tc.OPEN_LATCH.SC_ID_CONSTANT");
		assertNotNull(scidArg);
		assertEquals("SC_ID_CONSTANT", scidArg.getName());
		assertEquals(5, scidArg.getValue());

		final Parameter<?> doorLatchArg = openLatchCommand.getParameter("TestSat-all-uints.tc.DOOR_LATCH_FLAG");
		assertNotNull(doorLatchArg);
		assertEquals("DOOR_LATCH_FLAG", doorLatchArg.getName());
	}

}
