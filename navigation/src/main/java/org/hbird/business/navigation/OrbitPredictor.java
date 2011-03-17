package org.hbird.business.navigation;

import java.util.Date;

import org.apache.camel.Exchange;
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

/** 
 * Processor of 'OrbitalPredictionRequests', implemented based on the OREKIT open source
 * tool. 
 * 
 */
public class OrbitPredictor {

	/** TODO I dont what this does buts OREKIT needs it...*/
	protected double maxcheck  = 1.;

	/** The exchange must contain a OrbitalState object as the in-body. */
	public void process(Exchange exchange) {

		OrbitPredictionRequest request = (OrbitPredictionRequest) exchange.getIn().getBody();

		try {
			// Inertial frame			
			Vector3D position  = new Vector3D((Double) request.position.p1.getValue(), (Double) request.position.p2.getValue(), (Double) request.position.p3.getValue());
			Vector3D velocity  = new Vector3D((Double) request.velocity.p1.getValue(), (Double) request.velocity.p2.getValue(), (Double) request.velocity.p3.getValue());
			PVCoordinates pvCoordinates = new PVCoordinates(position, velocity);

			Date now = new Date(request.starttime);
			AbsoluteDate initialDate = new AbsoluteDate(now.getYear() + 1970, now.getMonth() + 1, now.getDate(), now.getMinutes(), now.getSeconds(), 00.000, TimeScalesFactory.getUTC());
			Frame inertialFrame = FramesFactory.getEME2000();
			
			// Initial date
			Orbit initialOrbit = new KeplerianOrbit(pvCoordinates, inertialFrame, initialDate, Double.parseDouble(System.getProperty("hummingbird.navigation.mu")));

			// NumericalPropagator propagator = new NumericalPropagator(integrator);
			Propagator propagator = new KeplerianPropagator(initialOrbit);

			/** Register the visibility events for the requested locations. */
			if (request.locations != null) {
				for (Location location : request.locations) {
					GeodeticPoint point = new GeodeticPoint((Double) location.getPosition().p1.getValue(), (Double) location.getPosition().p2.getValue(), (Double) location.getPosition().p3.getValue());				
					BodyShape earth = new OneAxisEllipsoid(Double.parseDouble(System.getProperty("hummingbird.navigation.ae")), Double.parseDouble(System.getProperty("hummingbird.navigation.f")), FramesFactory.getITRF2005());
					TopocentricFrame sta1Frame = new TopocentricFrame(earth, point, location.getName());

					/** Register the injector that will send the detected events, for this location, to the propagator. */
					EventDetector sta1Visi = new LocationContactEventInjector(maxcheck, location.getThresholdElevation(), sta1Frame, request.satelitte, location);
					propagator.addEventDetector(sta1Visi);				
				}
			}

			OrbitalStateInjector injector = new OrbitalStateInjector();
			propagator.setMasterMode(request.stepSize, injector);			
			propagator.propagate(new AbsoluteDate(initialDate, request.deltaPropagation));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
