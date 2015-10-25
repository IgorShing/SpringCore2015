package com.epam.spring;

public class ConsoleEventLogger implements EventLogger {

	public void logEvent(Event event, EventType eventType) {
		System.out.println("ConsoleEventLogger");

		System.out.println(event.toString());
	}
}
