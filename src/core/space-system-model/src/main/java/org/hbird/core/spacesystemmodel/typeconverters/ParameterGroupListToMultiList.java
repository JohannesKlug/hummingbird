package org.hbird.core.spacesystemmodel.typeconverters;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Converter;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;

@Converter
public class ParameterGroupListToMultiList {
	
	@Converter
	public static List<List<String>> convertPgListToMultimap(List<ParameterGroup> parameterGroups) {
		
		List<List<String>> multilist = new ArrayList<List<String>>();
		
		if (parameterGroups.isEmpty() == false) {
			List<String> headerLine = new ArrayList<String>();
			headerLine.add("Time Stamp");
			for (String parameterName : parameterGroups.get(0).getIntegerParameters().keySet()) {
				headerLine.add(parameterName);
			}
			
			multilist.add(headerLine);
			
			for (ParameterGroup pg : parameterGroups) {
				//Collection<Parameter<Integer>> integerParameters;
				List<String> bodyLine = new ArrayList<String>();
				bodyLine.add(Long.toString(pg.getTimeStamp()));
				for (Parameter<Integer> integerParameter : pg.getIntegerParameters().values()) {
					bodyLine.add(integerParameter.getValue().toString());
				}
				multilist.add(bodyLine);
			}
			
		}
		
		return multilist;
	}

}
