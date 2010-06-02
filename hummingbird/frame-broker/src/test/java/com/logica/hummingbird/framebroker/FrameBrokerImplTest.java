/**
 * 
 */
package com.logica.hummingbird.framebroker;

import java.awt.PageAttributes.OriginType;
import java.util.BitSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.spacesystemmodel.BitSetUtility;
import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockSpaceSystemModelFactory;
import com.logica.hummingbird.telemetry.TelemetryFrame;
import com.sun.source.tree.AssertTree;

/**
 * @author Mark Doyle
 * 
 */
public class FrameBrokerImplTest {

	private final static ContainerFactory mockSpaceSystemFactory = new MockSpaceSystemModelFactory();

	private IFrameBroker frameBroker;

	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with a param type ID of 555
	 * and a param A test value of 123
	 */
	private final static String BITSET_AS_STRING = "11010100010110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		frameBroker = new FrameBrokerImpl(mockSpaceSystemFactory);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#unmarshall(java.lang.String, java.util.BitSet)}.
	 * @throws UnknownContainerNameException 
	 * @throws BitSetOperationException 
	 */
	@Test
	public final void testUnmarshall() throws UnknownContainerNameException, BitSetOperationException {
		BitSet mockFrame = BitSetUtility.fromString(BITSET_AS_STRING);
	
		// Unmarshall each telemetry element in the space system model
		frameBroker.unmarshall(MockSpaceSystemModelFactory.TM_FRAME_ALIAS, mockFrame);
		TelemetryFrame unmarshalledFrame = frameBroker.getFrame();
		System.out.println("unmarshalled frame = " + unmarshalledFrame);
		
		frameBroker.unmarshall(MockSpaceSystemModelFactory.TM_FRAME_HEADER_ALIAS, mockFrame);
		frameBroker.unmarshall(MockSpaceSystemModelFactory.TM_FRAME_TAIL_ALIAS, mockFrame);
		frameBroker.unmarshall(MockSpaceSystemModelFactory.TM_PACKET_ALIAS, mockFrame);
		frameBroker.unmarshall(MockSpaceSystemModelFactory.TM_PACKET_HEADER_ALIAS, mockFrame);
		frameBroker.unmarshall(MockSpaceSystemModelFactory.TM_PACKET_BODY_ALIAS, mockFrame);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#marshall(java.lang.String, java.util.BitSet)}.
	 */
	@Test
	public final void testMarshallStringBitSet() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#marshall(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testMarshallStringString() {
		// TODO
	}

}
