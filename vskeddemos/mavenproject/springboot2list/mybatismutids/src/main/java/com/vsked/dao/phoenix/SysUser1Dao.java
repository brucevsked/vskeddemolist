package com.vsked.dao.phoenix;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

@Repository
public interface SysUser1Dao {

    @Select("select * from vskedtest")
    List<Map<String, Object>> list();
}
