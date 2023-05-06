package com.jat.auth.infrastructure.persistence.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto,Long>{
    
	public List<UserDto> findAllBy();
	
    public int deleteUserById(int id);
    
    public UserDto findByid(int id);
    
}
