/**
 * 
 */
package com.logica.hummingbird.framebroker;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author doylemr
 * 
 */
public class ContainerTest {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ContainerTest.class);

	private static IFrameBroker testFrameBroker = null;

	/**
	 * Set's up the FrameBroker with a mock container model factory.
	 */
	@BeforeClass
	public static void setUpForAllTests() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Setting up for all tests");
		}
		testFrameBroker = new ContainerProcessor(new MockContainerModelFactory());
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.Container#unmarshall(java.util.BitSet)}
	 * .
	 */
	@Test
	public void testUnmarshall() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.Container#marshall(java.util.BitSet, int)}
	 * .
	 */
	@Test
	public void testMarshall() {
		fail("Not yet implemented");
	}

}
