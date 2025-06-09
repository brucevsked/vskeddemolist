package com.vsked.demo30;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class SequenceTestRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(SequenceTestRepositoryTest.class);

    @Resource
    SequenceTestRepository sequenceTestRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        SequenceTest po=new SequenceTest();
        po.setName("myGoodName");
        sequenceTestRepository.save(po);
        log.info("save ok");
    }
}
