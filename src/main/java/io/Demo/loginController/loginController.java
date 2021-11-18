package io.Demo.loginController;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
	
	final String basePath="/home/user";
	
	@Autowired
	private loginService loginservice;
	
	@RequestMapping("/restapi/login")
	public HashMap<String, User> getUsers(){
		return loginservice.getUser();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restapi/login")
	public void login(@RequestBody User user) {
			String username=user.getusername();
			String cwd = username+basePath;
		 	UUID randomString = UUID.randomUUID();
		 	String rString =randomString.toString();
		 	System.out.println("Token :" +randomString);
		    loginservice.addUser(user); 
	}
}
