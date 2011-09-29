package org.hbird.transport.protocols.sync;

import java.io.InputStream;

public interface FrameSynchroniser {
	
	public void readFromStream(InputStream is);

}
