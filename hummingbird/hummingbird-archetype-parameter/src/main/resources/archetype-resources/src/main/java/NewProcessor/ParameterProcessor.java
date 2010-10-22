#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.NewProcessor;


import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import com.logica.hummingbird.BaseExchangeParameterFactory;
import com.logica.hummingbird.telemetry.HummingbirdParameter;
import com.logica.hummingbird.telemetry.NotComparableTypeException;

public abstract class ParameterProcessor {

	private static org.apache.log4j.Logger logger = Logger.getLogger(ParameterProcessor.class);
	
	String stateOff = "";
	String stateName = "";
	
	protected HummingbirdParameter enabled = null;
	protected HummingbirdParameter limit = null;
	protected HummingbirdParameter parameter = null;

	public void process(Exchange arg0) throws Exception {
		logger.debug(stateName + " of " + stateOff + " received parameter value for validation.");
		parameter = BaseExchangeParameterFactory.getInstance().fromBody(arg0);
		doProcess(arg0);	
	}

	/**
	 * Method for receiving a notification of a limit update.
	 * 
	 * @param arg0
	 * @throws Exception
	 */
	public void processLimit(Exchange arg0) throws Exception {
		logger.debug(stateName + " of " + stateOff + " received limit change parameter.");
		limit = BaseExchangeParameterFactory.getInstance().fromBody(arg0);
		doProcess(arg0);	
	}

	/**
	 * Method for receiving a notification of a enable / disable switch.
	 * 
	 * @param arg0
	 * @throws Exception
	 */
	public void processEnabled(Exchange arg0) throws Exception {
		logger.debug(stateName + " of " + stateOff + " received enable setting.");
		enabled = BaseExchangeParameterFactory.getInstance().fromBody(arg0);
		doProcess(arg0);
	}
	
	protected void doProcess(Exchange arg0) throws NotComparableTypeException {
		if (isEnabled() == true && isReady()) {
			logger.debug(stateName + " of " + stateOff + " creating state variable.");
			BaseExchangeParameterFactory.getInstance().addStateParameter(arg0, stateName, stateOff, checkLimit());
		}
		else {
			logger.debug(stateName + " of " + stateOff + " is not enabled and / or ready. Route terminated.");
			arg0.setProperty(Exchange.ROUTE_STOP, true);
		}		
	}

	/**
	 * Method to determin whether this limit is currently enabled. The limit will be
	 * enabled if;
	 * 1) The parameter determining whether it is enabled is 'null', i.e. not set.
	 * 2) The parameter determining whether it is enabled is not null and has the value 'true'.
	 * 
	 * @return Flag that will be true of the limit is enabled. Else false.
	 */
	public boolean isEnabled() {
		return enabled == null || enabled.asBoolean() == true;
	}

	public boolean isReady() {
		return limit != null && parameter != null;
	}
	
	/**
	 * Before calling the method the user must ensure that the parameter and the limit are 
	 * not null. This should be done using the 'isReady()' method.
	 * 
	 * @return boolean which is true if the parameter is within the limit, else false.
	 * @throws NotComparableTypeException
	 */
	protected abstract boolean checkLimit() throws NotComparableTypeException;
}
