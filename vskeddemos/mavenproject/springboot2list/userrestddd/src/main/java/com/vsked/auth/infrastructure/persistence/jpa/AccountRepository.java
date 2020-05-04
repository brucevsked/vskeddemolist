package com.vsked.auth.infrastructure.persistence.jpa;

import com.vsked.auth.domain.model.LoginRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends LoginRepository, JpaRepository<AccountDTO,Long> {

    @Override
    public AccountDTO findByName(String name);
    //提供具体存储到库方法
}
