package com.jat.demo22;


import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class User7RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User7RepositoryTest.class);

    @Resource
    User7Repository user7Repository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long certificateId=new Long(5001L);
        String certificateContent="just test okey";
        Certificate7PO cpo=new Certificate7PO(certificateId,certificateContent);

        Set<Certificate7PO> cpos=new HashSet<>();
        cpos.add(cpo);

        Long userId=new Long(10001L);
        String userName="老衲叫这名";
        User7PO User6PO=new User7PO(userId,userName,cpos);
        user7Repository.save(User6PO);
        log.info("保存成功");

        User7PO User6PO1=new User7PO(new Long(10002L),"老王");
        user7Repository.save(User6PO1);

    }

    @Test
    public void findUserByCertificate11(){
        Long certificateId=new Long(5001L);
        Optional<User7PO> userOptional=user7Repository.findOneByCertificateId(certificateId);
        if(userOptional.isPresent()){
            User7PO user7PO=userOptional.get();
            log.debug("{}",user7PO);
        }


    }


}
