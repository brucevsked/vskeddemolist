package com.vsked.demo17;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User6RepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(User6RepositoryTest.class);

    @Resource
    User6Repository user6Repository;


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        try {
            Set<Certificate6> certificate6s=new HashSet<>();
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Certificate6 certificate61 = new Certificate6(1L, dateformat.parse("2021-09-30 08:20:30"));

            certificate6s.add(certificate61);


            User6 user6=new User6(201L,"admintest");
            user6.setCertificates(certificate6s);

            user6Repository.save(user6);//保存用户证书数据

            Set<Certificate6> certificate1s=new HashSet<>();


            Certificate6 certificate2 = new Certificate6(6L, dateformat.parse("2020-09-30 08:20:30"));


            certificate1s.add(certificate2);


            User6 user61=new User6(202L,"usertest");
            user61.setCertificates(certificate1s);

            user6Repository.save(user61);//保存用户证书数据

            Set<Certificate6> certificate2s=new HashSet<>();

            Certificate6 certificate3a = new Certificate6(10L, dateformat.parse("2023-10-21 22:10:30"));

            certificate2s.add(certificate3a);

            User6 user62=new User6(203L,"guest");
            user62.setCertificates(certificate2s);

            user6Repository.save(user62);//保存用户证书数据



        }catch (Exception e){
            log.error("测试发生异常了"+e.getMessage(),e);
        }
    }

    @Test
    public void justQuery(){
        Date date=new Date();
        Specification<User6> greatThanExpire=new CertificateExpireSpecification(date);
        List<User6> dataList=user6Repository.findAll(greatThanExpire);
        log.debug("数据数量:{}",dataList.size());
        log.debug("当前用户数据:{}",dataList);
    }
}
