package com.training.jpa.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.training.jpa.domain.AccountInfo;


public interface UserDao extends CrudRepository<AccountInfo, Long> {	

    public Page<AccountInfo> findByBalanceGreaterThan(Integer balance,Pageable pageable);
}
