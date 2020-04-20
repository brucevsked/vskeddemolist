package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
	
    @Select("select * from sysUserT")
    List<Map<String, Object>> list();
    
    @Insert("INSERT INTO sysusert(sysuserid, sysusername, sysuserpwd) VALUES (#{sysuserid}, #{sysusername}, #{sysuserpwd})")
    int add(Map<String, Object> m);
    
    @SelectKey(statement="select count(1) from sysusert where sysuserid=#{sysuserid}", before=true, keyProperty = "suid", resultType = Integer.class)
    @Update("<script>  <if test=\"suid gte 1\">update sysusert set sysusername=#{sysusername}, sysuserpwd=#{sysuserpwd} where sysuserid=#{sysuserid} </if> <if test=\"suid lt 1 \"> INSERT INTO sysusert(sysuserid, sysusername, sysuserpwd) VALUES (#{sysuserid}, #{sysusername}, #{sysuserpwd})</if></script>")
    int saveOrUpdate(Map<String, Object> m);

}
