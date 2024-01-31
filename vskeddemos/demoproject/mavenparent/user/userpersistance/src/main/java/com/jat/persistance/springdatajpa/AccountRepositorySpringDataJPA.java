package com.jat.persistance.springdatajpa;

import com.jat.repository.entity.AccountNamePasswordAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositorySpringDataJPA extends JpaRepository<AccountNamePasswordAccountEntity,Long> {
}
