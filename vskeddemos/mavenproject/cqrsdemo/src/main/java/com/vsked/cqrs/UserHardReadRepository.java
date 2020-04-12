package com.vsked.cqrs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserHardReadRepository extends JpaRepository<UserHardRead, Integer>{
	

}
