package com.epam.spring;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {

	private String filename;
	private File file;

	public FileEventLogger(String filename) {
		this.filename = filename;
	}

	public void init() throws IOException
	{
		this.file = new File(filename);
	}

	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.getMsg() +"\n", true);
		} catch (IOException e) {
			System.out.println("Unable to create a file.");
			e.printStackTrace();
		}
	}
}
