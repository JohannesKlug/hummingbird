/**
 * 
 */
package com.logica.hummingbird.framebroker;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author doylemr
 *
 */
public class ContainerTest {
	
	private static IFrameBroker testFrameBroker = null;
	
	/**
	 * Set's up the FrameBroker with a mock container model factory.
	 */
	@BeforeClass
	public static void setUpForAllTests() {
		testFrameBroker = new ContainerProcessor(new MockContainerModelFactory()); 
	}

	/**
	 * Test method for {@link com.logica.hummingbird.framebroker.Container#unmarshall(java.util.BitSet)}.
	 */
	@Test
	public void testUnmarshall() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.logica.hummingbird.framebroker.Container#marshall(java.util.BitSet, int)}.
	 */
	@Test
	public void testMarshall() {
		fail("Not yet implemented");
	}

}
