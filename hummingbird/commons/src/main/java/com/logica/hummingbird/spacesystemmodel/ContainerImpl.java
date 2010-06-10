/* ----------------------------------------------------------------------------
 * (c) Copyright Logica 2010
 *
 * All rights reserved. This document is protected by international copyright 
 * law and may not be reprinted, reproduced, copied or utilised in whole or in 
 * part by any means including electronic, mechanical, or other means without 
 * the prior written consent of Logica. 
 * Whilst reasonable care has been taken by Logica to ensure the information 
 * contained herein is reasonably accurate, Logica shall not, under any 
 * circumstances be liable for any loss or damage (direct or consequential) 
 * suffered by any party as a result of the contents of this publication or the 
 * reliance of any party thereon or any inaccuracy or omission therein. The 
 * information in this document is therefore provided on an "as is" basis 
 * without warranty and is subject to change without further notice and cannot 
 * be construed as a commitment by Logica. 
 * The products mentioned in this document are identified by the names, 
 * trademarks, service marks and logos of their respective companies or 
 * organisations and may not be used in any advertising or publicity or in any 
 * other way whatsoever without the prior written consent of those companies 
 * or organisations and Logica.
 * ----------------------------------------------------------------------------
 * System       : Hummingbird
 * Author       : VillemosG
 * Created on   : 08.01.2010
 * ----------------------------------------------------------------------------
 */
package com.logica.hummingbird.spacesystemmodel;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.parameters.Parameter;

/**
 * The container is the basic element in the Frame Broker's POJO hierarchy. A container is an ordered sequence of other
 * containers, of which some or all may be parameter.
 * 
 * The container is responsible for managing the encoding/decoding of it's portion of the structured bit-set that
 * represents the encoded data. The container has a length, which is the sum of the length of its sub-containers. This
 * length may have a value when a structured bit-set has been processed by the Frame Broker.
 * 
 * The container will only process the bit-set if all restrictions are met. This is used as a switch to turn certain
 * containers on or off as part of the Frame Broker's processing hierarchy. For example, when processing CCSDS space
 * packets, the packet header will define an Application ID (APID) which in turn defines what the structure of the data
 * part of the packet is. For each data structure a Container will exist, i.e., per APID. The specific container that
 * processes the packet is configured by adding restrictions to each container. These restrictions dictate that the APID
 * parameter must have a specific value or be ignored by this container.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 */
