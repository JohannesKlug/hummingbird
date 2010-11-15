/**
 * 
 */
package org.hbird.packetarchive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author doylemr
 *
 */
public class PacketArchiver {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config/packet-archiver-spring-context.xml");
	}
}
