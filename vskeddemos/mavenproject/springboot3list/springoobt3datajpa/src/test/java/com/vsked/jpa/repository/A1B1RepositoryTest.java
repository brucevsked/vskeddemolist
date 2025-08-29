package com.vsked.jpa.repository;

import com.vsked.jpa.model.A1B1;
import com.vsked.jpa.model.A1B1Id;
import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import java.time.LocalDateTime;

public class A1B1RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(A1B1RepositoryTest.class);

    @Autowired
    private A1B1Repository a1B1Repository;

    @Rollback(value = false) //事务不回滚
    @Test
    public void updateIsDel() {
        A1B1Id a1B1Id = new A1B1Id(4L, 4L);
        A1B1 a1B1 = a1B1Repository.findById(a1B1Id).get();
        a1B1.setIsdel(true);
        a1B1.setCreatetime(LocalDateTime.now());
        a1B1.setDeltime(LocalDateTime.now());
        a1B1Repository.save(a1B1);
        log.info("a1B1:{}", a1B1);
    }
}
