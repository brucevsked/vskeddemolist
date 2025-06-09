package com.vsked.demo31;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

public class SysUserRoleRepositoryTest extends BaseTestWithTransactional {
    private static final Logger log = LoggerFactory.getLogger(SysUserRoleRepositoryTest.class);
    @Autowired
    SysUserRepository sysUserRepository;
    @Autowired
    SysRoleRepository sysRoleRepository;

    @Autowired
    SysUserRoleRepository sysUserRoleRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        log.trace("save");
        SysUser user=new SysUser("admin");
        SysRole role=new SysRole("role1");
        user=sysUserRepository.save(user);
        role=sysRoleRepository.save(role);
        SysUserRole userRole=new SysUserRole(user,role);
        sysUserRoleRepository.save(userRole);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void deleteByUserId(){
        Integer userId=1;
        sysUserRoleRepository.deleteByUserId(userId);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void deleteByRoleId(){
        Integer roleId=2;
        sysUserRoleRepository.deleteByRoleId(roleId);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void deleteByUserIdAndRoleId(){
        Integer userId=3;
        Integer roleId=3;
        sysUserRoleRepository.deleteByUserIdAndRoleId(userId,roleId);
    }
}
