package com.jat.demo13;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

public class Role3RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Role3RepositoryTest.class);

    @Resource
    Role3Repository role3Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save1Role(){
        Long id=100000L;
        String name="超级管理员";
        String description="上帝七街";
        Role3PO role3PO=new Role3PO(id,name,description);
        role3Repository.save(role3PO);
        log.info("保存了:{}",role3PO);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveRoleWithPermission(){

        Long permissionId1=200000L;
        String permissionOrginalName1="register";
        String permissionNickName1="注册";
        String permissionDescription1="欢迎来注册啦";
        Permission3PO permission1=new Permission3PO(permissionId1,permissionOrginalName1,permissionNickName1,permissionDescription1);

        Long permissionId2=200001L;
        String permissionOrginalName2="login";
        String permissionNickName2="登录";
        String permissionDescription2="进来吧客官";
        Permission3PO permission2=new Permission3PO(permissionId2,permissionOrginalName2,permissionNickName2,permissionDescription2);

        List<Permission3PO> permissions=new LinkedList<>();
        permissions.add(permission1);
        permissions.add(permission2);

        Long roleId1=100001L;
        String roleName1="普通管理员";
        String roleDescription1="土皇帝";
        Role3PO role1=new Role3PO(roleId1,roleName1,roleDescription1,permissions);
        role3Repository.save(role1);
        log.info("保存了:{}",role1);
    }
}
