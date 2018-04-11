package com.vsked.test;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsked.bean.User;

public class TestJackson {
	
	private  final Logger log=LogManager.getLogger(TestJackson.class);
	
	ObjectMapper jackson = new ObjectMapper();
	Writer strWriter = new StringWriter();
	
	@Test
	public void objectToJson() throws Exception{
		String s=jackson.writeValueAsString(new User("smallvill", 18));
		log.debug(s);
		
	}
	
//	@Test
	public void jsonToObject() throws Exception{
		
		jackson.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

		//String s="{\"userName\":\"smallvillc\",\"userAge\":26}";
		String s="{'userName':'smallvillc','userAge':26}";
		User u=jackson.readValue(s, User.class);
		log.debug(u.getUserName()+"|"+u.getUserAge());
	}
	
//	@Test
	public void listToJson() throws Exception{
		List<User> userList=new ArrayList<User>();
		for(int i=0;i<10;i++)
			userList.add(new User("user"+i,20+i));
		
		String s=jackson.writeValueAsString(userList);
		log.debug(s);
	}
	
//	@Test
	public void jsonToList() throws Exception{
		String s="[{\"userName\":\"user0\",\"userAge\":20},{\"userName\":\"user1\",\"userAge\":21},{\"userName\":\"user2\",\"userAge\":22},{\"userName\":\"user3\",\"userAge\":23},{\"userName\":\"user4\",\"userAge\":24},{\"userName\":\"user5\",\"userAge\":25},{\"userName\":\"user6\",\"userAge\":26},{\"userName\":\"user7\",\"userAge\":27},{\"userName\":\"user8\",\"userAge\":28},{\"userName\":\"user9\",\"userAge\":29}]";
		List<User> userList=jackson.readValue(s, new TypeReference<List<User>>(){});
		
//		List<User> userList=jackson.readValue(s, jackson.getTypeFactory().constructCollectionType(List.class, User.class));
		
	    for(int i=0;i<userList.size();i++){
	    	User u=userList.get(i);
	    	log.debug(u.getUserName()+"|"+u.getUserAge());
	    }
	    
	}
	
//	@Test
	public void mapToJson() throws Exception{
		
		Map<String, Integer> m=new HashMap<String, Integer>();
		m.put("smallvillm1", 25);
		m.put("smallvillm2", 26);
		String s=jackson.writeValueAsString(m);
		log.debug(s);
		
	}
	
//	@Test
	public void jsonToMap() throws Exception{
		
		String s="{\"smallvillm1\":25,\"smallvillm2\":26}";
		
		Map<String, Integer> m=jackson.readValue(s, new TypeReference<Map<String, Integer>>(){});
		
		log.debug(m.get("smallvillm1")+"|"+m.get("smallvillm2"));	
		
	}

}
