package io.Demo.loginController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
 
	Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	final static String CWD = "cwd";
	final static String CD = "cd";
	final static String LOGIN = "login";
	final static String PWD = "pwd";
	final static String RESULT = "Logout successfull,your token is Unauthorized!";
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/restapi/login")
	public HashMap<String,User> getMap() {
		logger.info("All users : "+LoginService.getUser().toString());
		return LoginService.getUser();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/restapi/login")
	public JsonConverter login(@RequestBody User user) throws IOException{
		JsonConverter json = new JsonConverter();
		UUID uuid = UUID.randomUUID();
		String uuidToString = uuid.toString();
		user.setToken(uuidToString);
		user.setHomeDir(User.baseDir);
		
		//creating Directories and files
		String path = User.baseDir + "/" + user.getUsername();
		user.setPwd(path);
		File f1 = new File(path);
		f1.mkdir();
		String userDetailsPath = path + "/" + user.getUsername() + "PersonalDetails";
		File f2 = new File(userDetailsPath);
		f2.mkdir();
		String userPhotosPath = path + "/" + user.getUsername() + "Photos";  
		File f3 = new File(userPhotosPath);
		f3.mkdir();
		String userPasswordPath = path + "/" + user.getUsername() + "Password";
		File f4 = new File(userPasswordPath);
		f4.createNewFile();
		String userBankDetailsPath = path + "/" + user.getUsername() + "BankDetails.txt";
		File f5 = new File(userBankDetailsPath);
		f5.createNewFile();
		
		loginService.addUser(user);
		json.setRequest(LOGIN);
		json.setResult(uuidToString);
		return json;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restapi/logout")
	public String logout(@RequestHeader(value="Authorization") String token) {
		logger.info("User logged out");
		loginService.deleteUser(token);
		return RESULT;
	}
	
	@RequestMapping("/restapi/cwd")
	public JsonConverter presentDir(@RequestHeader(value="Authorization") String token) {
		String pwd = loginService.getDir(token);
		JsonConverter json = new JsonConverter();
		json.setRequest(CWD);
		json.setResult(pwd);
		logger.info(json.toString());
		return json;
	}
		
	@RequestMapping("/restapi/ls")
	public JsonLs2 listAllFiles(@RequestHeader(value="Authorization") String token) {
		List<JsonLs> str = loginService.getLs(token);
		JsonLs2 json = new JsonLs2();
		json.setLs(str);
		logger.info(json.toString());
	  	return json;
	}
	
	@RequestMapping("/restapi/cd/{dirName}")
	public JsonConverter changeDirectory(@RequestHeader(value="Authorization") String token, @PathVariable String dirName) {
		JsonConverter json= new JsonConverter();
		String str = loginService.changeDir(dirName,token);
		json.setRequest(CD);
		json.setResult(str);
		return json;
	}
	
}
