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
		/*		App app = new App();

		app.setClient(new Client("1", "John"));
		app.setConsoleEventLogger(new ConsoleEventLogger());

		app.logEvent("I am a user /"1/"");*/
		String fileLocation = "d:/Work/Programming/EclipseWorkspace/Workspace_JavaCore/SpringCorePr2015/SpringCore2015/src/main/java/com/epam/spring/com/epam/spring/core/spring.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		// ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:main/java/com/epam/spring/com/epam/spring/core/spring.xml");

		/*	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

		ctx.load("spring.xml");
		ctx.refresh();
		 */

		App app = (App) ctx.getBean("app");
		app.logEvent("I am a user \"1\"");
	}

	private void logEvent(String msg)
	{
		String message = msg.replaceAll(
				client.getId(), client.getFullName());
		consoleEventLogger.logEvent(message);
	}
}
