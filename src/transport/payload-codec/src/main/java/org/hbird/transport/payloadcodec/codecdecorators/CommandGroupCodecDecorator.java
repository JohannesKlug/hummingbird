package org.hbird.transport.payloadcodec.codecdecorators;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.hbird.core.commons.tmtc.CommandGroup;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtcgroups.TmTcGroups;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.payloadcodec.AbstractClonerCodecDecorator;
import org.hbird.transport.payloadcodec.codecdecorators.number.IntegerCodecFactory;
import org.hbird.transport.payloadcodec.codecdecorators.number.LongCodecFactory;
import org.hbird.transport.payloadcodec.codecdecorators.string.StringCodecFactory;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;

public class CommandGroupCodecDecorator extends AbstractClonerCodecDecorator {

	public CommandGroupCodecDecorator(final Map<String, Encoding> encodings) {
		super(encodings);
	}

	public Map<String, CommandGroup> decorateParameterGroups(final Map<String, CommandGroup> commandGroups) throws NoEncodingException,
			UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException {
		// Create a new cloned Map with the existing parameters in. This list will be decorated and returned.
		Map<String, CommandGroup> codecAwareParameterGroups = cloner.deepClone(commandGroups);

		// the list contains all the parameters acquired from the space system model since it was created from it!
		for (CommandGroup pg : codecAwareParameterGroups.values()) {
			// Iterate over the parameter group integer parameters, decorating each one with codec functionality
			// and replacing the original Parameter in the new list.

			// First up, the Integer parameters..
			Map<String, Parameter<Integer>> integerParameters = pg.getIntegerParameters();
			if (integerParameters != null) {
				Iterator<Entry<String, Parameter<Integer>>> it = integerParameters.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Parameter<Integer>> entry = it.next();

					Encoding enc = findEncoding(entry.getValue().getQualifiedName());
					Parameter<Integer> codecAwareIntParameter = IntegerCodecFactory.decorateParameterWithCodec(entry.getValue(), enc);
					TmTcGroups.replaceParameterInGroup(pg, codecAwareIntParameter.getQualifiedName(), codecAwareIntParameter);
				}
			}

			// next, the Long parameters..
			Map<String, Parameter<Long>> longParameters = pg.getLongParameters();
			if (longParameters != null) {
				Iterator<Entry<String, Parameter<Long>>> it = longParameters.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Parameter<Long>> entry = it.next();

					Encoding enc = findEncoding(entry.getValue().getQualifiedName());
					Parameter<Long> codecAwareLongParameter = LongCodecFactory.decorateParameterWithCodec(entry.getValue(), enc);
					TmTcGroups.replaceParameterInGroup(pg, codecAwareLongParameter.getQualifiedName(), codecAwareLongParameter);
				}
			}

			// next, the string parameters..
			Map<String, Parameter<String>> stringParameters = pg.getStringParameters();
			if (stringParameters != null) {
				Iterator<Entry<String, Parameter<String>>> it = stringParameters.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Parameter<String>> entry = it.next();
					Encoding enc = findEncoding(entry.getValue().getQualifiedName());
					Parameter<String> codecAwareStringParameter = StringCodecFactory.decorateParameterWithCodec(entry.getValue(), enc);
					TmTcGroups.replaceParameterInGroup(pg, codecAwareStringParameter.getQualifiedName(), codecAwareStringParameter);
				}
			}

		}

		// FIXME BigDecimal, Float, Double, Binary

		return codecAwareParameterGroups;
	}

}
