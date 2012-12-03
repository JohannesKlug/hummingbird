package org.hbird.application.halcyon.tm;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.eclipse.jetty.websocket.WebSocket;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;

public class OsgiLiveTmStreamingWebSocket implements WebSocket, LiveTmReceiver {

	private Connection connection;
	private ServiceRegistration registration;

	/**
	 * @param liveTmWebSocketServlet
	 */
	public OsgiLiveTmStreamingWebSocket() {
	}

	@Override
	public void onOpen(final Connection connection) {
		this.connection = connection;

		// Register this as a LiveTmReceiver so the blueprint instantiated class used in the camel route can
		// route to this (a servlet managed classes). Whiteboard pattern!
		final BundleContext bc = FrameworkUtil.getBundle(LiveTmWhiteboardDistributer.class).getBundleContext();
		registration = bc.registerService(LiveTmReceiver.class.getName(), this, null);
	}

	@Override
	public void onClose(final int closeCode, final String message) {
		registration.unregister();
		// TODO tie into OSGI event and log closure due to closeCode
	}


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

	@Override
	public void acceptNewLiveParameterGroup(final ParameterGroup parameterGroup) {
		for (final Parameter<?> p : parameterGroup.getAllParametersAsList()) {
			try {
				connection.sendMessage(serialiseParameterToJson(p));
			}
			catch (final JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (final JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}