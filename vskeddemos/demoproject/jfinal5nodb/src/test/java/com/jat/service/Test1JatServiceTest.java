package com.jat.service;

import com.jat.model1.Test1Jat;
import com.jat.test.JfinalTesgNgBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Test1JatServiceTest extends JfinalTesgNgBaseTest {

    private static final Logger log = LoggerFactory.getLogger(Test1JatServiceTest.class);

    @Test
    public void list(){
        Test1Jat dao=new Test1Jat().dao();
        Test1Jat data=dao.findFirst("select * from test1_jat where id=?",3);
        log.info("{}",data);

    }
}
