package org.hbird.application.halcyon.websocket;

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

@XmlRootElement
public class HbirdWebsocketMessage {

	private HbirdWebsocketMessageId id;

	private Object content;

	public HbirdWebsocketMessage() {
	}

	@JsonCreator
	public HbirdWebsocketMessage(HbirdWebsocketMessageId id, Object content) {
		this.id = id;
		this.content = content;
	}

	public final String serialiseUpdateToJson() {
		final ObjectMapper mapper = new ObjectMapper();
		final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		final SerializationConfig config = mapper.getSerializationConfig().withAnnotationIntrospector(jaxbIntrospector);

		mapper.setSerializationConfig(config);

		try {
			return mapper.writeValueAsString(this);
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

	public HbirdWebsocketMessageId getId() {
		return id;
	}

	public Object getContent() {
		return content;
	}

	public void setId(HbirdWebsocketMessageId id) {
		this.id = id;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
