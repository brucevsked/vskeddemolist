package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformAccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface IPlatformAccountRepository extends JpaRepository<PlatformAccountPO, Long>{

    Optional<PlatformAccountPO> findByName(String name);

    @Query("select max(id)+1 from PlatformAccountPO")
    Long nextId();

}
