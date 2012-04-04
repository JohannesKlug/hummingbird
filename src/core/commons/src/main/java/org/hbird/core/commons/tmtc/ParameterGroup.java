package org.hbird.core.commons.tmtc;

import java.io.Serializable;


/**
 * TODO The standard interface of a ParameterGroup. Currently a type marker as it does not introduce any additional
 * functionality to the tmtcgroup contract.
 */
public interface ParameterGroup extends TmTcGroup, Serializable {

	void setTimeStamp(long timeStamp);
}
