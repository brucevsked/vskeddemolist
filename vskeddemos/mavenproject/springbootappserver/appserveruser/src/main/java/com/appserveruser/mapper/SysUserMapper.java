package com.appserveruser.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
	
	@Select("select * from sysUserT where suid=#{suid}")
	Map<String, Object> getBySuId(String suid);

}
