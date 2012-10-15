//package org.hbird.application.halcyon.providers;
//
//import javax.ws.rs.ext.ContextResolver;
//import javax.ws.rs.ext.Provider;
//import javax.xml.bind.JAXBContext;
//
//import com.sun.jersey.api.json.JSONConfiguration;
//import com.sun.jersey.api.json.JSONJAXBContext;
//
//@Provider
//public class JAXBContextResolver implements ContextResolver<JAXBContext> {
//
//	private final JAXBContext context;
//	private final Class[] types = { Contact.class, Address.class };
//
//	public JAXBContextResolver() throws Exception {
//		this.context = new JSONJAXBContext(JSONConfiguration.natural().build(), types);
//	}
//
//	@Override
//	public JAXBContext getContext(Class<?> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
// }
