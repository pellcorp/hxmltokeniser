package com.pellcorp.xml.parser;

public class Attribute {
	private final String name;
	private final String value;
	
	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public Attribute(final String name, final String value) {
		this.name = name;
		this.value = value;
	}
}
