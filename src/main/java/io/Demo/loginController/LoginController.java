package io.Demo.loginController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
 
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/restapi/login")
	public HashMap<String,User> getMap() {
		return LoginService.getUser();
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
//		System.out.println(user.getUsername());
		user.setPwd(path);
		File f1 = new File(path);
		f1.mkdir();
		String userDetailsPath = path + "/" + user.getUsername() + " PersonalDetails";
		File f2 = new File(userDetailsPath);
		f2.mkdir();
		String userPhotosPath = path + "/" + user.getUsername() + " Photos";  
		File f3 = new File(userPhotosPath);
		f3.mkdir();
		String userPasswordPath = path + "/" + user.getUsername() + "Password.txt";
		File f4 = new File(userPasswordPath);
		f4.createNewFile();
		String userBankDetailsPath = path + "/" + user.getUsername() + "BankDetails.txt";
		File f5 = new File(userBankDetailsPath);
		f5.createNewFile();
		
		loginService.addUser(user);
		json.setToken(uuidToString);
		return json;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restapi/logout")
	public String logout(@RequestHeader(value="Authorization") String token) {
		loginService.deleteUser(token);
		return "logout successfull,your token is unauthourized";
	}
	
	@RequestMapping("/restapi/cwd")
	public JsonCwd presentDir(@RequestHeader(value="Authorization") String token) {
		String pwd = loginService.getDir(token);
		JsonCwd json = new JsonCwd();
		json.setCwd(pwd);
		return json;
	}
		
	@RequestMapping("/restapi/ls")
	public JsonLs listAllFiles(@RequestHeader(value="Authorization") String token) {
		JsonLs json = new JsonLs();
		String str = loginService.getLs(token);
		json.setLs(str);
		return json;
	}
	@RequestMapping("/restapi/cd/{dirName}")
	public JsonCd changeDirectory(@RequestHeader(value="Authorization") String token, @PathVariable String dirName) {
		JsonCd json= new JsonCd();
		String str = loginService.changeDir(dirName,token);
		json.setCd(str);
		return json;
	}
	
}
