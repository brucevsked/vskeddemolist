package com.jat.repository;

import com.jat.repository.model.RoleResourcePO;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class RoleResourceRepositoryTest extends BaseTestWithTransactional {
    private static final Logger log = LoggerFactory.getLogger(RoleResourceRepositoryTest.class);

    @Autowired
    RoleResourceRepository roleResourceRepository;

    @Test
    public void findByRoleIdIn(){
        List<Integer> roleIds=new LinkedList<>();
        roleIds.add(3);
        roleIds.add(8);

        List<RoleResourcePO> resources=roleResourceRepository.findByRoleIdInOrderByResourceSequenceAsc(roleIds);
        log.debug("{}",resources);

        for(RoleResourcePO rr:resources){
            log.debug("{}",rr.getResource());
        }
    }

    @Test
    public void findByRoleId(){
        Integer roleId=8;

        List<RoleResourcePO> resources=roleResourceRepository.findByRoleId(roleId);
        log.debug("{}",resources);
    }

    @Test
    public void deleteByRoleId(){
        Integer roleId=8;
        roleResourceRepository.deleteByRoleId(roleId);
    }
}
