package com.vsked.demo14;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Role4RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Role4RepositoryTest.class);

    @Resource
    Role4Repository role4Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        log.trace("save");
        Long roleId1=1400000003L;
        String roleName1="小组长";
        Role4PO role1=new Role4PO(roleId1,roleName1);
        role4Repository.save(role1);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveWithPermission(){
        log.trace("保存角色与权限");

        List<Permission4PO> permissions=new LinkedList<>();

        Long permissionId2=1300000001L;
        String permissionName2="登录";
        Permission4PO permission2=new Permission4PO(permissionId2,permissionName2);
        permissions.add(permission2);

        Long permissionId3=1300000002L;
        String permissionName3="查询余额";
        Permission4PO permission3=new Permission4PO(permissionId3,permissionName3);
        permissions.add(permission3);

        Long permissionId4=1300000003L;
        String permissionName4="修改密码";
        Permission4PO permission4=new Permission4PO(permissionId4,permissionName4);
        permissions.add(permission4);

        Long roleId1=1400000004L;
        String roleName1="将军";

        Role4PO role1=new Role4PO(roleId1,roleName1,permissions);

        role4Repository.save(role1);

    }

    @Test
    public void query(){
        log.trace("query");
        Long roleId1=1400000004L;
        Optional<Role4PO> poo=role4Repository.findById(roleId1);
        Role4PO po=poo.get();
        log.info("找到对象:{}",po);
    }
    
}
