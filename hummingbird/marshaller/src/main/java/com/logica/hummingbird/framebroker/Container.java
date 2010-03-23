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
package com.logica.hummingbird.framebroker;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.logica.hummingbird.marshaller.producers.IProducer;

/**
 * The container is the basic element in the Frame Broker's POJO hierarchy. A container
 * is an ordered sequence of other containers, of which some or all may be parameter.
 * 
 * The container is responsible for managing the encoding/decoding of it's portion of the 
 * structured bit-set that represents the encoded data. The container has a length, which
 * is the sum of the length of its sub-containers.  This length may have a value when a 
 * structured bit-set has been processed by the Frame Broker.
 * 
 * The container will only process the bit-set if all restrictions are met. This is used
 * as a switch to turn certain containers on or off as part of the Frame Broker's processing
 * hierarchy. For example, when processing CCSDS space packets, the packet header will define
 * an Application ID (APID) which in turn defines what the structure of the data part of the packet
 * is. For each data structure a Container will exist, i.e., per APID.  The specific container 
 * that processes the packet is configured by adding restrictions to each container.  These
 * restrictions dictate that the APID parameter must have a specific value or be ignored by 
 * this container.
 */
public class Container extends NamedElement implements IContainer {

	/** The restrictions defining when this container should process. Each restriction
	 * is a parameter / string pair. The parameter will convert the string based on
	 * its type and compare itself against the resulting value. If the string is invalid
	 * then this will always count as a failed match. */
	protected Map<IParameter, String> restrictions = new HashMap<IParameter, String>();

	/** The ordered set of sub containers. */
	protected List<IContainer> subContainers = new ArrayList<IContainer>();

	/** Holds the complete portion of the data corresponding to this container. */
	protected BitSet rawValue = null;

	/** The length of this container in bits. The value will hold a BitSet of length >= length + 1. */
	protected int length = 0;
	
	protected List<IProducer> updateObservers = new ArrayList<IProducer>();
	protected List<IProducer> completionObservers = new ArrayList<IProducer>();
	
	/**
	 * Constructor of the Container class.
	 *
	 * @param name The name of the container.
	 * @param shortDescription A one line description of the container, used for tooltip type information.
	 * @param longDescription A detailed description of the container.
	 *
	 */
	public Container(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	/**
	 * Validate whether the restrictions set on this container are fulfilled.
	 * 
	 * @return false if at least one restriction is not meet. True otherwise. 
	 *
	 */
	protected boolean matchRestrictions() {
		/** Check for match against the restriction criteria. The base container will
		 * forward the data to all containers which have been defined with the base
		 * container as a base. The sub containers themselves must decide whether they
		 * are relevant for the processing. */
		boolean match = true;
		Iterator<Entry<IParameter, String>> it = restrictions.entrySet().iterator();
		while (it.hasNext() == true && match == true) {
			Entry<IParameter, String> entry = it.next();				

			/** The restriction is against a parameter value. The value may thus depend on
			 * a parameter which has already be extracted from the same data container. For 
			 * example could the packet header have been processed by the base container and
			 * the APID set to a value. The data is thereafter forwarded to containers who
			 * only process specific APIDs, based on a restriction on the APID. */
			match = entry.getKey().match(entry.getValue());
		}	

		return match;
	}

	@Override
	public BitSet unmarshall(BitSet packet) {
		/** If the packet should be processed by this container. */
		if (matchRestrictions() == true) {
			/** Get the portion that corresponds to this container. We need to set a 'stop' bit
			 * as the BitSet will else automatically shorten itself, i.e. trailing 0's will be lost. */
			rawValue = packet.get(0, getLength());
			rawValue.set(getLength() + 1);
			
			for (IContainer container : subContainers) {
				packet = container.unmarshall(packet);
			}
			
			for (IProducer updateObserver : updateObservers) {
				updateObserver.updated(name, packet);
			}
			
			for (IProducer completionObserver : completionObservers) {
				completionObserver.completed();
			}
		}

		return packet;
	}

	@Override
	public int marshall(BitSet packet, int offset) {
		/** If the packet should be processed by this container. */
		if (matchRestrictions() == true) {
			for (IContainer container : subContainers) {
				offset = container.marshall(packet, offset);
			}
		}		

		return offset;
	}

	// @Override
	public String toxString() {
		/** If the packet should be processed by this container. */
		String str = "";
		if (matchRestrictions() == true) {
			str += "{" + this.name;
			for (IContainer container : subContainers) {
				str += container.toString();
			}
			str += "}";
		}		

		return str;
	}


	/**
	 * Adds a subcontainer to this container. It is the responsibility of the 
	 * caller to ensure that the subcontainers are aded in the right order, i.e.
	 * this function will simply push the container to teh end of the query.
	 *
	 * @param container The container to be added. 
	 *
	 */
	public void addContainer(IContainer container) {
		if (container != null) {
			this.subContainers.add(container);	
		}
		else {
			// TODO log this
			System.out.println("Error; Adding NULL container!");
		}		
	}

	
	/**
	 * Add a restriction to the container. If you know that some restrictions
	 * are typically always meet (typically evaluate to true), where as others 
	 * doesn't, then add the later first.  
	 *
	 * @param model The parameter container to be added as a restriction.
	 * @param value The value that the parameter container must have for the
	 * restriction to evaluate to true. 
	 *
	 */
	public void addRestriction(IParameter model, String value) {
		if (model != null) {
			restrictions.put(model, value);
		}
	}

	@Override
	public int getLength() {

		/** Lazy initialize the attribute upon first access. */
		if (this.length == 0) {
			/** Iterate through all subcontainers and sum the size.*/
			for (IContainer container : subContainers) {
				length += container.getLength();
			}
		}

		return length;
	}

	@Override
	public BitSet getRawValue() {
		return rawValue;
	}

	@Override
	public void addCompletionObserver(IProducer producer) {
		this.completionObservers.add(producer);
		
	}

	@Override
	public void addUpdateObserver(IProducer producer) {
		this.updateObservers.add(producer);
		
	}

	public List<IContainer> getSubContainers() {
		return subContainers;
	}

	
	
}