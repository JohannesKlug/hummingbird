package com.logica.hummingbird.telemetry;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSpacePacket implements HummingbirdPacket {
	private final static Logger LOG = LoggerFactory.getLogger(DefaultSpacePacket.class);
	
	String name = "Default packet";
	List<HummingbirdParameter> parameters;
	protected long sourceSequenceCounter = 0;

	public DefaultSpacePacket() {
	}
	
	public DefaultSpacePacket(String name) {
		this.name = name;
	}

	@Override
	public List<HummingbirdParameter> getParameters() {
		return parameters;
	}

	@Override
	public void addParameter(HummingbirdParameter parameter) {
		if (this.parameters == null) {
			this.parameters = new ArrayList<HummingbirdParameter>();
		}
		this.parameters.add(parameter);
		if(LOG.isDebugEnabled()) {
			LOG.debug("Added parameter " + parameter + " to " + this.name + " packet.");
		}
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Packet [name=");
		builder.append(name);
		builder.append(", parameters=");
		builder.append(parameters);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public HummingbirdParameter getParameter(String name) {
		HummingbirdParameter found = null;
		for(HummingbirdParameter param : this.parameters) {
			if(param.getName().equals(name)) {
				found = param;
			}
		}
		return found;
	}

	@Override
	public long getSouceSequenceCounter() {
		return sourceSequenceCounter;
	}

}
