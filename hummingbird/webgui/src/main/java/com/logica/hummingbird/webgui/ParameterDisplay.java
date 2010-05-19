package com.logica.hummingbird.webgui;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Message;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

/**
 * Homepage
 */
public class ParameterDisplay extends WebPage {
	
	List<String> receivedParameters;

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public ParameterDisplay(final PageParameters parameters) {
    	
    	receivedParameters = new ArrayList<String>();

        // Add the simplest type of label
        add(new Label("message", "Parameters received so far:"));
        
        for (String parameter : receivedParameters) {
        	add(new Label(parameter));
        }
        
    }
    
    public void onMessage(Message message) {
		
		receivedParameters.add("Headers: " + message.getHeaders().toString() + "Body: " + message.getBody().toString());
		while (receivedParameters.size() > 10) {
			receivedParameters.remove(0);
		}
    }
}
