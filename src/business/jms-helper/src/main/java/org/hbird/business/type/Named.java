package org.hbird.business.type;

import java.io.Serializable;

public class Named implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	
	protected String description;
	
	public Named(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
}
