package org.hbird.application.halcyon.tm;

import org.hbird.core.commons.tmtc.ParameterGroup;

public class ParameterListener {

	public ParameterListener() {
		System.out.println("Parameterlistener instantiated");
	}

	public final void parameterIn(final ParameterGroup parameterGroup) {
		System.out.println("Received " + parameterGroup.getName());
	}

}
