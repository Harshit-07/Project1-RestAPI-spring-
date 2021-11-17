package io.Demo.loginController;

public class User {

	public String username;
	
	@Override
	public String toString() {
		return username;
	}
	
	public User() {
		
	}
	
	public User(String username) {
		super();
		this.username=username;
	}
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
}
