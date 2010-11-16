/**
 * 
 */
package org.hbird.transport.spacesystemmodel.parameters.behaviours;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.Float64Behaviour;

/**
 * @author Mark Doyle
 * 
 */
public class AbstractNumberBehaviourTest {
	/** Logger for this class */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractNumberBehaviourTest.class);

	/** A behaviour used to test AbstractNumberBehaviourTest. We couls use any sub-class but
	 * the Float64 is easier to test with because the BitSet size is always aligned with 64 bit
	 * boundaries.
	 */
	private Float64Behaviour float64Behaviour;

	/**
	 * The test bitset string containing a parameter (Float64 represention of zero)
	 * from starting at position 0.  The Birset then continues with set bits
	 * representing arbitrary data.
	 */
	private static final BitSet ZERO = new BitSet(72);
	
	private static final BitSet ONE = new BitSet(72);

	@BeforeClass
	public static void setUpOnce() {
		// Set to 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 11111111
		// Basically this is zero as a double with some ones on the end. The 1's represent another
		// part of a telemetry frame.
		ZERO.set(64, 73);
		
		// Set to 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000000
		// Basically this is the maximum  double with some zeros on the end. The 0's represent another
		// part of a telemetry frame.
		ONE.set(0, 64);
	}

	@Before
	public void setUpPerTest() {
		float64Behaviour = new Float64Behaviour();
	}

	/**
	 * This test simply extracts the raw data representing the parameter from a BitSet.  The behaviour expects
	 * the parameter to starts at offset 0 so the test BitSets have been setup to support this.  The Test BitSets
	 * are set so the parameter contains the min and max values (all 0's or all 1's) with a number of bits set 
	 * to the opposite tagged on the end.  This enables us to easily test whether the extracted BitSet is 
	 *  correct, that is, the right size and only containing 0's or 1's (depending upon which test BitSet
	 *  is used of course).
	 */
	@Test
	public void testGetRawParameter() {
		BitSet actual = float64Behaviour.getRawParameterBinary(ZERO);
		LOG.debug("ZERO = " + BitSetUtility.binDump(ZERO));
		LOG.debug("actual = " + BitSetUtility.binDump(actual));
		assertEquals(float64Behaviour.getSizeInBits(), actual.size());
		// Assert that a one does not appear in the returned BitSet.
		assertEquals("The test fails if there are set bits in the getRawParameter return", -1, actual.nextSetBit(0));
		
		actual.clear();
		
		actual = float64Behaviour.getRawParameterBinary(ONE);
		LOG.debug("ONE = " + BitSetUtility.binDump(ONE));
		LOG.debug("actual = " + BitSetUtility.binDump(actual));
		assertEquals(float64Behaviour.getSizeInBits(), actual.length());
		// Assert there are 64 set bits.
		int numberSetBits = actual.cardinality();
		assertEquals("The test fails if there are clear bits in the getRawParameter return", 64, numberSetBits);
	}
}
