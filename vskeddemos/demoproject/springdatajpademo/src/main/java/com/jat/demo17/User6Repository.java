package com.jat.demo17;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.Optional;

public interface User6Repository extends JpaRepository<User6,Long>, JpaSpecificationExecutor<User6> {

    Optional<User6> findALLCertificatesByCertificatesExpireTimeAfter(Date nowTime);

}
