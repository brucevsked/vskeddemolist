package com.vsked.jpa.repository;

import com.vsked.jpa.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Long> {
}
