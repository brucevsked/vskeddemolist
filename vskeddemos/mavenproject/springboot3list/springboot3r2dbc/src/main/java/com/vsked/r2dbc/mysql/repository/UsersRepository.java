package com.vsked.r2dbc.mysql.repository;

import com.vsked.r2dbc.mysql.model.Users;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UsersRepository extends ReactiveCrudRepository<Users, Integer> {
    Mono<Users> findByUserName(String userName);
}
