package com.logica.hummingbird.xtce;

import java.util.BitSet;

import junit.framework.TestCase;

import com.logica.hummingbird.framebroker.FrameBrokerImpl;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.xtce.exceptions.InvalidXtceFileException;

// FIXME Not a unit test. This tests integration of separate components.  Needs moving.
public class ContainerProcessorTest extends TestCase {

	public void testMarshall() throws UnknownContainerNameException, InvalidXtceFileException {
		ContainerFactory factory = new XtceModelFactory("src/main/resources/humsat.xml");
//		factory.initialise();
		
		/** Build the frame. */
		factory.getParameter("CCSDS_FVERSION").setValue(1);
		factory.getParameter("CCSDS_SC_ID").setValue(3);
		factory.getParameter("CCSDS_TF_VC").setValue(3);
		factory.getParameter("CCSDS_OP_CTRL").setValue(1);
		factory.getParameter("CCSDS_MS_CNT").setValue(5);
		factory.getParameter("CCSDS_VC_CNT").setValue(6);
		factory.getParameter("CCSDS_TF_SECH").setValue(1);
		factory.getParameter("CCSDS_TF_SYNC").setValue(1);
		factory.getParameter("CCSDS_TF_ORDER").setValue(1);
		factory.getParameter("CCSDS_TF_SEGM").setValue(1);
		factory.getParameter("CCSDS_TF_FH").setValue(1);
		factory.getParameter("CCSDS_TF_HV").setValue(1);
		factory.getParameter("CCSDS_TF_HL").setValue(1);
		
		/** ... and the base packet. */
		factory.getParameter("CCSDS_VERSION").setValue(3);
		factory.getParameter("CCSDS_TYPE").setValue(1);
		factory.getParameter("CCSDS_SEC_HD").setValue(0);
		factory.getParameter("CCSDS_APID").setValue(123);
		factory.getParameter("CCSDS_GP_FLAGS").setValue(1);
		factory.getParameter("CCSDS_SSC").setValue(1);
		factory.getParameter("CCSDS_PLENGTH").setValue(1);

		/** ... and the actual packet. */
		factory.getParameter("TEST_COUNTER").setValue(10);
		factory.getParameter("AST10061").setValue(1);

		/** ... and the Frame tail*/
		factory.getParameter("CCSDS_TF_OC").setValue(12);
		factory.getParameter("CCSDS_TF_EC").setValue(12);
		
		BitSet frame = new BitSet();

		System.out.println("Initial values:");
		int length = 0;
		try {
			length = factory.getContainer("TMFrame").getLength();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(length == 175);
		try {
			System.out.println("Total length: " + factory.getContainer("TMFrame").getLength() + " bit(s).");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** Flip the bit 175 (one larger than the size based on 0 index) to make sure the
		 * bit set does not truncate itself. Else it will remove the trailing 0's, i.e. its
		 * length will become LESS than 175. */
		frame.set(length);
		
		/** Test print the content as a string. */
		try {
			System.out.println(factory.getContainer("TMFrame").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** Marshall it to a BitSet. */
		FrameBrokerImpl processor = new FrameBrokerImpl(factory);
		processor.marshall("TMFrame", frame);
		
		/** Visualize the BitSet*/
		System.out.println(BitSetUtility.binDump(frame));
		
		/** Reset all values. */
		factory.getParameter("CCSDS_FVERSION").setValue(0);
		factory.getParameter("CCSDS_SC_ID").setValue(0);
		factory.getParameter("CCSDS_TF_VC").setValue(0);
		factory.getParameter("CCSDS_OP_CTRL").setValue(0);
		factory.getParameter("CCSDS_MS_CNT").setValue(0);
		factory.getParameter("CCSDS_VC_CNT").setValue(0);
		factory.getParameter("CCSDS_TF_SECH").setValue(0);
		factory.getParameter("CCSDS_TF_SYNC").setValue(0);
		factory.getParameter("CCSDS_TF_ORDER").setValue(0);
		factory.getParameter("CCSDS_TF_SEGM").setValue(0);
		factory.getParameter("CCSDS_TF_FH").setValue(0);
		factory.getParameter("CCSDS_TF_HV").setValue(0);
		factory.getParameter("CCSDS_TF_HL").setValue(0);
		
		/** ... and the base packet. */
		factory.getParameter("CCSDS_VERSION").setValue(0);
		factory.getParameter("CCSDS_TYPE").setValue(0);
		factory.getParameter("CCSDS_SEC_HD").setValue(0);
		factory.getParameter("CCSDS_APID").setValue(0);
		factory.getParameter("CCSDS_GP_FLAGS").setValue(0);
		factory.getParameter("CCSDS_SSC").setValue(0);
		factory.getParameter("CCSDS_PLENGTH").setValue(0);

		/** ... and the actual packet. */
		factory.getParameter("TEST_COUNTER").setValue(0);
		factory.getParameter("AST10061").setValue(0);

		/** ... and the Frame tail*/
		factory.getParameter("CCSDS_TF_OC").setValue(0);
		factory.getParameter("CCSDS_TF_EC").setValue(0);

		
		System.out.println("Reset values:");
		
		/** Test print the content as a string. */
		try {
			System.out.println(factory.getContainer("TMFrame").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** Visualize the BitSet*/
		BitSet frame2 = new BitSet();
		processor.marshall("TMFrame", frame2);
		System.out.println(BitSetUtility.binDump(frame2));
		
		
		
		System.out.println("BitSet length = " + frame.length());
		processor.unmarshall("TMFrame", frame);
		
		System.out.println("Reinstated values:");
		
		/** Test print the content as a string. */
		try {
			System.out.println(factory.getContainer("TMFrame").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** Visualize the BitSet*/
		System.out.println(BitSetUtility.binDump(frame));
		
	}

}
