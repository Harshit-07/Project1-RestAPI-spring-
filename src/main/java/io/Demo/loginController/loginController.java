package io.Demo.loginController;

import java.util.List;
import java.util.Random;

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
	public void getUsers(){
		loginservice.getUser();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restapi/login")
	public void login(@RequestBody User user) {
		 	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    StringBuilder sb = new StringBuilder();
		    Random random = new Random();
		    int length = 7;
		    for(int i = 0; i < length; i++) {
		      int index = random.nextInt(alphabet.length());
		      char randomChar = alphabet.charAt(index);
		      sb.append(randomChar);
		    }
		    String randomString = sb.toString();
		    tempVar.str = randomString;
		    System.out.println("random key generated :" +tempVar.str);
		    loginservice.addUser(user);
	}
	
}
