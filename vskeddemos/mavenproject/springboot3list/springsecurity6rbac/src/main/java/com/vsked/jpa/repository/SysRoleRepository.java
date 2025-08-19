package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

    @Query("SELECT r FROM SysRole r JOIN SysUserRole ur ON r.id = ur.roleid WHERE ur.userid = :userId")
    List<SysRole> findRolesByUserId(@Param("userId") Long userId);
}
