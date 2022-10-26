package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformUserAccountPK;
import com.jat.po.PlatformUserAccountPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPlatformUserAccountRepository extends JpaRepository<PlatformUserAccountPO, PlatformUserAccountPK> {

    Optional<PlatformUserAccountPO> findByAccountName(String accountName);
}
