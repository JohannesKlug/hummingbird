/**
 * 
 */
package com.logica.hummingbird.framebroker;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
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

		LOG.debug("Bitset length = " + frame.size());
		String binDump = BitSetUtility.binDump(frame);
		LOG.debug(binDump);

		// Assert the bitset is as expected.  // TODO there is probably a better way to do this than a binDump String comparison haha. 
		assertEquals("Bit dump not equal", EXPECTED_BIT_SET_DUMP, binDump);
		

		// Now let's marshall a parameter and run some tests.
		BitSet apidBitSet = new BitSet(MOCK_CONTAINER_MODEL_FACTORY.getParameter(MockContainerModelFactory.PACKET_ID_NAME).getLength());
		testFrameBroker.marshall(MockContainerModelFactory.PACKET_ID_NAME, apidBitSet);
		String apidBinDump = BitSetUtility.binDump(apidBitSet);
		if(LOG.isDebugEnabled()) {
			LOG.debug(MOCK_CONTAINER_MODEL_FACTORY.getParameter(MockContainerModelFactory.PACKET_ID_NAME) + " = " + apidBinDump);
		}
		
		String apidBinValue = Integer.toBinaryString(Integer.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));
		 // LSB first so we need to reverse the dumped string.
		apidBinValue = new StringBuffer(apidBinValue).reverse().toString();
		// BitSets are rounded up to 64 bits so we will have to pad the marshalled APID with extra 0's
		// We will calculate the required zeros using the apid's length so we don't spoil the test
		int requiredPadding = 64 - apidBinValue.length();
		char[] zeroPadding = new char[requiredPadding];
		for(int c = 0; c < requiredPadding; c++) {
			zeroPadding[c] = '0';
		}
		StringBuffer apidBinValueWithPadding = new StringBuffer(apidBinValue);
		apidBinValueWithPadding.append(zeroPadding);
		assertEquals("Apid does not match", StringUtils.deleteWhitespace(apidBinDump), apidBinValueWithPadding.toString());
	}

}
