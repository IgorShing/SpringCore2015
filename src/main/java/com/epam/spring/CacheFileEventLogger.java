package com.epam.spring;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

	private int	        maxCacheSize;
	private List<Event>	cache	= new ArrayList<Event>();
	private EventType	eventType;

	public CacheFileEventLogger(String filename, int maxCacheSize) {
		super(filename);
		this.maxCacheSize = maxCacheSize;
	}

	@Override
	public void logEvent(Event event, EventType eventType) {

		this.eventType = eventType;
		cache.add(event);

		if (cache.size() == maxCacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	public void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}

	private void writeEventsFromCache() {
		for (Event event : cache) {
			super.logEvent(event, eventType);
		}
	}
}
