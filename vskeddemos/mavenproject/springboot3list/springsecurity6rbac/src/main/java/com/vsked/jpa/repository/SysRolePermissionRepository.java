package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysRolePermission;
import com.vsked.jpa.model.SysRolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission, SysRolePermissionId> {
    List<SysRolePermission> findByRoleid(Long roleId);
}
