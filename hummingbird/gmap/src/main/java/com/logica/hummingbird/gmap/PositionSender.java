package com.logica.hummingbird.gmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;


/**
 * Simple class for collecting coordinates (longitude, latitude and elevation) and
 * forwarding them through cometd to a client.
 */
public class PositionSender {

	/** The class logger. */
	protected static Logger logger = Logger.getLogger(PositionSender.class);

	protected long counter = 0;

	/** Map holdidng the coordinate longitude, latitude, elevation and time. */
	protected Map<String, Double> coordinate = new ConcurrentHashMap<String, Double>();

	protected Map<String, Boolean> states = new ConcurrentHashMap<String, Boolean>();

	/** The camel producer template used to create exchanges send through camel. The variable is set
	 * as part of the Spring assembly.*/
	protected ProducerTemplate template = null;

	/**
	 * Method for receiving longitude updates.
	 * 
	 * @param arg0 Exchange containing the longitude as a parameter.
	 */
	public void processLongitude(Exchange arg0) {
		logger.trace("Received longitude update.");
		coordinate.put("longitude", (Double) arg0.getIn().getHeader("Value"));
		coordinate.put("time", ((Long) arg0.getIn().getHeader("Timestamp")).doubleValue());
	}

	/**
	 * Method for receiving latitude updates.
	 * 
	 * @param arg0 Echange containing the latitude as a parameter.
	 */
	public void processLatitude(Exchange arg0) {
		logger.trace("Received latitude update.");
		coordinate.put("latitude", (Double) arg0.getIn().getHeader("Value"));
		coordinate.put("time", ((Long) arg0.getIn().getHeader("Timestamp")).doubleValue());
	}

	/**
	 * Method for receiving elevation updates.
	 * 
	 * @param arg0 Echange containing the elevation as a parameter.
	 */
	public void processElevation(Exchange arg0) {
		logger.trace("Received elevation update.");
		coordinate.put("elevation", (Double) arg0.getIn().getHeader("Value"));
		coordinate.put("time", ((Long) arg0.getIn().getHeader("Timestamp")).doubleValue());
	}

	/**
	 * Method for receiving elevation updates.
	 * 
	 * @param arg0 Echange containing the elevation as a parameter.
	 */
	public void processState(Exchange arg0) {
		logger.trace("Received state update.");
		states.put((String) arg0.getIn().getHeader("Name"), (Boolean) arg0.getIn().getHeader("Value"));
	}

	/**
	 * Method for actually sending the update to the client. The method is called by a timer at
	 * intervals.
	 * 
	 * @param arg0 Time Exchange triggering the sending.
	 * @throws Exception
	 */
	public void processSend(Exchange arg0) throws Exception {
		/** If the coordinate is ready, i.e. all attributes have been set, then update. */
		logger.trace("Streaming update to cometd.");

		coordinate.put("state", 0d);
		Iterator<Entry<String, Boolean>> it = states.entrySet().iterator();
		while (it.hasNext() == true) {
			Entry<String, Boolean> pair = it.next();
			if (pair.getValue() == false) {
				coordinate.put("state", 1d);
				break;
			}
		}

		arg0.getIn().setBody(coordinate);
	}

	/**
	 * Setter for the consumer template used to send messages to the client.
	 * 
	 * @param template The consumer template.
	 */
	public void setTemplate(ProducerTemplate template) {
		this.template = template;
	}	
}
