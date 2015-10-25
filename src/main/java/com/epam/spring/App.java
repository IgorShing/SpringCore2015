package com.epam.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private Client	    client;
	private EventLogger	eventLogger;

	public App() {
	}

	public App(Client client, EventLogger eventLogger) {
		this.client = client;
		this.eventLogger = eventLogger;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EventLogger getEventLogger() {
		return eventLogger;
	}

	public void setEventLogger(EventLogger eventLogger) {
		this.eventLogger = eventLogger;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "spring.xml");

		App app = (App) ctx.getBean("app");
		Event event = (Event) ctx.getBean("event");

		Client client = (Client) ctx.getBean("client");

		event.setMsg("Start application");

		Event event2 = (Event) ctx.getBean("event");
		event2.setMsg(client.toString());
		app.logEvent(event2);

		event.setMsg("End application");
		app.logEvent(event);

		ctx.close();
	}

	private void logEvent(Event event) {
		eventLogger.logEvent(event);
	}
}
