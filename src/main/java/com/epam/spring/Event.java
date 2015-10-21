package com.epam.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

	private int id;
	private String msg;
	private Date date;
	private DateFormat dataFormat;

	private static Random random = new Random();

	public Event(Date date, DateFormat dataFormat, String msg) {
		id = random.nextInt();
		this.msg = msg;
		this.date = date;
		this.dataFormat = dataFormat;
	}

	public DateFormat getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(DateFormat dataFormat) {
		this.dataFormat = dataFormat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + dataFormat.format(date) + "]";
	}
}
