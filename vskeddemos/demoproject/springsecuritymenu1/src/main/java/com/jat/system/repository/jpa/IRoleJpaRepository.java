package com.jat.system.repository.jpa;

import com.jat.system.repository.jpa.po.RolePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRoleJpaRepository extends JpaRepository<RolePo, Long>, JpaSpecificationExecutor<RolePo> {
}
