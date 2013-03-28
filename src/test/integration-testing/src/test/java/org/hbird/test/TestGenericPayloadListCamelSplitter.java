package org.hbird.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ManagementStatisticsLevel;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class TestGenericPayloadListCamelSplitter extends CamelTestSupport {

	@Produce(uri = "direct:start")
	protected ProducerTemplate producerTemplate;

	GenericPayloadListProducer producer = new GenericPayloadListProducer();

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	long startTime;

	@Test
	public void test() throws InterruptedException {

		context.getManagementStrategy().setStatisticsLevel(ManagementStatisticsLevel.All);

		resultEndpoint.expectedMessageCount(GenericPayloadListProducer.LIST_SIZE);

		template.sendBody("direct:start", "go!");

		startTime = System.currentTimeMillis();
		resultEndpoint.assertIsSatisfied(2000);
		long runTime = System.currentTimeMillis() - startTime;

		System.out.println("Split " + resultEndpoint.getReceivedCounter() + " messages in " + runTime + " ms.");

	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("direct:start").bean(producer, "getGenericPayloadList").to("seda:messages");
				from("seda:messages").split().body().parallelProcessing().process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						// System.out.println(System.currentTimeMillis() - startTime);
					}
				}).to("mock:result");
			}
		};
	}

}
