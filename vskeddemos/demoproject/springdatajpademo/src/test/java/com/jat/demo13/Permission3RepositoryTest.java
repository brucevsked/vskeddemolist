package com.jat.demo13;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

public class Permission3RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(Permission3RepositoryTest.class);

    @Resource
    Permission3Repository permission3Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long id=200002L;
        String originalName="balanceQuery";
        String nickName="查询余额";
        String description="可以查看银行卡内余额吧";
        Permission3PO permission3PO=new Permission3PO(id,originalName,nickName,description);
        permission3Repository.save(permission3PO);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void saveWithRole(){
        Long roleId1=100002L;
        String roleName1="大将军";
        String roleDescription1="军队头头";
        Role3PO role1=new Role3PO(roleId1,roleName1,roleDescription1);

        Long roleId2=100003L;
        String roleName2="元帅";
        String roleDescription2="天蓬元帅也是元帅";
        Role3PO role2=new Role3PO(roleId2,roleName2,roleDescription2);

        Long roleId3=100004L;
        String roleName3="枪手";
        String roleDescription3="哥哥这里有把枪哟哟哟西,花姑娘大大的";
        Role3PO role3=new Role3PO(roleId3,roleName3,roleDescription3);

        List<Role3PO> roles3List=new LinkedList<>();
        roles3List.add(role1);
        roles3List.add(role2);
        roles3List.add(role3);

        Long id=200003L;
        String originalName="saveMoney";
        String nickName="存钱权限";
        String description="听说你很有钱呀小妹妹";
        Permission3PO permission3PO=new Permission3PO(id,originalName,nickName,description,roles3List);
        permission3Repository.save(permission3PO);
    }
    
}
