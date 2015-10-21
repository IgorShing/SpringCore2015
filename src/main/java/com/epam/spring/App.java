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
	private ConsoleEventLogger consoleEventLogger;


	public App() {
	}

	public App(Client client, ConsoleEventLogger consoleEventLogger)
	{
		this.client = client;
		this.consoleEventLogger = consoleEventLogger;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ConsoleEventLogger getConsoleEventLogger() {
		return consoleEventLogger;
	}

	public void setConsoleEventLogger(ConsoleEventLogger consoleEventLogger) {
		this.consoleEventLogger = consoleEventLogger;
	}

	public static void main( String[] args )
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		App app = (App) ctx.getBean("app");
		app.logEvent((Event) ctx.getBean("event"));
	}

	private void logEvent(Event event)
	{
		consoleEventLogger.logEvent(event);
	}
}
