package com.vsked.auth.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionDto, Long>{

	public int deleteUserById(int id);
	
}
