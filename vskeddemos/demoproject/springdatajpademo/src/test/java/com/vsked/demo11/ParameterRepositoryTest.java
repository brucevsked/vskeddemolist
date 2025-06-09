package com.vsked.demo11;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class ParameterRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(ParameterRepositoryTest.class);

    @Resource
    ParameterRepository parameterRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long id=1L;
        Integer sequence=1;
        String type="Long";
        String name="bankUserCard";
        ParameterPO po=new ParameterPO(id,sequence,type,name);
        parameterRepository.save(po);
        log.info("保存了:{}",po);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void getById(){
        Long id=1L;
        ParameterPO po=parameterRepository.getById(id);
        log.info("找到了:{}",po);
    }


}
