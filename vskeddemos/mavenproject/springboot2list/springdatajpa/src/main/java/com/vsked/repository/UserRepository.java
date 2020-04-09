package com.vsked.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsked.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
