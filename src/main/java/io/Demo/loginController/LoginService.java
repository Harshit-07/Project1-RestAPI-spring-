package io.Demo.loginController;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	String pwd;
	private static HashMap<String,User> map= new HashMap<String,User>();
//	private List<JsonLs> list = new ArrayList<>();  
	public static HashMap<String,User> getUser() {	
		return map;
	}

	public void addUser(User user) {
		map.put(user.getToken(),user );
		System.out.println(map);
	}
	public void deleteUser(String token) {
		map.remove(token);
		System.out.println(map);
	}
	public String getDir(String token) {
		pwd=map.get(token).getPwd().toString();
//		System.out.println(str);
		return pwd;
	} 
	public String getLs(String token) {	
		String ls=map.get(token).getPwd();
		File dp = new File(ls);
		String arr[]=dp.list();
		return (Arrays.toString(arr));
	}
	
	public String changeDir(String dirName, String token) {
		User user=new User();
		user.setUsername(map.get(token).getUsername().toString());
		user.setToken(token);
		user.setHomeDir(User.baseDir.toString());
		user.setPwd(User.baseDir + "/" +map.get(token).getUsername().toString() + "/" +dirName);
		map.replace(token, user);
		return map.get(token).getPwd().toString();		
	}


}
