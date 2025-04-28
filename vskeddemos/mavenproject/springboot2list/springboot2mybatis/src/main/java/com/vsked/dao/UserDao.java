package com.vsked.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface UserDao {

    @Insert("INSERT INTO users(uid, uname,upass,ubirth) VALUES(#{uid,jdbcType=INTEGER},#{uname,jdbcType=VARCHAR},#{upass,jdbcType=VARCHAR},#{ubirth,jdbcType=DATE})")
    int insertUser(Map<String, Object> user);

    @Insert("<script> insert into users(uid, uname,upass,ubirth) values <foreach collection=\"myList\" item=\"emp\" separator=\",\">(#{emp.uid,jdbcType=INTEGER},#{emp.uname},#{emp.upass},#{emp.ubirth,jdbcType=DATE}) </foreach> </script>")
    int insertUsers(Map<String, Object> dataMap);

    @Update("<script>" +
            "UPDATE users " +
            "SET upass = CASE uid " +
            "<foreach collection='myList' item='emp'>" +
            "WHEN #{emp.uid,jdbcType=INTEGER} THEN #{emp.upass} " +
            "</foreach> " +
            "END " +
            "WHERE uid IN " +
            "<foreach collection='myList' item='emp' open='(' separator=',' close=')'>" +
            "#{emp.uid,jdbcType=INTEGER}" +
            "</foreach>" +
            "</script>")
    int updateUsers(Map<String, Object> dataMap);


}
