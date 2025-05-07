package com.vsked.repository;

import com.vsked.repository.model.Menu;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface MenuRepository extends ReactiveCrudRepository<Menu, Long> {
    Mono<Menu> findById(Long menuId);
}
