package org.hbird.business.navigation;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.exchange.navigation.OrbitalState;
import org.hbird.exchange.type.D3Vector;
import org.orekit.errors.OrekitException;
import org.orekit.errors.PropagationException;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.sampling.OrekitFixedStepHandler;
import org.orekit.time.TimeScalesFactory;


/**
 * Callback class of the orekit propagator. The propagator will call the 
 * 'handleStep' method on this object at intervals, providing the next orbital state.
 * This class transforms the orbital state provided by orekit into a generic
 * type, and parses it to the 'direct:OrbitPredictions' route. This route must be
 * configured as part of the system.
 */
public class OrbitalStateInjector implements OrekitFixedStepHandler {

	/** The unique UID */
	private static final long serialVersionUID = 3944670616542918255L;

	/** The producer of the exchanges. */
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	protected CamelContext context = null;

	/** Unique identifier assigned to all orbital data events that generated
	 *  as part of this run. Will be used to identify a complete orbit, and replace
	 *  it with new series when available. */
	protected long datasetidentifier = 0;

	/** The name to be used for each orbital state. Should be used to destinquish between for example 
	 * predicted and actual orbital states. */
	protected String name = "Measured";
	
	public OrbitalStateInjector(String name, long datasetidentifier, CamelContext context, ProducerTemplate producer) {
		this.datasetidentifier = datasetidentifier;
		this.context = context;
		this.producer = producer;
	}
	
	/* (non-Javadoc)
	 * @see org.orekit.propagation.sampling.OrekitFixedStepHandler#handleStep(org.orekit.propagation.SpacecraftState, boolean)
	 */
	public void handleStep(SpacecraftState currentState, boolean isLast) throws PropagationException {

		/** Create position vector. */
		D3Vector position = new D3Vector("Position", "The orbital position of the satellite at the given time.", currentState.getOrbit().getPVCoordinates().getPosition().getX(),
				currentState.getOrbit().getPVCoordinates().getPosition().getY(),
				currentState.getOrbit().getPVCoordinates().getPosition().getZ());

		/** Create velocity vector. */
		D3Vector velocity = new D3Vector("Velocity", "The orbital velocity of the satellite at the given time", currentState.getOrbit().getPVCoordinates().getVelocity().getX(),
				currentState.getOrbit().getPVCoordinates().getVelocity().getY(),
				currentState.getOrbit().getPVCoordinates().getVelocity().getZ());

		try {
			/** Create orbital state. */
			OrbitalState state = new OrbitalState(name, "",  currentState.getDate().toDate(TimeScalesFactory.getUTC()).getTime(), datasetidentifier, position, velocity);

			/** Send the orbital state on the response stream. */
			Exchange exchange = new DefaultExchange(context);
			exchange.getIn().setBody(state);
			producer.send("direct:OrbitPredictions", exchange);

		} catch (OrekitException e) {
			e.printStackTrace();
		}
	}
}
