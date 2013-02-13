package net.eads.astrium.adco.brmsintegration.routes.test;

import com.thoughtworks.xstream.XStream;

import java.util.Arrays;

import net.eads.astrium.adco.types.Measurement;
import net.eads.astrium.adco.types.base.MeasurementImpl;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;


@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/test-context-5.3.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
// @MockEndpoints("log:*")
public class GuvnorRulesTest {

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	@Produce(uri = "direct:start")
	protected ProducerTemplate inEndpoint;

	@Produce(uri = "activemq://topic:adco.telemetry.a")
	protected ProducerTemplate activeMQInEndpoint;

	@Test
	public void testDirect() throws InterruptedException {
		// set mock expectations
		resultEndpoint.expectedMessageCount(5);


//		while (true) {
			Measurement m1 = new MeasurementImpl("CFA1_Fan_Speed",
					Arrays.asList("CFA1_Fan_Speed","2345677"), System.currentTimeMillis(), Double.valueOf(9142.0),
					"Double", "rpm");

			inEndpoint.sendBody(m1);

			Thread.sleep(2000);
			// assert mock
			resultEndpoint.assertIsSatisfied();

//		}

	}

	@Test
	public void testActiveMQ() throws InterruptedException {
		// set mock expectations
		resultEndpoint.expectedMessageCount(5);


//		while (true) {
		Measurement m1 = new MeasurementImpl("CFA1_Fan_Speed",
				Arrays.asList("CFA1_Fan_Speed","2345677"), System.currentTimeMillis(), Double.valueOf(9142.0),
				"Double", "rpm");
	        XStream xstream = new XStream();

	        String xml = xstream.toXML(m1);

			activeMQInEndpoint.sendBody(xml);

			Thread.sleep(5000);
			// assert mock
			resultEndpoint.assertIsSatisfied();

//		}

	}

}
