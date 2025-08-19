package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {

    @Query("SELECT DISTINCT m FROM SysMenu m " +
            "JOIN SysRolePermission rp ON rp.permissionid = m.id " +
            "JOIN SysUserRole ur ON ur.roleid = rp.roleid " +
            "WHERE ur.userid = :userId AND m.status = 1 " +
            "ORDER BY m.sort ASC")
    List<SysMenu> findMenusByUserId(@Param("userId") Long userId);

    List<SysMenu> findByStatusOrderBySort(Byte status);
}