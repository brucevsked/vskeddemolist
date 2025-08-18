package com.vsked.business.mapper;

import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface MyMapper extends BaseMapper<Map<String, String>> {

      @Select("select * from ${tableName} where ${id}=${idValue}")
      Map<String, String> findById(@Param("tableName") String tableName, @Param("id") String id, @Param("idValue") String idValue);

      @Select("select * from ${tableName}")
      List<Map<String, String>> findAll(@Param("tableName") String tableName);
}
