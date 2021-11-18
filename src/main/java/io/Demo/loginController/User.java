package io.Demo.loginController;

public class User {

	public String username;
	public String token;
	public String cwd;

	public String updateToken(String tokenx) {
		token=tokenx;
		return token; 
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

	public String homePath(String cwdx) {
		cwd=cwdx;
		return cwd;
	}
	
}
