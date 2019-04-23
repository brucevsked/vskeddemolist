package com.appserveruser.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper {
	
	@Select("select * from appUserT  where username=#{username}")
	Map<String, Object> getAppUserByUserName(String username);

}
