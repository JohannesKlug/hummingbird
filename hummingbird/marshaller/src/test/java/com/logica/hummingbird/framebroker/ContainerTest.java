/**
 * 
 */
package com.logica.hummingbird.framebroker;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author doylemr
 *
 */
public class ContainerTest {
	
	private Container testContainer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("unused")
		Container testContainer = new Container("TMFrame", "Container used for unit testing", "Container used for unit testing that emulates a TM Frame");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
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
//		testContainer.addRestriction(model, value)
		fail("Not yet implemented");
	}

}
