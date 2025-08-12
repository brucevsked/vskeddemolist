package com.vsked.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vsked.test.BaseTestWithTransactional;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class MyMapperTest extends BaseTestWithTransactional {
    private static final Logger log = LoggerFactory.getLogger(MyMapperTest.class);

   @Resource
    MyMapper myMapper;

    @Test
    public void findById() {
        Map<String, String> data = myMapper.findById("users", "uid", "1");
        log.info("queryById:{}", data);
    }

    @Test
    public void findAll() {
        List<Map<String, String>> data = myMapper.findAll("users");
        log.info("{}", data);
    }

    @Test
    public void findByPage() {
        int pageNum =1;
        int pageSize =10;
        Page<Map<String, String>> page =new Page<>(pageNum, pageSize);
        Page<Map<String, String>> data = myMapper.selectPage(page,null);
        log.info("{}", data);

    }
}
