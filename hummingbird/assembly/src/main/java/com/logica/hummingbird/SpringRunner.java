package com.logica.hummingbird;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory = new FileSystemXmlApplicationContext("target/classes/SpringActiveMQTest.xml");

	}

}
