package com.jat.repository;

import com.jat.repository.model.UserRolePK;
import com.jat.repository.model.UserRolePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRolePO, UserRolePK> {

    List<UserRolePO> findByUserId(Integer userId);

    void deleteByUserId(Integer userId);

    @Modifying
    @Query(value = "update userRole set isDel=1 where roleId=?",nativeQuery = true)
    void updateIsDelByRoleId(Integer roleId);

}
