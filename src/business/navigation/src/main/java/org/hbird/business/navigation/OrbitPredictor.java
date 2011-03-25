package org.hbird.business.navigation;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.math.geometry.Vector3D;
import org.hbird.exchange.type.Location;
import org.hbird.exchange.orbital.OrbitPredictionRequest;
import org.orekit.bodies.BodyShape;
import org.orekit.bodies.GeodeticPoint;
import org.orekit.bodies.OneAxisEllipsoid;
import org.orekit.frames.Frame;
import org.orekit.frames.FramesFactory;
import org.orekit.frames.TopocentricFrame;
import org.orekit.orbits.KeplerianOrbit;
import org.orekit.orbits.Orbit;
import org.orekit.propagation.Propagator;
import org.orekit.propagation.analytical.KeplerianPropagator;
import org.orekit.propagation.events.EventDetector;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScalesFactory;
import org.orekit.utils.PVCoordinates;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * Processor of 'OrbitalPredictionRequests', implemented based on the OREKIT open source
 * tool. 
 * 
 * For an example of how to use, see https://www.orekit.org/forge/projects/orekit/repository/revisions/4decf40db88b02ce82ec9cac7629536c701ac535/entry/src/tutorials/fr/cs/examples/propagation/VisibilityCheck.java
 */
public class OrbitPredictor {

	/** TODO I dont what this does buts OREKIT needs it...*/
	protected double maxcheck  = 1.;

	/** gravitation coefficient */
	protected Double mu = 3.986004415e+14; 
	
	/** flattening */
	protected Double f  =  1.0 / 298.257223563; 
	
	/** equatorial radius in meter */
	protected Double ae = 6378137.0; 

	@Autowired
	protected CamelContext context = null;
	
	/** The producer of the exchanges. */
	@Autowired
	protected ProducerTemplate producer = null;
	
	/** The exchange must contain a OrbitalState object as the in-body. */
	public void process(Exchange exchange) {

		System.setProperty("orekit.data.path", "D:/Benutzer-Profile/villemosg/hummingbird/src/business/navigation/src/main/resources");
		
		OrbitPredictionRequest request = (OrbitPredictionRequest) exchange.getIn().getBody();

		try {
			// Inertial frame			
			Vector3D position  = new Vector3D((Double) request.position.p1.getValue(), (Double) request.position.p2.getValue(), (Double) request.position.p3.getValue());
			Vector3D velocity  = new Vector3D((Double) request.velocity.p1.getValue(), (Double) request.velocity.p2.getValue(), (Double) request.velocity.p3.getValue());
			PVCoordinates pvCoordinates = new PVCoordinates(position, velocity);

			Date now = new Date(request.starttime);
			AbsoluteDate initialDate = new AbsoluteDate(now.getYear() + 1900, now.getMonth() + 1, now.getDate(), now.getHours(), now.getMinutes(), now.getSeconds(), TimeScalesFactory.getUTC());
			Frame inertialFrame = FramesFactory.getEME2000();
			
			// Initial date
			Orbit initialOrbit = new KeplerianOrbit(pvCoordinates, inertialFrame, initialDate, mu);

			// NumericalPropagator propagator = new NumericalPropagator(integrator);
			Propagator propagator = new KeplerianPropagator(initialOrbit);

			/** Create dataset identifier based on the time. */
			long datasetidentifier = (new Date()).getTime();
			
			/** Register the visibility events for the requested locations. */
			if (request.locations != null) {
				for (Location location : request.locations) {
					GeodeticPoint point = new GeodeticPoint((Double) location.getPosition().p1.getValue(), (Double) location.getPosition().p2.getValue(), (Double) location.getPosition().p3.getValue());				
					BodyShape earth = new OneAxisEllipsoid(ae, f, FramesFactory.getITRF2005());
					TopocentricFrame sta1Frame = new TopocentricFrame(earth, point, location.getName());

					/** Register the injector that will send the detected events, for this location, to the propagator. */
					EventDetector sta1Visi = new LocationContactEventInjector(maxcheck, location.getThresholdElevation(), sta1Frame, request.satelitte, location, datasetidentifier, context, producer);
					propagator.addEventDetector(sta1Visi);				
				}
			}

			OrbitalStateInjector injector = new OrbitalStateInjector(datasetidentifier, context, producer);
			propagator.setMasterMode(request.stepSize, injector);			
			propagator.propagate(new AbsoluteDate(initialDate, request.deltaPropagation));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
