package com.vsked.demo15;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Optional;

public class User5RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User5RepositoryTest.class);

    @Resource
    User5Repository user5Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long certificateId=new Long(5001L);
        String certificateContent="just test okey";
        Certificate5PO certificate5PO=new Certificate5PO(certificateId,certificateContent);

        Long userId=new Long(10001L);
        String userName="老衲叫这名";
        User5PO user5PO=new User5PO(userId,userName,certificate5PO);
        user5Repository.save(user5PO);
        log.info("保存成功");

        User5PO user5PO1=new User5PO(new Long(10002L),"老王");
        user5Repository.save(user5PO1);

    }

    @Test
    public void findUserByCertificate(){
        Long certificateId=new Long(5001L);
        String certificateContent="just test okey";
        Certificate5PO certificate5PO=new Certificate5PO(certificateId,certificateContent);

        User5PO user5PO=new User5PO();
        user5PO.setCertificate(certificate5PO);
        Example<User5PO> user5POExample=Example.of(user5PO);
        Optional<User5PO> myPOO=user5Repository.findOne(user5POExample);
        if(myPOO.isPresent()){
            User5PO po=myPOO.get();
            log.info(po.toString());
        }


    }

    @Test
    public void findUserByCertificate2(){
        Long certificateId=new Long(5001L);
        Certificate5PO certificate5PO=new Certificate5PO();
        certificate5PO.setId(certificateId);

        User5PO user5PO=new User5PO();
        user5PO.setCertificate(certificate5PO);
        Example<User5PO> user5POExample=Example.of(user5PO);
        Optional<User5PO> myPOO=user5Repository.findOne(user5POExample);
        if(myPOO.isPresent()){
            User5PO po=myPOO.get();
            log.info(po.toString());
        }


    }


    @Test
    public void findUserByCertificateId(){
        Long certificateId=new Long(5001L);
        Certificate5PO certificate5PO=new Certificate5PO();
        certificate5PO.setId(certificateId);

        User5PO user5PO=new User5PO();
        user5PO.setCertificate(certificate5PO);
        Example<User5PO> user5POExample=Example.of(user5PO);
        Optional<User5PO> myPOO=user5Repository.findOne(user5POExample);
        if(myPOO.isPresent()){
            User5PO po=myPOO.get();
            log.info(po.toString());
        }


    }

}
