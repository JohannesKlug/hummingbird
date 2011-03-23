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
package org.hbird.exchange.type;

import java.util.Arrays;

import junit.framework.TestCase;

public class ComperatorTest extends TestCase  {

	
	public void testCompare() {
		
		/** Check simple Number's. */
		for (Number lhs : Arrays.asList(new Number[] {new Float(1), new Double(1), new Integer(1), new Long(1), new Short((short) 1), new Byte((byte) 1)})) {
			for (Number rhs : Arrays.asList(new Number[] {new Float(2), new Double(2), new Integer(2), new Long(2), new Short((short) 2), new Byte((byte) 2)})) {
				assertTrue(Comperator.compare(lhs, rhs) < 0);
			}			
		}
		
		for (Number lhs : Arrays.asList(new Number[] {new Float(2), new Double(2), new Integer(2), new Long(2), new Short((short) 2), new Byte((byte) 2)})) {
			for (Number rhs : Arrays.asList(new Number[] {new Float(2), new Double(2), new Integer(2), new Long(2), new Short((short) 2), new Byte((byte) 2)})) {
				assertTrue(Comperator.compare(lhs, rhs) == 0);
			}			
		}

		for (Number lhs : Arrays.asList(new Number[] {new Float(3), new Double(3), new Integer(3), new Long(3), new Short((short) 3), new Byte((byte) 3)})) {
			for (Number rhs : Arrays.asList(new Number[] {new Float(2), new Double(2), new Integer(2), new Long(2), new Short((short) 2), new Byte((byte) 2)})) {
				assertTrue(Comperator.compare(lhs, rhs) > 0);
			}			
		}

		/** Check parameters. */
		for (Parameter lhs : Arrays.asList(new Parameter[] {new Parameter("", "", new Float(1), ""), new Parameter("", "", new Double(1), ""), new Parameter("", "", new Integer(1), ""), new Parameter("", "", new Long(1), ""), new Parameter("", "", new Short((short) 1), ""), new Parameter("", "", new Byte((byte) 1), "")})) {
			for (Parameter rhs : Arrays.asList(new Parameter[] {new Parameter("", "", new Float(2), ""), new Parameter("", "", new Double(2), ""), new Parameter("", "", new Integer(2), ""), new Parameter("", "", new Long(2), ""), new Parameter("", "", new Short((short) 2), ""), new Parameter("", "", new Byte((byte) 2), "")})) {
				assertTrue(Comperator.compare(lhs, rhs) < 0);
			}			
		}
		
		for (Parameter lhs : Arrays.asList(new Parameter[] {new Parameter("", "", new Float(2), ""), new Parameter("", "", new Double(2), ""), new Parameter("", "", new Integer(2), ""), new Parameter("", "", new Long(2), ""), new Parameter("", "", new Short((short) 2), ""), new Parameter("", "", new Byte((byte) 2), "")})) {
			for (Parameter rhs : Arrays.asList(new Parameter[] {new Parameter("", "", new Float(2), ""), new Parameter("", "", new Double(2), ""), new Parameter("", "", new Integer(2), ""), new Parameter("", "", new Long(2), ""), new Parameter("", "", new Short((short) 2), ""), new Parameter("", "", new Byte((byte) 2), "")})) {
				assertTrue(Comperator.compare(lhs, rhs) == 0);
			}			
		}

		for (Parameter lhs : Arrays.asList(new Parameter[] {new Parameter("", "", new Float(3), ""), new Parameter("", "", new Double(3), ""), new Parameter("", "", new Integer(3), ""), new Parameter("", "", new Long(3), ""), new Parameter("", "", new Short((short) 3), ""), new Parameter("", "", new Byte((byte) 3), "")})) {
			for (Parameter rhs : Arrays.asList(new Parameter[] {new Parameter("", "", new Float(2), ""), new Parameter("", "", new Double(2), ""), new Parameter("", "", new Integer(2), ""), new Parameter("", "", new Long(2), ""), new Parameter("", "", new Short((short) 2), ""), new Parameter("", "", new Byte((byte) 2), "")})) {
				assertTrue(Comperator.compare(lhs, rhs) > 0);
			}			
		}

		D3Vector position1 = new D3Vector("", "", 1., 2., 3.); 
		D3Vector position2 = new D3Vector("", "", 3., 2., 1.);
		
		/** Check different combinations. */
		assertTrue(Comperator.compare(new String("test"), new String("test")) == 0);
		
		assertTrue(Comperator.compare(new Location("test", "", 3, position1), new Location("test", "", 3, position1)) == 0);
		
		assertTrue(Comperator.compare(new Location("test", "", 2, position1), new Location("test", "", 3, position2)) == -1);
		assertTrue(Comperator.compare(new Location("test", "", 2, position1), new Location("test2", "", 3, position1)) == -1);
		assertTrue(Comperator.compare(new Location("test2", "", 2, position1), new Location("test", "", 3, position1)) == -1);
		
		assertTrue(Comperator.compare(new Location("test", "", 2, position1), new Location("test", "", 2, position1)) == 0);
		assertTrue(Comperator.compare(new Location("test", "", 2, position1), new Location("test2", "", 2, position1)) == 1);
		assertTrue(Comperator.compare(new Location("test2", "", 2, position1), new Location("test", "", 2, position1)) == 1);
		
		assertTrue(Comperator.compare(new Location("test", "", 2, position1), new Location("test", "", 1, position1)) == 1);
		assertTrue(Comperator.compare(new Location("test", "", 2, position1), new Location("test2", "", 1, position1)) == 1);
		assertTrue(Comperator.compare(new Location("test2", "", 2, position1), new Location("test", "", 1, position1)) == 1);
	}
}
