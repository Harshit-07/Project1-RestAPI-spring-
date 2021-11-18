package io.Demo.loginController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pwd {
	
	@RequestMapping("/restapi/pwd")
	public String noAccess() {
		return "Error : Pass a token in the header for authorization\n";
	}
	
	@RequestMapping("/restapi/pwd/{userToken}")
	public String presentDir(@PathVariable String userToken,Token token) {
		String n = token.getToken();
		System.out.print(n);
//		if(userToken.equals(token)) 
//		{
//		String pwd = System.getProperty("user.dir");
//	    return "pwd :"+ pwd +"\n";
//		}
//		else {	
			return "Error : Token Invalid\n"; 
//		}
	}
	
}
