package com.vsked.dao.postgre;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

@Repository
public interface SysUserDao {

    @Select("select * from sysusert")
    List<Map<String, Object>> list();
}
