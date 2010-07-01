/**
 * 
 */
package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float32Behaviour;
import com.logica.hummingbird.util.BitSetUtility;

/**
 * @author doylemr
 * 
 */
public class Float32BehaviourTest {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(Float32BehaviourTest.class);
	
	private Float32Behaviour float32behvaiour = null;

	private final static Float GOLDEN_RATIO = 1.61803398874f;
	
	private final static BitSet GOLDEN_RATIO_TEST_BITSET = new BitSet(32);

	private final static String GOLDEN_RATIO_TEST_BITSET_STRING = "00111111110011110001101110111101";
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GOLDEN_RATIO_TEST_BITSET.set(2, 10);
		GOLDEN_RATIO_TEST_BITSET.set(12, 16);
		GOLDEN_RATIO_TEST_BITSET.set(19, 21);
		GOLDEN_RATIO_TEST_BITSET.set(22, 25);
		GOLDEN_RATIO_TEST_BITSET.set(26, 30);
		GOLDEN_RATIO_TEST_BITSET.set(31);
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Setup Golden ratio BitSet: " + BitSetUtility.binDump(GOLDEN_RATIO_TEST_BITSET));
		}
	}

	@Before
	public void setUpForTest() {
		float32behvaiour = new Float32Behaviour();
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float32Behaviour#valueFromBitSet(java.util.BitSet)}
	 * .
	 */
	@Ignore
	@Test
	public void testValueFromBitSet() {
		// FIXME Fix this test.
		Float actual = float32behvaiour.valueFromBitSet(GOLDEN_RATIO_TEST_BITSET);
		assertEquals("Extracted value must match", GOLDEN_RATIO, actual);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float32Behaviour#insertIntoBitSet(java.lang.Number, java.util.BitSet, int)}
	 * .
	 */
	@Ignore
	@Test
	public void testInsertIntoBitSet() {
		fail("Not yet implemented");
	}

}
