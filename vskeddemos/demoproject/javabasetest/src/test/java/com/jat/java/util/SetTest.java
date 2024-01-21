package com.jat.java.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 有些set是有序的，有些set是无序列的
 */
public class SetTest {

    private static final Logger log = LoggerFactory.getLogger(SetTest.class);

    @Test
    public void hashSetTest(){
        Set<Integer> numberSet=new HashSet<>();

        numberSet.add(new Integer(8));
        numberSet.add(new Integer(7));
        numberSet.add(new Integer(8));
        numberSet.add(new Integer(7));
        numberSet.add(new Integer(8));
        numberSet.add(new Integer(6));
        numberSet.add(new Integer(6));
        numberSet.add(new Integer(1));
        numberSet.add(new Integer(1));

        log.info("无序:{}",numberSet);
        //无序:[1, 6, 7, 8]

        Set<String> dataSet=new HashSet<>();
        dataSet.add("test8");
        dataSet.add("test7");
        dataSet.add("test8");
        dataSet.add("test7");
        dataSet.add("test8");
        dataSet.add("test6");
        dataSet.add("test6");
        dataSet.add("test1");
        dataSet.add("test1");

        log.info("无序:{}",dataSet);
        //无序:[test8, test6, test7, test1]
    }

    @Test
    public void linkedHashSet(){
        //保证元素添加的顺序
        Set<String> dataSet=new LinkedHashSet<>();
        dataSet.add("test8");
        dataSet.add("test7");
        dataSet.add("test8");
        dataSet.add("test7");
        dataSet.add("test8");
        dataSet.add("test6");
        dataSet.add("test6");
        dataSet.add("test1");
        dataSet.add("test1");

        log.info("按添加顺序:{}",dataSet);
        //按添加顺序:[test8, test7, test6, test1]
    }

    @Test
    public void treeSet(){
        //保证元素自然顺序（会对元素按顺序进行排列）
        Set<String> dataSet=new TreeSet<>();
        dataSet.add("test8");
        dataSet.add("test7");
        dataSet.add("test8");
        dataSet.add("test7");
        dataSet.add("test8");
        dataSet.add("test6");
        dataSet.add("test6");
        dataSet.add("test1");
        dataSet.add("test1");

        log.info("重新排列顺序:{}",dataSet);
        //重新排列顺序:[test1, test6, test7, test8]
    }



}
