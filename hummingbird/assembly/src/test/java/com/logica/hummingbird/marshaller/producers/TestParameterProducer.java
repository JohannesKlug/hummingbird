package com.logica.hummingbird.marshaller.producers;
import static org.junit.Assert.*;

import java.util.BitSet;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.logica.hummingbird.marshaller.BitSetUtility;
import com.logica.hummingbird.marshaller.ContainerProcessor;
import com.logica.hummingbird.marshaller.IContainerFactory;
import com.logica.hummingbird.xtce.XtceModelFactory;

public class TestParameterProducer extends CamelTestSupport {
	
	protected static XtceModelFactory xtceFactory = new XtceModelFactory();
	
	private ParameterProducer parameterProducer;

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;
    
//    @Before
//    public void setUp() {
////    	Logger logger =  Logger.getAnonymousLogger();
////    	logger.setLevel(Level.WARN);
//    	
//    }
    
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
        	
            public void configure() throws Exception {
            	
            	xtceFactory = new XtceModelFactory();
            	xtceFactory.setSpacesystemmodelFilename("src/test/resources/humsat.xml");
            	xtceFactory.initialise();
            	ContainerProcessor processor = new ContainerProcessor(xtceFactory);
            	
                from("direct:start")
                .process(processor)
                    .to("mock:result");
        }
        };
    }

    @Test
    public void testInsert() throws Exception {

    	xtceFactory.setSpacesystemmodelFilename("src/test/resources/humsat.xml");
    	
    	/** Create FRAME */

		
		/** Build the frame. */
		xtceFactory.getParameter("CCSDS_FVERSION").setValue(1);
		xtceFactory.getParameter("CCSDS_SC_ID").setValue(3);
		xtceFactory.getParameter("CCSDS_TF_VC").setValue(3);
		xtceFactory.getParameter("CCSDS_OP_CTRL").setValue(1);
		xtceFactory.getParameter("CCSDS_MS_CNT").setValue(5);
		xtceFactory.getParameter("CCSDS_VC_CNT").setValue(6);
		xtceFactory.getParameter("CCSDS_TF_SECH").setValue(1);
		xtceFactory.getParameter("CCSDS_TF_SYNC").setValue(1);
		xtceFactory.getParameter("CCSDS_TF_ORDER").setValue(1);
		xtceFactory.getParameter("CCSDS_TF_SEGM").setValue(1);
		xtceFactory.getParameter("CCSDS_TF_FH").setValue(1);
		xtceFactory.getParameter("CCSDS_TF_HV").setValue(1);
		xtceFactory.getParameter("CCSDS_TF_HL").setValue(1);
		
		/** ... and the base packet. */
		xtceFactory.getParameter("CCSDS_VERSION").setValue(3);
		xtceFactory.getParameter("CCSDS_TYPE").setValue(1);
		xtceFactory.getParameter("CCSDS_SEC_HD").setValue(0);
		xtceFactory.getParameter("CCSDS_APID").setValue(123);
		xtceFactory.getParameter("CCSDS_GP_FLAGS").setValue(1);
		xtceFactory.getParameter("CCSDS_SSC").setValue(1);
		xtceFactory.getParameter("CCSDS_PLENGTH").setValue(1);

		/** ... and the actual packet. */
		xtceFactory.getParameter("TEST_COUNTER").setValue(10);
		xtceFactory.getParameter("AST10061").setValue(1);

		/** ... and the Frame tail*/
		xtceFactory.getParameter("CCSDS_TF_OC").setValue(12);
		xtceFactory.getParameter("CCSDS_TF_EC").setValue(12);
		
		BitSet frame = new BitSet();

		System.out.println("Initial values:");
				int length = xtceFactory.getContainer("TMFrame").getLength();
		assertTrue(length == 175);
		System.out.println("Total length: " + xtceFactory.getContainer("TMFrame").getLength() + " bit(s).");
		
		/** Flip the bit 175 (one larger than the size based on 0 index) to make sure the
		 * bit set does not truncate itself. Else it will remove the trailing 0's, i.e. its
		 * length will become LESS than 175. */
		frame.set(length);
		
		/** Test print the content as a string. */
		System.out.println(xtceFactory.getContainer("TMFrame").toString());
		
		/** Marshall it to a BitSet. */
		ContainerProcessor processor = new ContainerProcessor(xtceFactory);
		processor.marshall("TMFrame", frame);
		
		/** Visualize the BitSet*/
		System.out.println(BitSetUtility.binDump(frame));
		
                
        /** Send to end point. */
		assertNotNull("template is null.", template);
		template.sendBody(frame);
        
        /** Check we got the expected output. */        
		resultEndpoint.expectedMinimumMessageCount(1);
		resultEndpoint.assertIsSatisfied();
		
		System.out.println("Number of received messages: " + resultEndpoint.getReceivedCounter());

		for (Exchange exchange : resultEndpoint.getReceivedExchanges()) {
			/** Print each exchange.*/
			System.out.println("Exchange: " + exchange.toString());
		}
    }

   
	
    
 
	

	@Test
	public void testHeader() {
		parameterProducer = new ParameterProducer();
		parameterProducer.updated("String", "Test");
		parameterProducer.updated("double", Double.MAX_VALUE);
		parameterProducer.updated("int", Integer.MAX_VALUE);
		//parameterProducer.completed();
		
	}

	
	
}
