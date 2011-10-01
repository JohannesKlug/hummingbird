package org.hbird.transport.xtce.utils;

import org.hbird.transport.generatedcode.xtce.IntegerParameterType;

public class XtceToJavaMapping {

	//FIXME UNIT TEST THIS
	public final static boolean doesIntRequireJavaLong(final IntegerParameterType type) {
		boolean longRequired = false;
		// If signed
		if (type.getSigned()) {
			if (type.getSizeInBits() > 32) {
				longRequired = true;
			}
		}
		// else if unsigned
		else {
			if (type.getSizeInBits() > 31) {
				longRequired = true;
			}
		}

		return longRequired;
	}
}
