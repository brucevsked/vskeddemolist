package com.jat.auth.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleDto, Long> {

	public int deleteUserById(int id);
	
}
