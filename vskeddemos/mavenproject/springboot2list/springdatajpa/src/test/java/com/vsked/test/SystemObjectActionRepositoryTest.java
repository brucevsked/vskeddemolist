package com.vsked.test;

import com.vsked.entity.SystemObjectAction;
import com.vsked.repository.SystemObjectActionRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SystemObjectActionRepositoryTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(SystemObjectActionRepositoryTest.class);

    @Autowired
    SystemObjectActionRepository systemObjectActionRepository;


    @Test
    public void saveTest(){
        log.info("good");
        SystemObjectAction systemObjectAction=new SystemObjectAction(6L,9L);
        systemObjectActionRepository.save(systemObjectAction);
    }

    @Test
    public void query(){
        log.info("cc");
        List<SystemObjectAction> systemObjectActionList=systemObjectActionRepository.findByObjectActionId(9L);
        log.info(systemObjectActionList.toString());
    }


}
