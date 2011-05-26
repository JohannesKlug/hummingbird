/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel;

public interface ParameterObserver {
	public void updated(String field, int value, String shortDescription, String longDescription);

	public void updated(String field, String value, String shortDescription, String longDescription);

	public void updated(String field, double value, String shortDescription, String longDescription);
}
