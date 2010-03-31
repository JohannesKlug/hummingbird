/**
 * 
 */
package com.logica.hummingbird.framebroker;

import static org.junit.Assert.*;

import java.util.BitSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.framebroker.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.framebroker.parameters.Parameter;

/**
 * @author doylemr
 * 
 */
public class ContainerTest {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ContainerTest.class);

	private static final MockContainerModelFactory MOCK_CONTAINER_MODEL_FACTORY = new MockContainerModelFactory();

	private static IFrameBroker testFrameBroker = null;

	private static final String EXPECTED_BIT_SET_DUMP = "11010100 01011011 11000000 00000000 00000000 00000000 00000000 00000000 "
			+ System.getProperty("line.separator")
			+ "00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 "
			+ System.getProperty("line.separator");

	/**
	 * Set's up the FrameBroker with a mock container model factory.
	 */
	@BeforeClass
	public static void setUpForAllTests() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Setting up for all tests");
		}
		testFrameBroker = new ContainerProcessor(MOCK_CONTAINER_MODEL_FACTORY);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.Container#unmarshall(java.util.BitSet)}
	 * .
	 * 
	 * @throws UnknownContainerNameException
	 */
	// @Test
	// public void testUnmarshall() throws UnknownContainerNameException {
	// testFrameBroker.unmarshall("TMFrame", frame);
	// }

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.Container#marshall(java.util.BitSet, int)}
	 * .
	 * 
	 * @throws UnknownContainerNameException
	 */
	@Test
	public void testMarshall() throws UnknownContainerNameException {
		LOG.debug(MOCK_CONTAINER_MODEL_FACTORY.getContainer("TMFrame").toString());

		/** Populate the input mock frame **/
		// Set the Apid to Packet ID type A
		Parameter apid = MOCK_CONTAINER_MODEL_FACTORY.getParameter(MockContainerModelFactory.PACKET_ID_NAME);
		apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));

		// Set parameter A value
		Parameter paramA = MOCK_CONTAINER_MODEL_FACTORY.getParameter(MockContainerModelFactory.TEST_PARAM_VALUE_A);
		paramA.setValue(123);

		// Get the frame length, that is, the sum of itself and it's tree of sub containers and set the bitset to this length.
		int length = MOCK_CONTAINER_MODEL_FACTORY.getContainer("TMFrame").getLength();
		if (LOG.isDebugEnabled()) {
			LOG.debug("TMFrame length = " + length);
		}
		BitSet frame = new BitSet(length);

		// Marshall the Frame to a bitset
		testFrameBroker.marshall("TMFrame", frame);

		String binDump = BitSetUtility.binDump(frame);
		LOG.debug(binDump);
		
		// Assert the bitset is as expected.  // TODO there is probably a better way to do this than a binDump String comparison haha. 
		assertEquals("Bit dump not equal", EXPECTED_BIT_SET_DUMP, binDump);
	}

}
