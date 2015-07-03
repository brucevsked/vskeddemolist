package com.training.jpa.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.training.jpa.domain.AccountInfo;


public interface UserDao extends CrudRepository<AccountInfo, Long>, UserDaoCustomize {
	
    public Page<AccountInfo> findByBalanceGreaterThan(Integer balance,Pageable pageable);
        
    @Query("SELECT account FROM AccountInfo account INNER JOIN FETCH account.userInfo user WHERE user.username like ? ")
    public List<AccountInfo> findAccountsByName(String name);
    
}
