package org.hbird.transport.protocols.sync;

import java.io.InputStream;

public interface FrameSynchroniser {

	void readFromStream(InputStream is);

}
