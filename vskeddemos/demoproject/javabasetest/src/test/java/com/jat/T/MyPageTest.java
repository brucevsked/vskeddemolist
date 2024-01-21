package com.jat.T;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class MyPageTest {

    private static final Logger log = LoggerFactory.getLogger(MyPageTest.class);

    @Test
    public void test1(){
        MyPage<String> myPage=new MyPage<>(1,10);
        List<String> dataList=new LinkedList<>();
        dataList.add("数据1");
        dataList.add("数据2");
        dataList.add("数据3");

        myPage.setData(dataList);

        log.info("{}",myPage);

    }
}
