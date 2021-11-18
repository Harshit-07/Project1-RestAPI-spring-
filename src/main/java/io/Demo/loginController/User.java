package io.Demo.loginController;

public class User {

	public String username;
	public String token;
	

	public String getToken(String str) {
		
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return username;
	}
	
	public User() {
		
	}
	
	public User(String username,String token) {
		super();
		this.username=username;
		this.token=token;
	}
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
}
