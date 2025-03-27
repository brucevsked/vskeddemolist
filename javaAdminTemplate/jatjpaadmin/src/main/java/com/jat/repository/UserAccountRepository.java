package com.jat.repository;

import com.jat.repository.model.UserAccountPK;
import com.jat.repository.model.UserAccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccountPO, UserAccountPK> {
    Optional<UserAccountPO> findByAccountName(String accountName);
    void deleteByUserId(Integer userId);
}
