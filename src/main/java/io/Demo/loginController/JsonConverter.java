package io.Demo.loginController;

public class JsonConverter {
	String request;
	String result;
	public String getRequest() {
		return request;
	}
	@Override
	public String toString() {
		return "JsonConverter [request=" + request + ", result=" + result + "]";
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public JsonConverter() {
		
	}
	public JsonConverter(String request, String result) {
		super();
		this.request = request;
		this.result = result;
	}
}
