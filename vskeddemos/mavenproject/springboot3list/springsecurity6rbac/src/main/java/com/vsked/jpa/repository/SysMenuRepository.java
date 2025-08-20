package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {

    @Query(value = "select * from sysmenu " +
            "where id in" +
            "(select resourceid from syspermission where resourcetype=2 and id in " +
            "(select permissionid from sysrolepermission where roleid in" +
            "(select roleid from sysuserrole where userid=" +
            "(select id from sysuser where `name`=:userName" +
            "))))",nativeQuery = true)
    List<SysMenu> findMenusByUserName(@Param("userName") String userName);

    List<SysMenu> findByStatusOrderBySort(Byte status);
}