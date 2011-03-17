package com.logica.hummingbird.navigation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.exchange.orbital.OrbitPredictionRequest;
import org.hbird.exchange.orbital.Satellite;
import org.hbird.exchange.type.D3Vector;
import org.hbird.exchange.type.Location;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;


@ContextConfiguration (locations={"/OrbitPredictionTest-context.xml"})
public class OrbitPredictionTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Start")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:End")
	protected MockEndpoint consumerQueue;

	@Autowired
    protected CamelContext context;
	
	@Test
	public void testProcess() {
		locations.add(groundStation1);
		locations.add(groundStation2);
		
		/** Create request. Predicts for 1 hour at 60 seconds intervals.  */
		OrbitPredictionRequest request = new OrbitPredictionRequest(satellite, position, velocity, (new Date()).getTime(), locations);
		request.deltaPropagation = 3600;

		/** Create exchange and send it. */
		Exchange exchange = new DefaultExchange(context);
		exchange = new DefaultExchange(context);
		exchange.getIn().setBody(request);
				
		template.send(exchange);
		
		/** Keep iterating as long as the module is injecting data. */
		int count = 0;
		int newCount = 0;
		{
			count = newCount;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			newCount = consumerQueue.getReceivedCounter();
		} while(newCount > count);
		
		/** Assert the provided data. */
		assertTrue(consumerQueue.getReceivedCounter() == 1);

	}
	
	
	
	Satellite satellite = new Satellite("Humsat", "Test satellite.");
	Location groundStation1 = new Location("GS1", "Ground station 1", new D3Vector("Position", "The position", Math.toRadians(45.), Math.toRadians(25.), 0.));
	Location groundStation2 = new Location("GS2", "Ground station 2", new D3Vector("Position", "The position", Math.toRadians(145.), Math.toRadians(10.), 0.));
	List<Location> locations = new ArrayList<Location>();
	
	D3Vector position  = new D3Vector("", "", -6142438.668, 3492467.560, -25767.25680);
	D3Vector velocity  = new D3Vector("", "", 505.8479685, 942.7809215, 7435.922231);
	
	
	/** Setup the ground station visibility detector. */
	double longitude = Math.toRadians(45.);
	double latitude  = Math.toRadians(25.);
	double altitude  = 0.;


}
