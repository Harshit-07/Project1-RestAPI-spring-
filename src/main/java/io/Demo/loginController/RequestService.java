package io.Demo.loginController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class RequestService {
	
	final static String DIRECTORY="DIRECTORY";
	final static String FILE="FILE";
	final static String ERROR="Error : Directory does not exist!";
	
	public static HashMap<String,User> map= new HashMap<String,User>();
	
	public static HashMap<String,User> getUser() {	
		return map;
	}
	public void addUser(User user) {
		map.put(user.getToken(),user );
	}
	public void deleteUser(String token) {
		map.remove(token);
	}
	public String getDir(String token) {
		String pwd;
		pwd=map.get(token).getPwd().toString();
		return pwd;
	} 	
	public List<JsonLs> getLs(String token) {
		String ls=map.get(token).getPwd().toString();
		File dp = new File(ls);
		File arr[]=dp.listFiles();
		List<JsonLs> newLs = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			JsonLs json = new JsonLs();
			File element = arr[i];
			if(element.isDirectory()) {
				json.setName(element.getName().toString());
				json.setType(DIRECTORY);
			}
			else {
				json.setName(element.getName().toString());
				json.setType(FILE);
			}
			newLs.add(json);
		}
		return newLs;
	}
	public String changeDir(String dirName, String token) {
		String cwd=map.get(token).getPwd().toString();
		File directoryPath = new File(cwd+"/"+dirName);
		if(directoryPath.exists()) {
			User user=new User();
			user.setUsername(map.get(token).getUsername().toString());
			user.setToken(token);
			user.setHomeDir(User.baseDir.toString());
			user.setPwd(User.baseDir + "/" +map.get(token).getUsername().toString() + "/" +dirName);
			map.replace(token, user);
			return map.get(token).getPwd().toString();
		}
		else {
			return ERROR;
		}
	}
}
