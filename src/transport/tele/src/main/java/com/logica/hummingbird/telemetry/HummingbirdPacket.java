package org.hbird.telemetry;

import java.util.List;

public interface HummingbirdPacket {
	public void setName(String name);

	public String getName();

	public void addParameter(HummingbirdParameter parameter);

	public List<HummingbirdParameter> getParameters();

	public HummingbirdParameter getParameter(String name);
	
	public long getSouceSequenceCounter();
}
