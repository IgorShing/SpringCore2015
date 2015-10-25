package com.epam.spring;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {

	private String	filename;
	private File	file;
	private boolean	append	= true;

	public FileEventLogger(String filename) {
		this.filename = filename;
	}

	public void init() throws IOException {

		this.file = new File(filename);

		// If a file doesn't exists then create a new one
		if (!file.exists()) {
			file.createNewFile();
		}

		// Check if we can write in the file
		if (!file.canWrite()) {
			throw new IOException();
		}
	}

	public void logEvent(Event event, EventType eventType) {

		System.out.println("FileEventLogger");
		try {
			FileUtils.writeStringToFile(file, event.getMsg() + "\n", append);
		} catch (IOException e) {
			System.out.println("Unable to create a file.");
			e.printStackTrace();
		}
	}
}
