package com.logica.hummingbird.packetarchive;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
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
import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.logica.hummingbird.packetarchive.Packet;
/**
 * @version $Revision: 785119 $
 */
public class PacketArchiveTest extends CamelTestSupport {

    @Test
    public void testInsert() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        
        
        
        mock.expectedMessageCount(1);

        Packet packet = new Packet();
        Date date = new Date();
        packet.setOnboardCreationTime(date);
        packet.setOngroundReceptionTime(date);
        packet.setPacketId(1000l);
        packet.setPacket(new byte[1000]);

      //  template.sendBody("ibatis:createPacketTable?statementType=Statement","");
        template.sendBody("ibatis:ibatorgenerated_insert?statementType=Insert", packet);
        template.sendBody("direct:start", packet);

        assertMockEndpointsSatisfied();

        // there should be 3 rows now
        Integer rows = template.requestBody("ibatis:ibatorgenerated_countByExample?statementType=QueryForObject", null, Integer.class);
        assertEquals("There should be 3 rows", 3, rows.intValue());
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
        	
        	
//    		<route>
//			<from uri="activemq:topic:rawframe" />
//			<to uri="bean:marshaller" />
//			<choice>
//	            <when>
//	                <xpath>$type = 'frame'</xpath>
//	                <to uri="activemq:topic:frame?messageConverter=com.logica.hummingbird.marshaller.Converter"/>
//	            </when>
//	            <when>
//	                <xpath>$type = 'packet'</xpath>
//	                <to uri="activemq:topic:packet?messageConverter=com.logica.hummingbird.marshaller.Converter"/>
//	            </when>
//	            <otherwise>
//	                <xpath>$type = 'parameter'</xpath>
//	                <to uri="activemq:topic:parameter?messageConverter=com.logica.hummingbird.marshaller.Converter"/>
//	            </otherwise>
//	        </choice>
//		</route>
        	
        	
            @Override
            public void configure() throws Exception {
            	
                from("direct:start")
                //.to("ibatorgenerated_insert")
                    .to("mock:result");
            }
        };
    }

}
