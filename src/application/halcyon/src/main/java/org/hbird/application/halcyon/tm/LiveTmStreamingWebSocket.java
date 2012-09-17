package org.hbird.application.halcyon.tm;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.eclipse.jetty.websocket.WebSocket;
import org.hbird.core.commons.tmtc.Parameter;
import org.osgi.framework.FrameworkUtil;

public class LiveTmStreamingWebSocket implements WebSocket {

	Connection connection;

	/**
	 * @param liveTmWebSocketServlet
	 */
	public LiveTmStreamingWebSocket() {
	}

	@Override
	public void onOpen(final Connection connection) {
		this.connection = connection;
		System.out.println("BID = " + FrameworkUtil.getBundle(ParameterListener.class).getBundleId());
	}

	@Override
	public void onClose(final int closeCode, final String message) {
	}

	// connection.sendMessage(serialiseParameterToJson(parameter));

	/**
	 * TODO The fact that this can be static means it's probably not the responsibility of the class and should be moved
	 * elsewhere.
	 * 
	 * @param parameter
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private static String serialiseParameterToJson(final Parameter<?> parameter) throws JsonGenerationException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper();
		final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		final SerializationConfig config = mapper.getSerializationConfig().withAnnotationIntrospector(jaxbIntrospector);
		mapper.setSerializationConfig(config);

		return mapper.writeValueAsString(parameter);
	}

}