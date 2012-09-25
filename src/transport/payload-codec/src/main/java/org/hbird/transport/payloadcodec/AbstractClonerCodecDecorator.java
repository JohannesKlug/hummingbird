package org.hbird.transport.payloadcodec;

import java.util.Map;

import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;

import com.rits.cloning.Cloner;

public class AbstractClonerCodecDecorator {

	protected Cloner cloner = new Cloner();

	protected final Map<String, Encoding> encodings;

	public AbstractClonerCodecDecorator(final Map<String, Encoding> encodings) {
		this.encodings = encodings;
	}

	protected Encoding findEncoding(final String qualifiedName) throws NoEncodingException {
		if (encodings.containsKey(qualifiedName)) {
			return encodings.get(qualifiedName);
		}
		else {
			throw new NoEncodingException(qualifiedName);
		}
	}

}
