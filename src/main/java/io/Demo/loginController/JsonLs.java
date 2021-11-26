package io.Demo.loginController;


public class JsonLs {
	String name;
	String type;
	@Override
	public String toString() {
		return "JsonLs [name=" + name + ", type=" + type + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
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
	public JsonLs(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

}
