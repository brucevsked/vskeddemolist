package com.example.bookdemo.mapper;

import com.example.bookdemo.pojo.Admin;
import com.example.bookdemo.security.utils.JwtBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Mapper
public interface AdminMapper {
    //登录
    @Select("select name,password from admin where name=#{username} and password=#{password}")
    public Admin login(String username, String password);
    @Select("SELECT name,password FROM admin WHERE name = #{username}")
    Admin selectByName(String username);
    JwtBean login(String username, String password, String code, HttpServletRequest request);
    @Select("select name,password from admin")
    List<Admin> selectAll();

}
