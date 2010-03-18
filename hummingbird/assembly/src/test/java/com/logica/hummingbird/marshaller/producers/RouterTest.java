package com.logica.hummingbird.marshaller.producers;
import java.util.BitSet;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.util.jndi.JndiContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.marshaller.BitSetUtility;
import com.logica.hummingbird.marshaller.ContainerProcessor;
import com.logica.hummingbird.xtce.XtceModelFactory;

public class RouterTest extends CamelTestSupport {
	
	protected static XtceModelFactory xtceFactory = new XtceModelFactory();
	
	protected static ContainerProcessor processor = null; 
	
    @EndpointInject(uri = "mock:frames")
    protected MockEndpoint frameEndpoint;
    
    @EndpointInject(uri = "mock:packets")
    protected MockEndpoint packetEndpoint;
    
    @EndpointInject(uri = "mock:parameters")
    protected MockEndpoint parameterEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;
    
//    @Before
//    public void prepare() {
//    	Logger logger =  Logger.getRootLogger();
//    	logger.setLevel(Level.WARN);
//    }
    
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
        	
            public void configure() throws Exception {
            	

            	
            	
            	xtceFactory = new XtceModelFactory();
            	xtceFactory.setSpacesystemmodelFilename("src/test/resources/humsat.xml");
            	xtceFactory.initialise();
            	processor = new ContainerProcessor(xtceFactory);
            	
            	
                from("direct:start")
                .split().method(processor, "split")
                .choice()
                .when(header("Type").isEqualTo("TMPacket")).to(packetEndpoint)
                .when(header("Type").isEqualTo("TMParameter")).to(parameterEndpoint)
                .when(header("Type").isEqualTo("TMFrame")).to(frameEndpoint)
                    ;
                
                // Add router to multiplex into the different streams.
        }
        };
    }

    @Test
    public void testRouter() throws Exception {

        /** Send to end point. */
		assertNotNull("template is null.", template);
		template.sendBody(TestParameterProducer.getFrame());
        
        /** Check we got the expected output. */        
		parameterEndpoint.expectedMessageCount(24);
		parameterEndpoint.assertIsSatisfied();
		
		packetEndpoint.expectedMessageCount(1);
		packetEndpoint.assertIsSatisfied();
		
		frameEndpoint.expectedMessageCount(1);
		frameEndpoint.assertIsSatisfied();
		
		System.out.println("Number of received frames: " + frameEndpoint.getReceivedCounter());
		System.out.println("Number of received packets: " + packetEndpoint.getReceivedCounter());
		System.out.println("Number of received parameters: " + parameterEndpoint.getReceivedCounter());

    }
		
}
