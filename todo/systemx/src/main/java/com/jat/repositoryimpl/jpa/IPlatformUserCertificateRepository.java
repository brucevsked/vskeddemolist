package com.jat.repositoryimpl.jpa;

import com.jat.po.PlatformUserCertificatePK;
import com.jat.po.PlatformUserCertificatePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPlatformUserCertificateRepository extends JpaRepository<PlatformUserCertificatePO, PlatformUserCertificatePK> {

}
