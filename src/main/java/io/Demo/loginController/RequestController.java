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
public class RequestController {
 
	Logger logger = LoggerFactory.getLogger(RequestService.class);
	
	final static String CWD = "cwd";
	final static String CD = "cd";
	final static String LOGIN = "login";
	final static String LS = "ls";
	final static String RESULT = "Logout successfull,your token is Unauthorized!";
	final static String USERS = "All users";
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/restapi/users")
	public HashMap<String,User> getMap() {
		logger.info(USERS+RequestService.getUser().toString());
		return RequestService.getUser();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/restapi/login")
	public JsonToken login(@RequestBody User user) throws IOException{
		JsonToken json = new JsonToken();
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
		String userBankDetailsPath = path + "/" + user.getUsername() + "BankDetails";
		File f5 = new File(userBankDetailsPath);
		f5.createNewFile();
		
		requestService.addUser(user);
		json.settoken(uuidToString);
		logger.info(LOGIN+json.toString());
		return json;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restapi/logout")
	public String logout(@RequestHeader(value="Authorization") String token) {
		logger.info("User logged out");
		requestService.deleteUser(token);
		return RESULT;
	}
	
	@RequestMapping("/restapi/cwd")
	public JsonCwd presentDir(@RequestHeader(value="Authorization") String token) {
		String pwd = requestService.getDir(token);
		JsonCwd json = new JsonCwd();
		json.setCwd(pwd);
		logger.info(CWD+json.toString());
		return json;
	}
		
	@RequestMapping("/restapi/ls")
	public JsonLs2 listAllFiles(@RequestHeader(value="Authorization") String token) {
		List<JsonLs> str = requestService.getLs(token);
		JsonLs2 json = new JsonLs2();
		json.setLs(str);
		logger.info(LS+json.toString());
	  	return json;
	}
	
	@RequestMapping("/restapi/cd/{dirName}")
	public JsonCd changeDirectory(@RequestHeader(value="Authorization") String token, @PathVariable String dirName) {
		JsonCd json= new JsonCd();
		String str = requestService.changeDir(dirName,token);
		json.setCd(str);
		logger.info(CD+json.toString());
		return json;
	}
	
}
