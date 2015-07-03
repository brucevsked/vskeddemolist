package com.vsked.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.vsked.bean.UserT;

public interface UserTMapper {
	
	@Select("select * from userT where userId=#{userId}")
	UserT findById(int userId);
	
	@Select("select * from userT")
	List<UserT> findAll();
	

}
