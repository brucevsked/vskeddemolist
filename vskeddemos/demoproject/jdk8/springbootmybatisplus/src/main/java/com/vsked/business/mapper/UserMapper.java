package com.vsked.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsked.business.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where id=1")
    public User test();
}
