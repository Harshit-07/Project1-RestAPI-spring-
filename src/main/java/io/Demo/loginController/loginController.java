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
	
	@Autowired
	private loginService loginservice;
	
	@RequestMapping("/restapi/login")
	public HashMap<String, User> getUsers(){
		return loginservice.getUser();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restapi/login")
	public void login(@RequestBody User user) {
		 	UUID randomString = UUID.randomUUID();
		 	tempVar.str= randomString.toString();
		    System.out.println("random key generated :" +randomString);
		    loginservice.addUser(user); 
	}
	
}
