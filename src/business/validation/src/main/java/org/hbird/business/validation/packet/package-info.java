/**
 * A parameter can have a state.
 * 
 * The state is a superposition, i.e. it consists of multiple substates. A few standard 
 * substates are;
 * 1. Out of Limit. The parameter is out of some limit.
 * 2. Lost. A gap has been detected in the parameter at some time, i.e. dat has been lost.
 * Other states can easily be created.
 * 
 * A sub state always has one of two values;
 *  [True] The state is nominal.
 *  [False] The state has failed.
 * 
 * Each substate is itself a parameter and is by the system created, distributed and stored
 * as a parameter. The connection between a parameter and the sub state is defined by the 
 * configuration. There is no reason (except to keep it simple) to let a sub state parameter
 * itself have a sub state parameter, to enable / disable the usage of a state.
 * 
 * To define a new state
 * 1. Create a class that extends the 'Rule' class.
 * 2. In the constructor of the class, set the 'stateName' parameter to the name of the new state.
 * 3. Implement the method validating the state. The method should return true / false for nominal / violated.
 * 4. Add the rule to the validator components XML configuration.
 * 
 * */

package org.hbird.business.validation.packet;

