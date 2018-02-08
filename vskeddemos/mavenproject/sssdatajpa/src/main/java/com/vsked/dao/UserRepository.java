package com.vsked.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vsked.bean.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	List<User> findByUserName(String userName);

}
