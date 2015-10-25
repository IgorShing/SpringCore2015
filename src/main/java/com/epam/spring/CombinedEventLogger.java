package com.epam.spring;

import java.util.Collection;
import java.util.Iterator;

public class CombinedEventLogger implements EventLogger {

	private Collection<EventLogger>	loggers;

	public CombinedEventLogger(Collection<EventLogger> loggers) {
		this.loggers = loggers;
	}

	public Collection<EventLogger> getLoggers() {
		return loggers;
	}

	public void setLoggers(Collection<EventLogger> loggers) {
		this.loggers = loggers;
	}

	public void logEvent(Event event, EventType eventType) {
		Iterator<EventLogger> iterator = loggers.iterator();
		while (iterator.hasNext()) {
			iterator.next().logEvent(event, eventType);
		}
	}
}
