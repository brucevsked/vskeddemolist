package com.jat.service;

import com.jat.model1.Test1Jat;
import com.jat.test.JfinalTesgNgBaseTest;
import com.jfinal.plugin.activerecord.Db;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class Test1JatServiceTest extends JfinalTesgNgBaseTest {

    private static final Logger log = LoggerFactory.getLogger(Test1JatServiceTest.class);

    @Test
    public void list(){
        Test1Jat dao=new Test1Jat().dao();
        Test1Jat data=dao.findFirst("select * from test1_jat where id=?",1);
        log.info("{}",data);

    }

    @Test
    public void batchInsert(){
        List<Test1Jat> dataList=new LinkedList<>();
        for(int i=3;i<10;i++){
            dataList.add(new Test1Jat().set("name","myNameIs"+i).set("age",i+5));
        }
        int rs[]=Db.batchSave(dataList,dataList.size());
        log.info("{}",rs);

    }


}