public class ContainerImpl extends NamedElement implements Container {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ContainerImpl.class);

	/**
	 * The restrictions defining when this container should process. Each restriction is a parameter / string pair. The
	 * parameter will convert the string based on its type and compare itself against the resulting value. If the string
	 * is invalid then this will always count as a failed match.
	 */
	protected Map<Parameter, String> restrictions = new HashMap<Parameter, String>();

	/** The ordered set of sub containers. */
	protected List<Container> subContainers = new ArrayList<Container>();

	/** Holds the complete portion of the data corresponding to this container. */
	protected BitSet completeBitData = null;

	/**
	 * The length of this container in bits. The value will hold a BitSet of length >= length + 1.
	 */
	protected int length = 0;

	protected List<ContainerObserver> updateObservers = new ArrayList<ContainerObserver>();
	protected List<ContainerObserver> completionObservers = new ArrayList<ContainerObserver>();
	protected List<ParameterObserver> updatedParameterObservers = new ArrayList<ParameterObserver>();

	protected Container parent = null;

	/**
	 * Constructor of the Container class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * 
	 */
	public ContainerImpl(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	/**
	 * Validate whether the restrictions set on this container are fulfilled.
	 * 
	 * @return false if at least one restriction is not meet. True otherwise.
	 * 
	 */
	protected boolean matchRestrictions() {
		// Check for match against the restriction criteria. The base container will forward the data to all containers
		// which have been defined with the base container as a base. The sub containers themselves must decide whether
		// they are relevant for the processing.
		boolean match = true;
		Iterator<Entry<Parameter, String>> it = restrictions.entrySet().iterator();

		while (it.hasNext() == true && match == true) {
			Entry<Parameter, String> entry = it.next();

			// The restriction is against a parameter value. The value may thus depend on a parameter which has already
			// be extracted from the same data container. For example could the packet header have been processed by the
			// base container and the APID set to a value. The data is thereafter forwarded to containers who only
			// process specific APIDs, based on a restriction on the APID.
			match = entry.getKey().match(entry.getValue());
		}

		return match;
	}

	@Override
	public BitSet unmarshall(BitSet packet) {
		// Check if the BitSet has been truncated by testing it against the known length of the container.
		// This should only be possible on the root container since it's the first thing to be tested; everything
		// else that is passed in is a subset of the root container. If a "truncation reversal" bit is tagged on
		// the end the sub-containers cannot be truncated.
		boolean truncated = false;
		if (packet.length() < getLength()) {
			truncated = true;

			if (LOG.isDebugEnabled()) {
				LOG.debug("The " + name + " packet length (" + getLength() + ") is less than expected.  Truncation has occured");
				LOG.debug("The input packet length = " + packet.length());
				LOG.debug("The " + name + " packet has been trucated by " + (getLength() - packet.length()));
			}
		}

		// If the BitSet has been truncated we need to set a "truncation reversal" bit after the packet.
		// We must do this regardless of the matchRestrictions because each unmarshall call returns completedBitData.
		// If the container is not to be processed the completeBitData must be set to the current packet otherwise
		// we'll get a null pointer.
		if (truncated) {
			completeBitData = packet.get(0, getLength());
			completeBitData.set(getLength() + 1);
		}
		else {
			completeBitData = packet;
		}

		// If the packet should be processed by this container.
		if (matchRestrictions() == true) {
			for (Container container : subContainers) {
				// The nested calls unmarshall down through the sub containers Specific Containers,
				// NOTE: Parameter Containers will "chunk" the bitSet (Packet) in order to remove
				// the section that has already been unmarshalled.
				completeBitData = container.unmarshall(completeBitData);
			}

			for (ContainerObserver updateObserver : updateObservers) {
				updateObserver.updated(name, completeBitData);
			}

			for (ContainerObserver completionObserver : completionObservers) {
				completionObserver.completed();
			}
		}

		// As the packet is unmarshalled this BitSet should shrink as the
		// subcontainers chunk off the previous sections
		if (LOG.isDebugEnabled()) {
			LOG.debug("The completeBitData for " + name + " is " + completeBitData.length() + "/" + completeBitData.size() + " long");
		}
		return completeBitData;
	}

	@Override
	public int marshall(BitSet packet, int offset) {
		/** If the packet should be processed by this container. */
		if (matchRestrictions() == true) {
			for (Container container : subContainers) {
				offset = container.marshall(packet, offset);
			}
		}

		return offset;
	}

	@Override
	public String toString() {
		String str = "";

		// If the packet should be processed by this container...
		if (matchRestrictions() == true) {
			str += "{" + this.name;
			for (Container container : subContainers) {
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
	 * @param container
	 *            The container to be added.
	 * 
	 */
	public void addContainer(Container container) {
		if (container != null) {
			this.subContainers.add(container);
		}
		else {
			LOG.warn("Argument IContainer passed to me was null");
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
	public void addContainer(Collection<? extends Container> containers) {
		for (Container container : containers) {
			this.addContainer(container);
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
	public void addRestriction(Parameter model, String value) {
		if (model != null) {
			restrictions.put(model, value);
		}
	}

	/**
	 * Returns the length of the complete container in bits. This simply iterates over all the sub containers until
	 * getting the lengths of each one that matches the restrictions. The length of a Container is defined as the 
	 * length of all it's SubContainers parameters <b>taking any restrictions into account</b>. These parameters may be 
	 * grouped into other containers, e.g., headers, packet body etc but these are conceptual and have no size. For  
	 * example, a FrameHeader Container is an abstract container consisting of n sub containers, x of this will be 
	 * concrete parameter values (where x <= n). When iterating over its sub containers it will eventually hit the 
	 * parameters of which it is made up; these know how large they are and return their length value. This value 
	 * is propagated back up to the initial container having been summed with all the other sub-containers via the 
	 * getLength methods loop.
	 * 
	 * The length is reset before each call.
	 */
	@Override
	public int getLength() {
		length = 0;
		if (matchRestrictions() == true) {
			// Iterate through all sub-containers and sum the size.
			for (Container container : subContainers) {
				length += container.getLength();
			}
		}

		return length;
	}

	@Override
	public BitSet getRawValue() {
		return completeBitData;
	}

	@Override
	public void addCompletionObserver(ContainerObserver observer) {
		this.completionObservers.add(observer);

	}

	@Override
	public void addUpdateObserver(ContainerObserver observer) {
		this.updateObservers.add(observer);

	}

	@Override
	public void addParameterUpdateObserve(ParameterObserver observer) {
		this.updatedParameterObservers.add(observer);
	}

	public List<Container> getSubContainers() {
		return subContainers;
	}
}
