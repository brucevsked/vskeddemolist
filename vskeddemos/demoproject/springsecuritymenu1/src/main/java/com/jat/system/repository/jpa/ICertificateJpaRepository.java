package com.jat.system.repository.jpa;

import com.jat.system.repository.jpa.po.CertificatePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICertificateJpaRepository extends JpaRepository<CertificatePo,Long> , JpaSpecificationExecutor<CertificatePo> {
}
