package io.Demo.loginController;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class loginService{
	
	HashMap<Token,User>user = new HashMap<>();
	
	public HashMap<Token,User> getUser(){
		    return user;
		}
	
	public void addUser(Token token,User userx){
		user.put(token,userx);
	}

}
