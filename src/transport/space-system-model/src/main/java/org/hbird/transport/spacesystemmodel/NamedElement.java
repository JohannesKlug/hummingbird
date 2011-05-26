/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel;

import java.util.HashMap;
import java.util.Map;

/**
 * A named element is a container with a unique name and description. The class supports the conversion to a Spring
 * assembly file.
 * 
 * @author Gert Villemos
 */
public abstract class NamedElement {

	/** Map of all named elements. */
	protected Map<String, NamedElement> elements = new HashMap<String, NamedElement>();

	/** The unique name of the element. */
	protected String name;

	/** A one line description of the container, used for tooltip type information. */
	protected String shortDescription;

	/** A detailed description of the container. */
	protected String longDescription;

	/**
	 * Constructor of the NamedElement class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * 
	 */
	public NamedElement(String name, String shortDescription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	/**
	 * Serialize the object to a Spring bean XML definition.
	 * 
	 * @return String XML representation of the object in Spring bean format.
	 * 
	 */
	public String serialize() {
		String bean = "";
		/** TODO Created Spring bean with name='name', using reflection to parse all attributes. */

		return bean;
	}

	/**
	 * Returns the name of the object.
	 * 
	 * @return Name of the object.
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the object.
	 * 
	 * @param String
	 *            The new name of the object.
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the short description of the object.
	 * 
	 * @return Short description of the object.
	 * 
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * Sets the short description of the object.
	 * 
	 * @param String
	 *            The new short description of the object.
	 * 
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * Returns the long description of the object.
	 * 
	 * @return Long description of the object.
	 * 
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * Sets the long description of the object.
	 * 
	 * @param String
	 *            The new long description of the object.
	 * 
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
}
