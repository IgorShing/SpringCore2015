package com.epam.spring.com.epam.spring.core;

/**
 * Hello world!
 *
 */
public class App
{
	private Client client;
	private ConsoleEventLogger consoleEventLogger;

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
		App app = new App();

		app.setClient(new Client("1", "John"));
		app.setConsoleEventLogger(new ConsoleEventLogger());

		app.logEvent("I am a user \"1\"");

	}

	private void logEvent(String msg)
	{
		String message = msg.replaceAll(
				client.getId(), client.getFullName());
		consoleEventLogger.logEvent(message);
	}


}
