package com.vsked.auth.repository;

import com.vsked.auth.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
