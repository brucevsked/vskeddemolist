package com.vsked.demo27;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DataTestRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(DataTestRepositoryTest.class);

    @Resource
    DataTestRepository dataTestRepository;


    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void testempty(){
        Long id=1L;
        DataTest data1=new DataTest();
        data1.setId(id);
        dataTestRepository.save(data1);

        DataTest data2=dataTestRepository.getById(id);
        log.info("当前数据是:{}",data2);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void testdata(){
        Long id=2L;

        Long nowTime=Calendar.getInstance().getTime().getTime();
        DataTest data1=new DataTest();
        data1.setId(id);
        data1.setDate1(new Date());//Fri Jan 07 09:58:01 CST 2022
        data1.setSqldate1(new java.sql.Date(nowTime));//2022-01-07
        data1.setInstant1(Instant.now());//2022-01-07T01:58:01.991Z
        data1.setLocaldate1(LocalDate.now());//2022-01-07
        data1.setLocaldatetime1(LocalDateTime.now());//2022-01-07T09:58:01.997
        data1.setTimestamp1(new Timestamp(nowTime));
        data1.setZoneddatetime(ZonedDateTime.now()); //2022-01-07T10:06:34.719+08:00[Asia/Shanghai]
        dataTestRepository.save(data1);

        DataTest data2=dataTestRepository.getById(id);
        log.info("当前数据是:{}",data2);
    }
}
