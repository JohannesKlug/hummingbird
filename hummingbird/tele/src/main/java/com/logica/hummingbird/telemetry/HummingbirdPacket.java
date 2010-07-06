package com.logica.hummingbird.telemetry;

import java.util.List;

public interface HummingbirdPacket {
	public List<HummingbirdParameter> getParameters();
	
	public void addParameters(HummingbirdParameter parameter);
	
	public void setName(String name);
	
	public String getName();
}
