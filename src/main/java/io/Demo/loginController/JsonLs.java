package io.Demo.loginController;

import java.io.File;

public class JsonLs {
	File name;
	String type;
	@Override
	public String toString() {
		return "JsonLs [name=" + name + ", type=" + type + "]";
	}
	public File getName() {
		return name;
	}
	public void setName(File name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public JsonLs() {
		
	}
	public JsonLs(File name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

}
