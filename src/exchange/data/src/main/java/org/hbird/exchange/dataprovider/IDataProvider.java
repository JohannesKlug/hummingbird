/**
 * Licensed to the Hummingbird Foundation (HF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The HF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hbird.exchange.dataprovider;

import org.hbird.exchange.type.Command;
import org.hbird.exchange.type.Parameter;

/**
 * The IDataProvider interface defines methods for accessing Data.
 *
 */
public interface IDataProvider {

	/** Method to retrieve a single parameter based on a SQL92 selector string. The selection
	 *  may return zero or more results. The provider will return the first result. In the case
	 *  where the selection will return multiple results, the requester must ensure to include a
	 *  sort in the selector, so that the desired entry is returned first.
	 *  
	 *  @param selector A SQL92 formatted selector string, defining the data to be returned. 
	 *  @return Parameter The result of the selection. If the selector maps to multiple results, then
	 *  only the first result will be returned.*/
	public Parameter getParameter(String selector);

	public Command getCommand(String name);
}
