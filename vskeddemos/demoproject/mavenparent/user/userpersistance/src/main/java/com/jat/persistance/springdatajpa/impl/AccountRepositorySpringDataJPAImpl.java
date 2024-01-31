package com.jat.persistance.springdatajpa.impl;

import com.jat.repository.AccountNamePasswordRepository;
import com.jat.persistance.springdatajpa.AccountRepositorySpringDataJPA;
import com.jat.repository.entity.AccountNamePasswordAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;


public class AccountRepositorySpringDataJPAImpl implements AccountNamePasswordRepository {

    @Autowired
    AccountRepositorySpringDataJPA accountRepositorySpringDataJPA;

    @Override
    public void save(AccountNamePasswordAccountEntity accountEntity) {
        accountRepositorySpringDataJPA.save(accountEntity);
    }
}
