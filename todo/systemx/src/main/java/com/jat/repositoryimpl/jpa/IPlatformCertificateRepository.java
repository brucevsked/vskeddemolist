package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformCertificatePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPlatformCertificateRepository extends JpaRepository<PlatformCertificatePO,Long> {

    @Query("select max(id)+1 from PlatformCertificatePO")
    Long nextId();

}
