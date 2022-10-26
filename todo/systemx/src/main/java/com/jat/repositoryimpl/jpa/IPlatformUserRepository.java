package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformUserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPlatformUserRepository extends JpaRepository<PlatformUserPO,Long> {

    @Query("select max(id)+1 from PlatformUserPO")
    Long nextId();

}
