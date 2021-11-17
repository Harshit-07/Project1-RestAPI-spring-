package io.Demo.pwd;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pwd {

	@RequestMapping("/restapi/pwd")
	public String pwd() {
	String pwd = System.getProperty("user.dir");
    	return pwd;
	}
}
