package com.jat.repository;

import com.jat.repository.model.UserRolePO;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.util.List;

public class UserRoleRepositoryTest extends BaseTestWithTransactional {
    private static final Logger log = LoggerFactory.getLogger(UserRoleRepositoryTest.class);

    @Autowired
    UserRoleRepository userRoleRepository;

    @Test
    public void findByUserId(){
        int userId=1;
        List<UserRolePO> userRoles=userRoleRepository.findByUserId(userId);
        log.info("{}",userRoles);
    }
}
