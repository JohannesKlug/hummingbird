package org.hbird.application.web.backend;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.Application;
import org.glassfish.jersey.server.ResourceConfig;

public class HelloRunner {

	   private static final URI BASE_URI = URI.create("http://localhost:8080/base/");
	    public static final String ROOT_PATH = "helloworld";

	    public static void main(String[] args) {
	        try {
	            System.out.println("\"Hello World\" Jersey Example App");

	            final ResourceConfig resourceConfig = ResourceConfig.builder().addClasses(Hello.class, Status.class).build();

	            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI,
	                    Application.builder(resourceConfig).build());

	            System.out.println(String.format("Application started.\nTry out %s%s\nHit enter to stop it...",
	                    BASE_URI, ROOT_PATH));
	            System.in.read();
	            server.stop();
	        } catch (IOException ex) {
	            Logger.getLogger(HelloRunner.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
}
