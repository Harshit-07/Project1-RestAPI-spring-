package io.Demo.loginController;

import java.util.List;

public class JsonLs2 {
	List<JsonLs> ls;

	public List<JsonLs> getLs() {
		return ls;
	}
	@Override
	public String toString() {
		return "JsonLs2 [ls=" + ls + "]";
	}
	public void setLs(List<JsonLs> str) {
		this.ls = str;
	}
	public JsonLs2() {
		
	}
	
}
