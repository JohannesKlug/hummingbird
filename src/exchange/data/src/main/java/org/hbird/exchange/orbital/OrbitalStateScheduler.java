package org.hbird.exchange.orbital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.hbird.exchange.type.Location;
import org.hbird.exchange.type.Satellite;
import org.springframework.beans.factory.annotation.Autowired;

public class OrbitalStateScheduler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4787275022054480174L;

	/** Queue for the task schedule. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	protected OrbitalState currentOrbitalstate = null;
	protected Satellite satellite = null;
	protected Map<String, Location> locations = null;
	
	protected Double deltaPropagation = 3600.;
	protected Double stepSize = 60.;
	
	protected String name = "Measured";

	/**  */
	protected long lastPrediction = 0l;

	protected long predictionInterval = 24 * 60 * 60 * 1000;

	public OrbitalStateScheduler(String name, Satellite satellite, OrbitalState initialOrbitalstate, List<Location> locations) {
		this.name = name;
		this.currentOrbitalstate = initialOrbitalstate;
		this.satellite = satellite;

		this.locations = new HashMap<String, Location>();
		for (Location location : locations) {
			this.locations.put(location.getName(), location);
		}
	}

	public void process(Exchange exchange) {
		synchronized(this) {
			long now = (new Date()).getTime();
			if (currentOrbitalstate != null && now > (lastPrediction + predictionInterval)) {
				OrbitPredictionRequest request = new OrbitPredictionRequest(name, satellite, currentOrbitalstate, new ArrayList<Location>(locations.values()));
				request.deltaPropagation = deltaPropagation; 
				request.stepSize = stepSize;
				request.starttime = (new Date()).getTime();
				exchange.getIn().setBody(request);
				lastPrediction = now;
			}
			else {
				exchange.setProperty(Exchange.ROUTE_STOP, true);
			}
		}
	}

	/**
	 * Sets the current orbital state. Should be used to constantly set the 
	 * orbital state to the latest state available. For example the following 
	 * route could be used
	 * 
	 *  <route>
	 *    TODO
	 *  </route>
	 * 
	 * @param exchange The exchange carrying the new orbital state.
	 */
	public void processOrbitalState(Exchange exchange) {
		synchronized(this) {
			if (exchange.getIn().getBody() instanceof OrbitalState) {
				this.currentOrbitalstate = (OrbitalState) exchange.getIn().getBody();
			}
		}
	}	


	public void processLocation(Exchange exchange) {
		synchronized(this) {
			if (exchange.getIn().getBody() instanceof Location) {
				Location location = (Location) exchange.getIn().getBody(); 
				locations.put(location.getName(), location);
			}		
		}
	}

	public void setPredictionInterval(long predictionInterval) {
		this.predictionInterval = predictionInterval;
	}

	public void setDeltaPropagation(Double deltaPropagation) {
		this.deltaPropagation = deltaPropagation;
	}

	public void setStepSize(Double stepSize) {
		this.stepSize = stepSize;
	}
}
