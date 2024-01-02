package com.example.bookdemo;

import com.example.bookdemo.mapper.AdminMapper;
import com.example.bookdemo.pojo.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;


public class TestOne extends BaseTestWithoutTransactional{
    private static final Logger log = LoggerFactory.getLogger(BookdemoApplication.class);

    @Autowired
    AdminMapper adminMapper;

    @BeforeTest
    public void One(){
        log.debug("你好 2022-8-16");
    }

    @Test
    public void Two(){
        List<Admin> admins = adminMapper.selectAll();
        for (Admin admin:admins) {
            log.info(admin.toString());
        }
    }

}
