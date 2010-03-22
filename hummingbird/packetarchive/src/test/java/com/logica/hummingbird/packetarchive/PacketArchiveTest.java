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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.BeforeClass;
import org.junit.Test;

import com.logica.hummingbird.packetarchive.Packet;
/**
 * @version $Revision: 785119 $
 */
public class PacketArchiveTest extends CamelTestSupport {
	
	@BeforeClass
	public void startSpringContext() {
		PacketArchiver app = new PacketArchiver();
	}

    @Test
    public void testInsert() throws Exception {
        
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		
		org.h2.tools.RunScript.execute(conn, new InputStreamReader(new FileInputStream("src/test/resources/h2database.sql")));

    	
    	
    	MockEndpoint mock = getMockEndpoint("mock:result");
        
        
        
        mock.expectedMessageCount(3);

        Packet packet = new Packet();
        Date date = new Date();
        packet.setOnboardCreationTime(date);
        packet.setOngroundReceptionTime(date);
        packet.setPacketId(1000l);
        packet.setPacket(new byte[1000]);

        //template.sendBody("ibatis:dropAndCreatePacketTable?statementType=QueryForObject", "");
        //template.sendBody("ibatis:ibatorgenerated_insert?statementType=Insert", packet);

        
        template.sendBody("direct:start", packet);
        
//        Statement select = conn.createStatement();
//        ResultSet result = select
//            .executeQuery("SELECT * FROM packet");
//        
//        System.out.println(result);

        Thread.sleep(100);
        packet.setOnboardCreationTime(new Date());
        packet.setOngroundReceptionTime(new Date());
        
       template.sendBody("direct:start", packet);

        Thread.sleep(100);
        packet.setOnboardCreationTime(new Date());
        packet.setOngroundReceptionTime(new Date());
        
        template.sendBody("direct:start", packet);


        assertMockEndpointsSatisfied();

        
        
        // there should be 3 rows now
        Integer rows = template.requestBody("ibatis:ibatorgenerated_countByExample?statementType=QueryForObject", null, Integer.class);
        assertEquals("There should be 3 rows", 3, rows.intValue());
        
        conn.close();
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
                .to("ibatis:ibatorgenerated_insert?statementType=Insert")
                    .to("mock:result");
            }
        };
    }

}
