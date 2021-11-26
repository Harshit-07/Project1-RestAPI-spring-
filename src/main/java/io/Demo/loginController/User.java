package io.Demo.loginController;

public class User {
	
	static final String baseDir="/home/user";
	
	private String token;
	private String homeDir;
	private String pwd;
	private String username;
	
	public User(String username, String token, String homeDir, String pwd) {
		super();
		this.username = username;
		this.token = token;
		this.homeDir = homeDir;
		this.pwd = pwd;
	}
	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", token=" + token + ", homeDir=" + homeDir + ", pwd=" + pwd + "]";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getHomeDir() {
		return homeDir;
	}
	public void setHomeDir(String homeDir) {
		this.homeDir = homeDir;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
