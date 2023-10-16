package com.vsked;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vsked.test.User;
import com.vsked.util.BaseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GsonTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	static Gson gson = new Gson();

	@Test
	public void objectToJson(){
		String s=gson.toJson(new User("smallvill",25));
		log.debug("{}",s);

	}

	@Test
	public void jsonToObject(){
		String s="{'userName':'smallvillc','userAge':26}";
		User u=gson.fromJson(s, User.class);
		log.debug("{},{}",u.getUserName(),u.getUserAge());
	}

	@Test
	public void listToJson(){
		List<User> userList=new ArrayList<User>();
		for(int i=0;i<10;i++)
			userList.add(new User("user"+i,20+i));

		String s=gson.toJson(userList);
		log.debug("{}",s);
	}

	@Test
	public void jsonToList(){
		String s="[{'userName':'user0','userAge':20},{'userName':'user1','userAge':21},{'userName':'user2','userAge':22},{'userName':'user3','userAge':23},{'userName':'user4','userAge':24},{'userName':'user5','userAge':25},{'userName':'user6','userAge':26},{'userName':'user7','userAge':27},{'userName':'user8','userAge':28},{'userName':'user9','userAge':29}]";
		List<User> userList=gson.fromJson(s, new TypeToken<List<User>>(){}.getType());
		for(int i=0;i<userList.size();i++){
			User u=userList.get(i);
			log.debug("{},{}",u.getUserName(),u.getUserAge());
		}
	}

	@Test
	public void mapToJson(){
		Map<String, Integer> m=new HashMap<String, Integer>();
		m.put("smallvillm1", 25);
		m.put("smallvillm2", 26);
		String s=gson.toJson(m);
		log.debug("{}",s);
	}

	@Test
	public void jsonToMap(){
		String s="{'smallvillm1':25,'smallvillm2':26}";
		Map<String, Integer> m=gson.fromJson(s, new TypeToken<Map<String, Integer>>(){}.getType());
		log.debug(m.get("smallvillm1")+"|"+m.get("smallvillm2"));
	}

	@Test
	public void mapToJsonWithNull(){
		Map<String, Object> myUser=new HashMap<String, Object>();
		myUser.put("userId", "18");
		myUser.put("userName", "vsked");
		myUser.put("userAge",null);
		myUser.put("userAddr","");

		String result=new BaseJson().mapToJson(myUser);
		log.debug("{}",result);
	}
	
}
