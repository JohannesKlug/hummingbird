package org.hbird.core.commons.tmtc;



/**
 * TODO The standard interface of a ParameterGroup. Currently a type marker as it does not introduce any additional
 * functionality to the tmtcgroup contract.
 */
public interface ParameterGroup extends TmTcGroup {

	void setTimeStamp(long timeStamp);
}
