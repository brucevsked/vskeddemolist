package com.jat.demo31;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRoleRepository extends JpaRepository<SysUserRole,SysUserRolePK> {
    void deleteByUserId(Integer userId);
    void deleteByRoleId(Integer roleId);
    void deleteByUserIdAndRoleId(Integer userId,Integer roleId);
}
