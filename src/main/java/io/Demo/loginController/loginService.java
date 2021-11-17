package io.Demo.loginController;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class loginService {
	
	HashMap<String,User>user = new HashMap<>();
	
	public HashMap<String, User> getUser(){
		    return user;
		}
	
	public void addUser(User userx){
		user.put(tempVar.str,userx);
	}
}
