package com.vsked.controller;

import com.vsked.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @Transactional  //事务 单表不加，多表加
    @PostMapping
    public String saveCustomer(@RequestBody Map<String, Object> params) {
        log.debug("接收到保存客户请求参数: {}", params);
        userDao.insertUser(params);
        return "200";
    }
}
