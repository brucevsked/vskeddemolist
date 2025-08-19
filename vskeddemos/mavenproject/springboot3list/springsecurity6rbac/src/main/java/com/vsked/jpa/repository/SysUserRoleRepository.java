package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysUserRole;
import com.vsked.jpa.model.SysUserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, SysUserRoleId> {
    List<SysUserRole> findByUserid(Long userId);
}
