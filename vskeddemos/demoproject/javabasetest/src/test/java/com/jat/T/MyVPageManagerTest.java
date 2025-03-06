package com.jat.T;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class MyVPageManagerTest {

    private static final Logger log = LoggerFactory.getLogger(MyVPageManagerTest.class);

    @Test
    public void test1(){
        MyPageManager myPageManager=new MyPageManager();
        MyPage<String> myPage=myPageManager.create(1,20);
        List<String> dataList=new LinkedList<>();
        dataList.add("数据1");
        dataList.add("数据2");
        dataList.add("数据3");

        myPage.setData(dataList);

        log.info("{}",myPage);
    }

}
