package com.epam.spring;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

	private int	        maxCacheSize	= 5;
	private List<Event>	cache	     = new ArrayList<Event>();

	public CacheFileEventLogger(String filename) {
		super(filename);
	}

	@Override
	public void logEvent(Event event) {

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
			super.logEvent(event);
		}
	}

}
