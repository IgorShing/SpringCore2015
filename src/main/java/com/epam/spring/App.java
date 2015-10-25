package com.epam.spring;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private final static EventLogger	DEFAULT_LOGGER	= new ConsoleEventLogger();
	private Client	                    client;
	private EventLogger	                eventLogger;
	private Map<EventType, EventLogger>	loggers;

	public App() {
	}

	public App(Client client, EventLogger eventLogger,
	        Map<EventType, EventLogger> loggers) {
		this.client = client;
		this.eventLogger = eventLogger;
		this.loggers = loggers;
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

	public Map<EventType, EventLogger> getLoggers() {
		return loggers;
	}

	public void setLoggers(Map<EventType, EventLogger> loggers) {
		this.loggers = loggers;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "spring.xml");

		App app = (App) ctx.getBean("app");
		Event event = (Event) ctx.getBean("event");
		Event event2 = (Event) ctx.getBean("event");

		Client client = (Client) ctx.getBean("client");

		// Get loggers

		app.logEvent(event2, EventType.ERROR);
		app.logEvent(event2, EventType.INFO);
		app.logEvent(event2, null);

		ctx.close();
	}

	public void logEvent(Event event, EventType eventType) {

		eventLogger = loggers.get(eventType);

		if (eventLogger == null) {
			eventLogger = DEFAULT_LOGGER;
		}
		eventLogger.logEvent(event, eventType);
	}
}
