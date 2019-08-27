package com.vsked.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

@Repository
public interface SysUserDao {

    @Select("select * from sysUserT")
    List<Map<String,Object>> list();

    @Select("select * from sysUserT a where a.sysusername=#{sysusername}")
    Map<String, Object> getSysUserByUserName(String sysusername);
}
