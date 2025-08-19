package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionRepository extends JpaRepository<SysPermission, Long> {

    @Query("SELECT p FROM SysPermission p " +
            "JOIN SysRolePermission rp ON rp.permissionid = p.id " +
            "JOIN SysUserRole ur ON ur.roleid = rp.roleid " +
            "WHERE ur.userid = :userId")
    List<SysPermission> findPermissionsByUserId(@Param("userId") Long userId);
}