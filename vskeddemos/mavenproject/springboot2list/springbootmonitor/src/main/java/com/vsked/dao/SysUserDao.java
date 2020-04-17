package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
	
	@Select("select * from sysusert")
	List<Map<String, Object>> list();

}
