package com.epam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
	private Client client;
	private EventLogger eventLogger;

	public App() {
	}

	public App(Client client, EventLogger eventLogger)
	{
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

	public static void main( String[] args )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		App app = (App) ctx.getBean("app");
		Event event = (Event) ctx.getBean("event");

		event.setMsg("Start application");
		app.logEvent(event);
		event.setMsg("End application");
		app.logEvent(event);
	}

	private void logEvent(Event event)
	{
		eventLogger.logEvent(event);
	}
}
