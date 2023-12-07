package com.vsked.auth.infrastructure.repository.jpa;

import com.vsked.auth.domain.PO.AccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaAccountRepository extends JpaRepository<AccountPO,Long> , JpaSpecificationExecutor<AccountPO> {
}
