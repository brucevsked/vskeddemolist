package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
	
    @Select("select * from sysUserT")
    List<Map<String, Object>> list();
    
    @Insert("INSERT INTO sysusert(sysuserid, sysusername, sysuserpwd) VALUES (#{sysuserid}, #{sysusername}, #{sysuserpwd})")
    int add(Map<String, Object> m);

}
