/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.ParameterObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ParameterGroup is the basic element in the Space System Model's POJO hierarchy. A ParameterGroup is an ordered
 * sequence of other {@link ParameterGroup} and or {@link Parameter}s.
 * 
 * The ParameterGroup is responsible for managing the hierarchy of the binary data it models, for example, this could be
 * a telemetry packet or a telecommand.
 * 
 * The ParameterGroup also tracks the length of the collection of parameters it defines, which is the sum of the length
 * of its Parameters (including those contains in sub-ParameterGroup).
 * 
 * ParameterGroup is part of a single Space System Model which models the hierarchy of all definitions of binary data in
 * a system. This means certain ParameterGroups and Parameters are only valid in specific contexts. The Model uses a
 * concept called restrictions to implement this. A ParameterGroup will return, as part of the interface, whether it is
 * valid based upon n restrictions applied to it. For example, when processing CCSDS space packets, the packet header
 * will define an Application ID (APID) which in turn defines what the structure of the data part of the packet is. For
 * each data structure a ParameterGroup will exist, i.e., per APID. The specific container that processes the packet is
 * configured by adding restrictions to each container. These restrictions dictate that the APID parameter must have a
 * specific value or be ignored by this container.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class DefaultParameterGroup implements ParameterGroup {
	/** Logger for this class */
	private static final Logger LOG = LoggerFactory.getLogger(DefaultParameterGroup.class);

	private final String name;
	private final String shortDescription;
	private final String longDescription;


	/**
	 * The restrictions defining when this container should process. Each restriction is a parameter / string pair. The
	 * parameter will convert the string based on its type and compare itself against the resulting value. If the string
	 * is invalid then this will always count as a failed match.
	 */
	protected Map<Parameter, String> restrictions = new HashMap<Parameter, String>();

	/** The ordered set of sub containers. */
	private final List<ParameterGroup> subContainers = new ArrayList<ParameterGroup>();
	private final List<Parameter> parameters = new ArrayList<Parameter>();


	/**
	 * The length of this container in bits. The value will hold a BitSet of length >= length + 1.
	 */
	protected int length = 0;

	protected List<ParameterGroupObserver> completionObservers = new ArrayList<ParameterGroupObserver>();
	protected List<ParameterObserver> updatedParameterObservers = new ArrayList<ParameterObserver>();

	protected List<ParameterGroup> parents = new ArrayList<ParameterGroup>();


	/**
	 * Constructor of the ParameterGroup class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * 
	 */
	public DefaultParameterGroup(final String name, final String shortDescription, final String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public DefaultParameterGroup(final String name, final String shortDescription, final String longDescription, final List<ParameterGroup> parents) {
		this(name, shortDescription, longDescription);
		for (ParameterGroup p : parents) {
			this.parents.add(p);
		}
	}

	@Override
	public final boolean matchRestrictions() {
		if (restrictions.size() == 0) {
			return true;
		}
		// Check for match against the restriction criteria. The base container will forward the data to all containers
		// which have been defined with the base container as a base. The sub containers themselves must decide whether
		// they are relevant for the processing.
		boolean match = true;
		Iterator<Entry<Parameter, String>> it = restrictions.entrySet().iterator();

		while (it.hasNext() == true && match) {
			Entry<Parameter, String> entry = it.next();

			// The restriction is against a parameter value. The value may thus depend on a parameter which has already
			// be extracted from the same data container. For example could the packet header have been processed by the
			// base container and the APID set to a value. The data is thereafter forwarded to containers who only
			// process specific APIDs, based on a restriction on the APID.
			match = entry.getKey().match(entry.getValue());
		}

		return match;
	}


	// FIXME Move to the Packet broker.
	// @Override
	// public BitSet unmarshall(final BitSet packet) {
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("Unmarshalling " + this.getName());
	// }
	// // Check if the BitSet has been truncated by testing it against the known length of the container.
	// // This should only be possible on the root container since it's the first thing to be tested; everything
	// // else that is passed in is a subset of the root container. If a "truncation reversal" bit is tagged on
	// // the end the sub-containers cannot be truncated.
	// boolean truncated = false;
	// if (packet.length() < getLength()) {
	// truncated = true;
	//
	// if (LOG.isDebugEnabled()) {
	// // TODO Could we just use size instead of length?
	// LOG.debug("The " + name + " packet length (" + packet.length() + ") is less than expected (" + getLength() + ")"
	// + ".  Truncation has occured");
	// LOG.debug("The input packet length = " + packet.length());
	// LOG.debug("The " + name + " packet has been trucated by " + (getLength() - packet.length()));
	// }
	// }
	//
	// // If the BitSet has been truncated we need to set a "truncation reversal" bit after the packet.
	// // We must do this regardless of the matchRestrictions because each unmarshall call returns completedBitData.
	// // If the container is not to be processed the completeBitData must be set to the current packet otherwise
	// // we'll get a null pointer.
	// if (truncated) {
	// completeBitData = packet.get(0, getLength());
	// completeBitData.set(getLength());
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("CompletedBitData post truncation fix = " + BitSetUtility.binDump(completeBitData));
	// }
	// }
	// else {
	// completeBitData = packet;
	// }
	//
	// // If the packet should be processed by this container.
	// if (matchRestrictions()) {
	// for (ParameterGroup container : subContainers) {
	// // The nested calls unmarshall down through the sub containers Specific Containers,
	// // NOTE: Parameter Containers will "chunk" the bitSet (Packet) in order to remove
	// // the section that has already been unmarshalled.
	// completeBitData = container.unmarshall(completeBitData);
	// }
	//
	// for (ParameterGroupObserver completionObserver : completionObservers) {
	// completionObserver.completed(name);
	// }
	// }
	//
	// // As the packet is unmarshalled this BitSet should shrink as the
	// // subcontainers chunk off the previous sections
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("The completeBitData for " + name + " is " + completeBitData.length() + "/" + completeBitData.size() +
	// " long");
	// LOG.debug("CompletedBitData = " + BitSetUtility.binDump(completeBitData));
	// }
	// return completeBitData;
	// }

	// @Override
	// public int marshall(final BitSet packet, int offset) throws BitSetOperationException {
	// // If the packet should be processed by this container.
	// if (matchRestrictions()) {
	// for (ParameterGroup container : subContainers) {
	// offset = container.marshall(packet, offset);
	// }
	// }
	//
	// return offset;
	// }

	@Override
	public String toString() {
		String str = "";

		// If the packet should be processed by this container...
		if (matchRestrictions()) {
			str += getName() + "{";
			for (ParameterGroup container : subContainers) {
				str += container.toString();
			}
			str += "}";
		}

		return str;
	}

	/**
	 * Adds a subcontainer to this container. It is the responsibility of the caller to ensure that the subcontainers
	 * are added in the right order, i.e. this function will simply push the container to the end of the query.
	 * 
	 * @param subParameterGroup
	 *            The container to be added.
	 * 
	 */
	@Override
	public void addParameterGroup(final ParameterGroup subParameterGroup) {
		if (subParameterGroup != null) {
			this.subContainers.add(subParameterGroup);
			subParameterGroup.addParentParameterGroup(this);
		}
		else {
			LOG.warn("Argument ParameterGroup passed to me was null");
		}
	}

	/**
	 * Adds a collection of subcontainers to this container. The containers are added in the order they are removed from
	 * the Collection.
	 * 
	 * @param container
	 *            The Collection of IContainers to be added.
	 * 
	 */
	@Override
	public void addParameterGroup(final Collection<? extends ParameterGroup> containers) {
		for (ParameterGroup container : containers) {
			this.addParameterGroup(container);
		}
	}

	/**
	 * Add a restriction to the container. If you know that some restrictions are typically always met (typically
	 * evaluate to true), where as others doesn't, then add the later first.
	 * 
	 * @param model
	 *            The parameter container to be added as a restriction.
	 * @param value
	 *            The value that the parameter container must have for the restriction to evaluate to true.
	 * 
	 */
	@Override
	public void addRestriction(final Parameter model, final String value) {
		if (model != null) {
			restrictions.put(model, value);
		}
	}

	@Override
	public int getSizeInBits() {
		length = 0;
		if (matchRestrictions()) {
			for (Parameter parameter : parameters) {
				length += parameter.getSizeInBits();
			}
			// Iterate through all sub-containers and sum the size.
			for (ParameterGroup container : subContainers) {
				length += container.getSizeInBits();
			}
		}

		return length;
	}

	@Override
	public void addPacketObserver(final ParameterGroupObserver observer) {
		this.completionObservers.add(observer);

	}

	@Override
	public void addParameterUpdateObserver(final ParameterObserver observer) {
		this.updatedParameterObservers.add(observer);
	}

	@Override
	public List<ParameterGroup> getSubParameterGroups() {
		return subContainers;
	}

	@Override
	public Map<Parameter, String> getRestrictions() {
		return restrictions;
	}

	@Override
	public List<ParameterGroup> getParentParameterGroup() {
		return parents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hbird.spacesystemmodel.Container#setParent(org.hbird.spacesystemmodel.Container)
	 */
	@Override
	public void addParentParameterGroup(final ParameterGroup parentContainer) {
		if (parentContainer != null) {
			this.parents.add(parentContainer);
		}
	}

	@Override
	public void addParameter(final Parameter parameter) {
		this.parameters.add(parameter);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
	}
}
