package io.Demo.loginController;

public class Token {
	
	public String token;
	
	@Override
	public String toString() {
		return token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Token(){
		
	}
	
	public Token(String token) {
		super();
		this.token = token;
	}
}
