package org.hbird.transport.protocols.ccsds;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFrameDecoder;
import org.junit.Test;

public class CcsdsFrameDispatcherTestWithCamel extends CamelTestSupport {

	@Produce(uri = "direct:start")
	protected ProducerTemplate template;

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	private CcsdsFrameDecoder ccsdsFrameDecoder = new CcsdsFrameDecoder(1115,
			false, false);

	@Test
	public void testHeaders() throws InterruptedException {
		template.sendBody(new byte[1115]);

		resultEndpoint.setExpectedMessageCount(1);
		resultEndpoint.assertIsSatisfied();

		Message message = resultEndpoint.getExchanges().get(0).getIn();
		assertIsInstanceOf(byte[].class, message.getBody());
		assertEquals(true,message.getHeader(CcsdsFrameDecoder.IS_NEXT_FRAME));
		assertEquals(0,message.getHeader(CcsdsFrameDecoder.SPACECRAFT_ID));
		assertEquals(0,message.getHeader(CcsdsFrameDecoder.VIRTUAL_CHANNEL_ID));
		

	}

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:start").bean(ccsdsFrameDecoder).to(resultEndpoint);
			}
		};
	}

}
