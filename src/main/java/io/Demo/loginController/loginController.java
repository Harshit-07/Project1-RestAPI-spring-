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
public class loginController{
	
	final String basePath="/home/user/";
	
	@Autowired
	private loginService loginservice;
	
	@RequestMapping(method=RequestMethod.POST,value="/restapi/login")
	public HashMap<Token, User> login(Token token,@RequestBody User user) {
			String username=user.getusername();
//			System.out.println(username);
			String cwd = basePath+username;
			user.homePath(cwd);
		 	UUID randomString = UUID.randomUUID();
		 	String rString =randomString.toString();
//		 	System.out.print(rString);
		 	user.updateToken(rString);
		 	
		 	token.setToken(user.updateToken(rString));
		 	String hashToken=token.getToken();
		 	System.out.println("Token : " + hashToken);
		    loginservice.addUser(token,user); 
		    return loginservice.getUser();
	}
}
