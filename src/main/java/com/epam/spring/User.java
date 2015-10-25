package com.epam.spring;

public class User {

	private String	id;
	private String	userName;
	private String	greeting;

	public User() {
	}

	public User(String id, String userName, String greeting) {
		super();
		this.id = id;
		this.userName = userName;
		this.greeting = greeting;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
