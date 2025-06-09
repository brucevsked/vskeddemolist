package com.vsked.demo8;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Date;

public class DeskRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(DeskRepositoryTest.class);

    @Resource
    DeskRepository deskRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save1(){
        DeskPO deskPO=new DeskPO(1L,"刘备桌",new Date());
        deskRepository.save(deskPO);
        log.info("我们保存了:{}",deskPO);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save2(){
        DeskPO deskPO1=new DeskPO(2L,"张飞桌",new Date());
        deskRepository.save(deskPO1);
        log.info("我们保存了:{}",deskPO1);
        DeskPO deskPO2=new DeskPO(3L,"张飞桌",new Date());
        deskRepository.save(deskPO2);
        log.info("我们保存了:{}",deskPO2);
    }
}
