package org.hbird.exchange.type;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.hbird.exchange.tasks.DummyTask;
import org.hbird.exchange.tasks.ITask;
import org.hbird.exchange.tasks.checks.RangeCheck;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.TestCase;


public class SerializationTest extends TestCase  {

	public void testSerialization() {
		BeanFactory factory = new FileSystemXmlApplicationContext ("classpath:SerializationTest.xml");
		List<Named> objects = (List<Named>) factory.getBean("objects");

		/** Iterate through definitions and create Messages. */
		List<Message> messages = new ArrayList<Message>();
		for (Named object : objects) {
			try {
				ByteArrayOutputStream fos = new ByteArrayOutputStream();
				ObjectOutputStream outStream = new ObjectOutputStream( fos );
				outStream.writeObject( object );
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
}
