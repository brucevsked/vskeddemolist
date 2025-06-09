package com.vsked.demo5;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.Optional;


public class DriverManRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(DriverManRepositoryTest.class);

    @Resource
    DriverManRepository driverManRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){
        log.trace(" start test create");
        String driverCardId="driver001";
        String driverCardNumber="老王666";
        String driveCardEexpireDate="2099-01-01";
        DriverCard driverCard=new DriverCard(driverCardId,driverCardNumber,driveCardEexpireDate);
        log.info("当前保存前的实体是:{}",driverCard);

        String driverManId="laowang9";
        String driverManName="老王";

        DriverMan driverMan=new DriverMan(driverManId,driverManName,driverCard);
        log.info("当前保存前的实体是:{}",driverMan);
        driverManRepository.save(driverMan);//可以打断点看日志
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void query1(){
        log.trace(" start test create");
        String driverCardId="driver001";
        String driverCardNumber="老王666";
        String driveCardEexpireDate="2099-01-01";
        DriverCard driverCard=new DriverCard(driverCardId,driverCardNumber,driveCardEexpireDate);
        log.info("当前保存前的实体是:{}",driverCard);

        String driverManId="laowang9";
        String driverManName="老王";

        DriverMan driverMan=new DriverMan(driverManId,driverManName,driverCard);
        log.info("当前保存前的实体是:{}",driverMan);
        driverManRepository.save(driverMan);//可以打断点看日志

        DriverCard driverCardQueryParameter=new DriverCard();
        driverCardQueryParameter.setId(driverCardId);
        DriverMan driverManQueryParamter=new DriverMan();
        driverManQueryParamter.setDriverCard(driverCardQueryParameter);
        Example<DriverMan> driverCardExample=Example.of(driverManQueryParamter);
        Optional<DriverMan> driverManQueryOptional=driverManRepository.findOne(driverCardExample);
        DriverMan driverManQuery=driverManQueryOptional.orElse(null);
        log.info("当前保存前的实体是:{}",driverManQuery);

    }


}
