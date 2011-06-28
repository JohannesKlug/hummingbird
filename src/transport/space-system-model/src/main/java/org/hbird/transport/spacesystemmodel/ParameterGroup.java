/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.parameters.Parameter;


/**
 * TODO The standard interface of a ParameterGroup.
 */
public interface ParameterGroup extends SpaceSystemModelItem {
	/**
	 * <p>
	 * Returns the total length of the {@link ParameterGroup} based upon the length of the {@link Parameter}s in this
	 * and all sub-ParameterGroups (if any) and including any restrictions, i.e., only valid ParameterGroups.
	 * </p>
	 * 
	 * <p>
	 * NOTE: Parameters are organised into containers called {@link ParameterGroup}s, these are abstract and have no
	 * size. </br> <b><i>For example</i></b>: a Packet ParameterGroup could be an abstract container consisting of n sub
	 * parameter groups any of which could contain {@link Parameter}s. When iterating over its sub parameter groups it
	 * will encounter parameters; these know how large they are and can return their length value. This value is
	 * propagated back up to the initial parameter group having been summed with all the other sub-parameter groups.
	 * 
	 * @return int the length of the ParameterGroup including all <b>valid</b> contained sub ParameterGroups and
	 *         Parameters.
	 * 
	 */
	int getSizeInBits();


	/**
	 * Add a sub {@link ParameterGroup} to this one.
	 * 
	 * @param container
	 */
	void addParameterGroup(ParameterGroup container);

	/**
	 * Add a collection of sub {@link ParameterGroup}s to this one.
	 * 
	 * @param containers
	 */
	void addParameterGroup(Collection<? extends ParameterGroup> containers);

	/**
	 * Get all {@link ParameterGroup}s contained by this {@link ParameterGroup}
	 * 
	 * @return
	 */
	List<ParameterGroup> getSubParameterGroups();

	/**
	 * Add a {@link Parameter} to this {@link ParameterGroup}.
	 * 
	 * @param parameter
	 */
	void addParameter(Parameter<?> parameter);

	/**
	 * <p>
	 * Adds a restriction for this ParameterGroup based upon a value of a specific {@link Parameter}. This means this
	 * {@link ParameterGroup} is only valid when all restrictions return true given the data currently in the
	 * SpaceSystemModel.
	 * </p>
	 * 
	 * <p>
	 * For example, ParameterGroupA may have a restriction on ParameterX having a value Z. ParameterX can be contained
	 * in any other ParameterGroup. This means that if ParameterX has value E ParameterGroupA will return false
	 * (invalid). Any clients, e.g. a something that decodes binary data using this model, can correctly chose which
	 * ParameterGroups are vald for the specific binary data received.
	 * </p>
	 * 
	 * <i>Remember, the SpaceSystemModel models the entire system, which means every possible definition of the binary
	 * data. This is important when understanding restrictions.</i>
	 * 
	 * @param parameter
	 * @param comparisonValue
	 */
	void addRestriction(Parameter<?> parameter, String predicate);

	/**
	 * Return all restrictions set on this {@link ParameterGroup}
	 * 
	 * @return a Map of all restrictions set on this {@link ParameterGroup}
	 */
	Map<Parameter<?>, String> getRestrictions();

	/**
	 * Process the restrictions set on this ParameterGroup. This method decides whether this ParameterGroup is valid for
	 * the data populating the SpaceSystemModel.
	 * 
	 * @return validity of the ParameterGroup based upon the current data in the SpaceSystemModel.
	 */
	boolean matchRestrictions();

	/**
	 * <p>
	 * TODO Discuss whether this should be an interface method. Perhaps, this is internal workings only and the face we
	 * have a getParents method should be enough. ParameterGroup implementations should deal with managing the parents
	 * be themselves.
	 * </p>
	 * 
	 * Add a parent {@link ParameterGroup} to this {@link ParameterGroup}.
	 * 
	 * @param parent
	 *            a parent to be added to this ParameterGroup.
	 */
	void addParentParameterGroup(ParameterGroup parent);

	/**
	 * Returns all the parents of this ParameterGroup.
	 * 
	 * @return List of this ParameterGroup's parents.
	 */
	List<ParameterGroup> getParentParameterGroup();

}
