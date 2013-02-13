package net.eads.astrium.adco.brmsintegration.routes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import net.eads.astrium.adco.types.UserSymbol;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.drools.KnowledgeBase;
import org.drools.agent.KnowledgeAgent;
import org.drools.command.runtime.rule.FireAllRulesCommand;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Rule;
import org.drools.event.knowledgeagent.AfterChangeSetAppliedEvent;
import org.drools.event.knowledgeagent.AfterChangeSetProcessedEvent;
import org.drools.event.knowledgeagent.AfterResourceProcessedEvent;
import org.drools.event.knowledgeagent.BeforeChangeSetAppliedEvent;
import org.drools.event.knowledgeagent.BeforeChangeSetProcessedEvent;
import org.drools.event.knowledgeagent.BeforeResourceProcessedEvent;
import org.drools.event.knowledgeagent.KnowledgeAgentEventListener;
import org.drools.event.knowledgeagent.KnowledgeBaseUpdatedEvent;
import org.drools.event.knowledgeagent.ResourceCompilationFailedEvent;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class TelemetryToRulesEngine extends RouteBuilder implements
		WorkingMemoryEventListener, KnowledgeAgentEventListener {

    @Resource(name = "kbase1")
	protected KnowledgeBase kBase;

	@Resource(name = "ksession1")
	protected StatefulKnowledgeSession ksession;

	@Resource(name = "kagent")
	protected KnowledgeAgent kagent;

	@Produce(uri = "direct:processState")
	protected ProducerTemplate processState;

	@Override
	public void configure() throws Exception {

		printKBaseContent(kBase);
	    List <String> telemetryStreams = getTelemetryStreams(kBase);

		ksession.addEventListener( this);
		kagent.addEventListener(this);

		ResourceFactory.getResourceChangeNotifierService().start();
		ResourceFactory.getResourceChangeScannerService().start();

		from("direct:start")
		.routeId("directTestRoute")
		.to("drools:/ksession1?action=insertBody");


		from("activemq:topic:"+compileSubscriptionTopic(telemetryStreams))
		.routeId("telemetryListener")
		.unmarshal().xstream()
		.to("drools:/ksession1?action=insertBody")
		;

        /*
		from("timer:firerules?period=1000")
		.routeId("fireRulesEverySecond")
        .process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
                exchange.getOut().setBody(fireAllRulesCommand);
            }
        })
		.to("drools:/ksession1");
		*/

		from("direct:processState")
		.routeId("processStateChangesFromDrools")
		.to("mock:result");

	}

	public void objectInserted(ObjectInsertedEvent event) {
		Object obj = event.getObject();
		if (obj instanceof UserSymbol) {
			processState.sendBody(obj);
		}
	}


	public void knowledgeBaseUpdated(KnowledgeBaseUpdatedEvent event) {
		System.out.println("Knowledgebase updated " + event.getKnowledgeBase());
		try {
			getContext().stopRoute("telemetryListener");
			getContext().startRoute("telemetryListener");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private List<String> getTelemetryStreams(KnowledgeBase kb) {
		// here we can eventually parse input streams from the rules and
		// then adjust the JMS subscriptions
		return Arrays.asList("a","b");
	}


	private String compileSubscriptionTopic(List<String> telemetryStreams) {
		String str = "";

		for (String stream : telemetryStreams) {
			if (str.length() > 0)
				str += ",";
			str += "adco.telemetry."+stream;
		}
		return str;
	}

	private void printKBaseContent(KnowledgeBase kbase) {
		Collection<KnowledgePackage> packages = kbase.getKnowledgePackages();
		for (KnowledgePackage pack : packages) {
			System.out.println("Package found: " + pack.getName());
			Collection<Rule> rules = pack.getRules();
			for (Rule rule : rules) {
				System.out.println("   Rule found: " + rule.getName());
			}
		}
	}

	public void afterChangeSetApplied(AfterChangeSetAppliedEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void afterChangeSetProcessed(AfterChangeSetProcessedEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void afterResourceProcessed(AfterResourceProcessedEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeSetApplied(BeforeChangeSetAppliedEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeSetProcessed(BeforeChangeSetProcessedEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeResourceProcessed(BeforeResourceProcessedEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void resourceCompilationFailed(ResourceCompilationFailedEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void objectRetracted(ObjectRetractedEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void objectUpdated(ObjectUpdatedEvent arg0) {
		// TODO Auto-generated method stub
	}

    public KnowledgeBase getkBase() {
        return kBase;
    }

    public void setkBase(KnowledgeBase kBase) {
        this.kBase = kBase;
    }

    public StatefulKnowledgeSession getKsession() {
        return ksession;
    }

    public void setKsession(StatefulKnowledgeSession ksession) {
        this.ksession = ksession;
    }

    public KnowledgeAgent getKagent() {
        return kagent;
    }

    public void setKagent(KnowledgeAgent kagent) {
        this.kagent = kagent;
    }

}
