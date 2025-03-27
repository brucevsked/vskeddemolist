package com.jat.repository;

import com.jat.repository.model.AccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountPO,Integer> {
    Optional<AccountPO> findByName(String accountName);
}
