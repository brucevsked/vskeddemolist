package com.vsked.service;

import com.vsked.common.StringTool;
import com.vsked.dao.SysUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    public String list(){
        String result="";
        try{
            System.out.println("hallo ----------------");
            result= StringTool.listToJson(sysUserDao.list());
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return result;
    }
}
