package org.hbird.application.halcyon.tm;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OsgiLiveTmStreamingWebSocket implements OnTextMessage, LiveTmReceiver {
	private static final Logger LOG = LoggerFactory.getLogger(OsgiLiveTmStreamingWebSocket.class);

	private Connection connection;

	private ServiceRegistration registration;

	private boolean filtered = false;

	private final Set<String> parametersActive = new HashSet<String>();

	/**
	 * 
	 */
	public OsgiLiveTmStreamingWebSocket() {
	}

	@Override
	public void onOpen(final Connection connection) {
		this.connection = connection;

		// Register this as a LiveTmReceiver so the blueprint instantiated class used in the camel route can
		// route to this (a servlet managed class). Whiteboard pattern.
		final BundleContext bc = FrameworkUtil.getBundle(LiveTmWhiteboardDistributer.class).getBundleContext();
		registration = bc.registerService(LiveTmReceiver.class.getName(), this, null);
	}

	@Override
	public void onClose(final int closeCode, final String message) {
		registration.unregister();
		// TODO tie into OSGI event and log closure due to closeCode
	}

	@Override
	public void onMessage(String data) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Adding " + data + " to live filtering.");
		}
		// FIXME Not very defensive. Very brittle.
		parametersActive.add(data);
		filtered = true;
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
		if (parameterGroup.getAllParameters() != null) {
			for (final Parameter<?> p : parameterGroup.getAllParametersAsList()) {
				if (filtered) {
					if (!parametersActive.contains(p.getQualifiedName())) {
						continue;
					}
				}
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
		else {
			LOG.warn("Parameters in Parameter group: " + parameterGroup.getQualifiedName() + " are null");
		}
	}
}
