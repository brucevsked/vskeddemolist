package com.jat.system.repository.jpa;

import com.jat.system.repository.jpa.po.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface IUserJpaRepository extends JpaRepository<UserPo, Long>, JpaSpecificationExecutor<UserPo> {

    Optional<UserPo> findByName(String name);
    Optional<UserPo> findByCertificateId(Long certificateId);
}
