package com.epam.spring;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private final static EventLogger	          DEFAULT_LOGGER	= new ConsoleEventLogger();
	private Client	                              client;
	private EventLogger	                          eventLogger;
	private Map<EventType, EventLogger>	          loggers;

	private static ConfigurableApplicationContext	ctx	         = new ClassPathXmlApplicationContext(
			"spring.xml");
	private static App	                          instance;

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
		instance = (App) ctx.getBean("instance");
		instance.testBank();

		instance.testUser();

		ctx.close();
	}

	private void testUser() {
		User user = (User) ctx.getBean("user");
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getGreeting());
	}

	private void testBank() {

		Bank bank = (Bank) ctx.getBean("bank");
		System.out.println(bank.getBankAttributes().get("country"));
		System.out.println(bank.getBankAttributes().get("city"));
		System.out.println(bank.getBankAttributes().get("street"));
		System.out.println(bank.getBankAttributes().get("staff"));
		System.out.println(bank.getBankAttributes().get("asset"));

	}

	private void testLoggers() {
		Event event = (Event) ctx.getBean("event");
		Event event2 = (Event) ctx.getBean("event");

		Client client = (Client) ctx.getBean("client");

		// Get loggers

		instance.logEvent(event2, EventType.ERROR);
		instance.logEvent(event2, EventType.INFO);
		instance.logEvent(event2, null);

	}

	public void logEvent(Event event, EventType eventType) {

		eventLogger = loggers.get(eventType);

		if (eventLogger == null) {
			eventLogger = DEFAULT_LOGGER;
		}
		eventLogger.logEvent(event, eventType);
	}
}
