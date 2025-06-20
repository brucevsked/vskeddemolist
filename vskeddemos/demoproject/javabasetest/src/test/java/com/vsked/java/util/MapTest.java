package com.vsked.java.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * HashMap是无序的（只是说不是你插入时的顺序）；
 * LinkedHashMap是有序的（按你插入的顺序）；
 * TreeMap 是按key排序的；
 */
public class MapTest {

    private static final Logger log = LoggerFactory.getLogger(MapTest.class);

    @Test
    public void getKeyByValue(){
        Map<String, String> map = new HashMap<>();
        map.put("A", "123");
        map.put("B", "456");
        map.put("C", "789");

        String targetValue = "456";

        String foundKey = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (targetValue.equals(entry.getValue())) {
                foundKey = entry.getKey();
                break;
            }
        }

        if (foundKey != null) {
            log.info("Found key: " + foundKey);
        } else {
            log.info("Value not found");
        }
    }

    @Test
    public void sortKey(){
        Map<String,String> dataMap=new HashMap<>();
        dataMap.put("recharge_number","ddd");
        dataMap.put("price","eee");
        dataMap.put("app_id","aaa");
        dataMap.put("timestamp","bbb");
        dataMap.put("order_no","ccc");


        Object[] keys = dataMap.keySet().toArray();
        Arrays.sort(keys);

        for(Object key:keys){
            String value=dataMap.get(key);
            log.info(key+"|"+value);
        }
    }

    @Test
    public void sortKeyTreeMap(){
        /**
         * TreeMap 是按key排序的
         */
        Map<String,String> dataMap=new TreeMap<>();
        dataMap.put("recharge_number","ddd");
        dataMap.put("price","eee");
        dataMap.put("app_id","aaa");
        dataMap.put("timestamp","bbb");
        dataMap.put("order_no","ccc");

        Iterator<String> it=dataMap.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            String value=dataMap.get(key);
            log.debug(key+"||"+value);
        }

    }

    @Test
    public void sortValue(){
        Map<String, Integer> goodsCodeMapPrice = new HashMap<>();
        goodsCodeMapPrice.put("goods4", 10);
        goodsCodeMapPrice.put("goods1", 3);
        goodsCodeMapPrice.put("goods2", 8);
        goodsCodeMapPrice.put("goods3", 4);

        // 将这个map转换成list以便排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(goodsCodeMapPrice.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            // 默认的是从小到大排序，
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 从大到小排序
                // return (o2.getValue() - o1.getValue());
                // 从小到大排序
                return (o1.getValue() - o2.getValue());
            }
        });

        // 输出排序后的结果
        for (Map.Entry<String, Integer> t : list) {
            log.debug(t.getKey() + ":" + t.getValue());
        }
    }

    @Test
    public void deleteByValueForEach(){
        Map<String,String> dataMap=new ConcurrentHashMap<>();
        dataMap.put("k1","v1");
        dataMap.put("k2","v2");
        dataMap.put("k3","v3");
        dataMap.put("k34","v4");

        log.info("{}",dataMap);

        String removeValue="v3";

        dataMap.forEach((key,value)->{
            if(removeValue.equals(value)){
                dataMap.remove(key);
            }
        });

        log.info("{}",dataMap);

    }

    @Test
    public void deleteByValueIterator(){
        Map<String,String> dataMap=new ConcurrentHashMap<>();
        dataMap.put("k1","v1");
        dataMap.put("k2","v2");
        dataMap.put("k3","v3");
        dataMap.put("k34","v4");

        log.info("{}",dataMap);

        String removeValue="v3";

        Iterator<Map.Entry<String, String>> iterator = dataMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (removeValue.equals(entry.getValue())) {
                // 安全删除
                iterator.remove();
            }
        }

        log.info("{}",dataMap);
    }

    @Test
    public void cleanAllData(){
        Map<String,String> dataMap=new ConcurrentHashMap<>();
        dataMap.put("k1","v1");
        dataMap.put("k2","v2");
        dataMap.put("k3","v3");
        dataMap.put("k34","v4");

        log.info("{}",dataMap);
        dataMap.clear();
        log.info("{}",dataMap);
    }

}
