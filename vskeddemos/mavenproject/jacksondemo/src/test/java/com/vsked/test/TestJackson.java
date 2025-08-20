package com.vsked.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsked.bean.User;
import org.testng.annotations.Test;

public class TestJackson {

    private final Logger log = LogManager.getLogger(TestJackson.class);

    ObjectMapper jackson = new ObjectMapper();

    @Test
    public void objectToJson() throws Exception {
        String s = jackson.writeValueAsString(new User("smallVillage", 18));
        log.debug(s);
    }

    @Test
    public void jsonToObject() throws Exception {

        jackson.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        //String s="{\"userName\":\"smallVillage\",\"userAge\":26}";
        String s = "{'userName':'smallVillage','userAge':26}";
        User u = jackson.readValue(s, User.class);
        log.debug("{}|{}", u.getUserName(), u.getUserAge());
    }

    @Test
    public void listToJson() throws Exception {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            userList.add(new User("user" + i, 20 + i));

        String s = jackson.writeValueAsString(userList);
        log.debug(s);
    }

    @Test
    public void listToJson1() throws Exception {
        List<Map<String, Object>> dataList = new LinkedList<>();

        Map<String, Object> data;
        for (int i = 0; i < 10; i++) {
            data = new HashMap<>();
            data.put("name", "x" + i);
            data.put("seq", i);
            data.put("isAllRight", true);
            dataList.add(data);
        }
        String s = jackson.writeValueAsString(dataList);
        log.debug(s);
    }

    @Test
    public void jsonToList() throws Exception {
        String s = "[{\"userName\":\"user0\",\"userAge\":20},{\"userName\":\"user1\",\"userAge\":21},{\"userName\":\"user2\",\"userAge\":22},{\"userName\":\"user3\",\"userAge\":23},{\"userName\":\"user4\",\"userAge\":24},{\"userName\":\"user5\",\"userAge\":25},{\"userName\":\"user6\",\"userAge\":26},{\"userName\":\"user7\",\"userAge\":27},{\"userName\":\"user8\",\"userAge\":28},{\"userName\":\"user9\",\"userAge\":29}]";
        List<User> userList = jackson.readValue(s, new TypeReference<>() { });

//		List<User> userList=jackson.readValue(s, jackson.getTypeFactory().constructCollectionType(List.class, User.class));

        for (User u : userList) {
            log.debug("{}|{}", u.getUserName(), u.getUserAge());
        }

    }

    @Test
    public void mapToJson() throws Exception {

        Map<String, Integer> m = new HashMap<>();
        m.put("smallVillage1", 25);
        m.put("smallVillage2", 26);
        String s = jackson.writeValueAsString(m);
        log.debug(s);

    }

    @Test
    public void jsonToMap() throws Exception {
        String s = "{\"smallVillage1\":25,\"smallVillage2\":26}";

        Map<String, Integer> m = jackson.readValue(s, new TypeReference<>() { });

        log.debug("{}|{}", m.get("smallVillage1"), m.get("smallVillage2"));

    }

    @Test
    public void jsonNumToString() throws Exception {
        List<Integer> datas = new LinkedList<>();
        datas.add(1999);
        datas.add(2000);
        datas.add(2001);
        datas.add(2002);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS.mappedFeature(), true);
        String s = mapper.writeValueAsString(datas);
        log.debug(s);
    }

}
