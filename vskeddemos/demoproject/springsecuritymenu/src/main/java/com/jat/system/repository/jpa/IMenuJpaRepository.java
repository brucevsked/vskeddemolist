package com.jat.system.repository.jpa;

import com.jat.system.repository.jpa.po.MenuPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IMenuJpaRepository extends JpaRepository<MenuPo, Long>, JpaSpecificationExecutor<MenuPo> {
}
