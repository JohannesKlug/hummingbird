package org.hbird.application.halcyon.commanding;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.eclipse.jetty.websocket.WebSocket;
import org.hbird.application.commanding.interfaces.processing.CommandVerificationSender.Stage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CmdVerificationStatusWebSocket implements WebSocket, CmdVerificationReceiver {
	private static final Logger LOG = LoggerFactory.getLogger(CmdVerificationStatusWebSocket.class);

	private Connection connection;

	private ServiceRegistration registration;

	@Override
	public void onOpen(final Connection connection) {
		this.connection = connection;

		// Register this as a LiveTmReceiver so the blueprint instantiated class used in the camel route can
		// route to this (a servlet managed class). Whiteboard pattern.
		final BundleContext bc = FrameworkUtil.getBundle(CmdVerificationStatusWebSocket.class).getBundleContext();
		registration = bc.registerService(CmdVerificationReceiver.class.getName(), this, null);
	}

	@Override
	public void onClose(final int closeCode, final String message) {
		registration.unregister();
		// TODO tie into OSGI event and log closure due to closeCode
	}

	@Override
	public void verifcationUpdate(Stage stage, long uid) {
		String jsonString = serialiseUpdateToJson(stage, uid);
		if (jsonString != null) {
			// TODO FINISH
		}
	}

	private static String serialiseUpdateToJson(Stage stage, long uid) {
		final ObjectMapper mapper = new ObjectMapper();
		final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		final SerializationConfig config = mapper.getSerializationConfig().withAnnotationIntrospector(jaxbIntrospector);
		mapper.setSerializationConfig(config);

		try {
			return mapper.writeValueAsString(new VerificationUpdate(stage, uid));
		}
		catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

};
