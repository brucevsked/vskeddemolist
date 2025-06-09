package com.vsked.demo5;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class PersonRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(PersonRepositoryTest.class);

    @Resource
    PersonRepository personRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){
        log.trace(" start test create");
        String idCardEntityId="370181198802018888";
        String idCardEntityPersonName="老王";
        String idCardEntityBirthday="1988-06-06";
        byte idCardEntitySex=1;
        IDCardEntity idCardEntity=new IDCardEntity(idCardEntityId,idCardEntityPersonName,idCardEntityBirthday,idCardEntitySex);
        log.info("当前保存前的实体是:{}",idCardEntity);

        long personId=9L;
        String personName=idCardEntityPersonName;

        PersonEntity personEntity=new PersonEntity(personId,personName,idCardEntity);
        log.info("当前保存前的实体是:{}",personEntity);
        PersonEntity personEntitySaved=personRepository.save(personEntity);//可以打断点看日志
        log.info("当前保存后的实体是:{}",personEntitySaved);

    }


}
