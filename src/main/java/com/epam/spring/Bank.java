package com.epam.spring;

import java.util.Properties;

public class Bank {

	private String	   id;
	private String	   name;
	private Properties	bankAttributes;

	public Bank() {
	}

	public Bank(String id, String name, Properties bankAttributes) {
		this.id = id;
		this.name = name;
		this.bankAttributes = bankAttributes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getBankAttributes() {
		return bankAttributes;
	}

	public void setBankAttributes(Properties bankAttributes) {
		this.bankAttributes = bankAttributes;
	}

}
