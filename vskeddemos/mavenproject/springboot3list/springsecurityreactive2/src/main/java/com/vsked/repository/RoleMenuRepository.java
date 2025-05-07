package com.vsked.repository;

import com.vsked.repository.model.RoleMenu;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RoleMenuRepository extends ReactiveCrudRepository<RoleMenu, Void> {
    @Query("SELECT * FROM role_menu WHERE role_id = :roleId")
    Flux<RoleMenu> findByRoleId(@Param("roleId") Long roleId);
}