//package org.hbird.integrationtests;
//
//import org.apache.camel.test.junit4.CamelTestSupport;
//
//
///*
// * 
// * Example taken from Camel documentation.
// * 
// * Not that this does NOT test hummingbird at all - it merely serves as en example.
// * 
// */
//
//
//public class ExampleSplitterTest extends CamelTestSupport {
//	
//	 @EndpointInject(uri = "mock:result")
//	 protected MockEndpoint resultEndpoint;
//	
//	 @Produce(uri = "direct:start")
//	 protected ProducerTemplate template;
//	
//	 protected static ExampleSplitterTest splitter;
//	
//	 @Test
//	 public void testSendMessageToSplitter() throws Exception {
//	
//	 resultEndpoint.expectedMessageCount(5);
//	
//	 template.sendBodyAndHeader("test", "foo", "bar");
//	
//	 resultEndpoint.assertIsSatisfied();
//	 for (Exchange exchange : resultEndpoint.getReceivedExchanges()) {
//	 System.out.println(exchange.getIn().getHeaders());
//	 System.out.println(exchange.getIn());
//	 }
//	 }
//	
//	
//	 @Override
//	 protected RouteBuilder createRouteBuilder() {
//	 return new RouteBuilder() {
//	 public void configure() {
//	
//	 splitter = new ExampleSplitterTest();
//	
//	 from("direct:start").split().method(splitter, "split").to(resultEndpoint);
//	 }
//	 };
//	 }
//	
//	 public static List<Message> split() {
//	 List<Message> messages = new ArrayList<Message>();
//	
//	 for (int i=0; i<5; i++) {
//	 Message message = new DefaultMessage();
//	 message.setBody("This is message # "+ i);
//	 message.setHeader("seq", i);
//	 messages.add(message);
//	 }
//	 return messages;
//	
//	 }
// }
