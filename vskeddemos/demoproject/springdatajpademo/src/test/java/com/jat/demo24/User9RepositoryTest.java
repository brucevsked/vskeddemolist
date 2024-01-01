package com.jat.demo24;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User9RepositoryTest extends BaseTestWithTransactional {
    private static final Logger log = LoggerFactory.getLogger(User9RepositoryTest.class);

    @Resource
    User9Repository user9Repository;
//    @Resource
//    Role9Repository role9Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void initData(){
        Set<Role9PO> roles=new HashSet<>();
        Set<Permission9PO> permissions=new HashSet<>();
        Set<Permission9PO> permissions2=new HashSet<>();
        Set<Permission9PO> permissions3=new HashSet<>();
        Permission9PO permission1=new Permission9PO(301L,"权限1");
        permissions.add(permission1);
        Permission9PO permission2=new Permission9PO(302L,"权限2");
        permissions.add(permission2);
        Role9PO role1=new Role9PO(201L,"role1",permissions);
        roles.add(role1);
        Permission9PO permission3=new Permission9PO(303L,"权限3");
        permissions2.add(permission3);
        Permission9PO permission4=new Permission9PO(304L,"权限4");
        permissions2.add(permission4);
        Role9PO role2=new Role9PO(202L,"role2",permissions2);
        roles.add(role2);

        Permission9PO permission5=new Permission9PO(305L,"权限5");
        permissions3.add(permission5);
        Permission9PO permission6=new Permission9PO(306L,"权限6");
        permissions3.add(permission6);
        Role9PO role3=new Role9PO(203L,"role3",permissions3);
        roles.add(role3);

        User9PO user=new User9PO(1L,"test1",roles);
        user9Repository.save(user);
        log.debug("finish");
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void unbingUserRole(){
        //只删除用户角色中间表数据，保存用户与角色数据
        User9PO user=user9Repository.getById(1L);
        Long roleId1=new Long(201);
        Long roleId2=new Long(202);
        Set<Role9PO> roles=user.getRoles();
        log.debug("当前角色:{}",roles);
        Iterator<Role9PO> it=roles.iterator();
        while(it.hasNext()){
            Role9PO po=it.next();
            if(po.getId().longValue()==roleId1 || po.getId().longValue()==roleId2){
                it.remove();
            }
        }
        log.debug("清理完后:{}",roles);
        user.setRoles(roles);
        user9Repository.save(user);
        log.debug("finish");
    }
}
