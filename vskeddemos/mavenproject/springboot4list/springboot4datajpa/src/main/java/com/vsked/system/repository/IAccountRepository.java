package com.vsked.system.repository;

import com.vsked.system.model.po.AccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<AccountPO, Long>{

    Optional<AccountPO> findByAccountName(String accountName);

}
