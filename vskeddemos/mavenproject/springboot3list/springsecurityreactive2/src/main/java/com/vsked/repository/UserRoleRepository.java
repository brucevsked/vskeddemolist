package com.vsked.repository;

import com.vsked.repository.model.UserRole;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRoleRepository extends ReactiveCrudRepository<UserRole,Void> {

    @Query("SELECT * FROM user_role WHERE user_id = :userId")
    Flux<UserRole> findByUserId(long userId);

    @Query("SELECT * FROM user_role WHERE user_id = :userId")
    Flux<UserRole> findByUserId(Mono<Long> userId);
}
