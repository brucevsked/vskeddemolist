package com.vsked.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsked.model.Users;
import org.apache.ibatis.annotations.Select;
import java.util.Map;

public interface UserMapper extends BaseMapper<Users> {

    @Select("select * from users where uid=2")
    Users test();

    @Select("select * from users where uid=#{uid}")
    Map<String, String> queryById(long uid);
}
