package com.vsked.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    
    @Insert("INSERT INTO userinfo(username, password) VALUES(#{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR})")
    public int insertUser(Map<String, Object> user);
    
    @Select("SELECT * FROM userinfo WHERE username = #{username} AND password = #{password}")
    public Map<String, Object> selectByUsernameAndPwd(@Param("username")String username ,@Param("password")String password);
}
