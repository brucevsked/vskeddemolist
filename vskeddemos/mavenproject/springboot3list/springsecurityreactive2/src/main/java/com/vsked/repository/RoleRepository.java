package com.vsked.repository;

import com.vsked.repository.model.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RoleRepository extends ReactiveCrudRepository<Role,Long> {
}
