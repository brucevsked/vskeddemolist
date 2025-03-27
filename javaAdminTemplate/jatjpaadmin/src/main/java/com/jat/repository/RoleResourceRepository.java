package com.jat.repository;

import com.jat.repository.model.RoleResourcePK;
import com.jat.repository.model.RoleResourcePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RoleResourceRepository extends JpaRepository<RoleResourcePO, RoleResourcePK> {

    List<RoleResourcePO> findByRoleIdInOrderByResourceSequenceAsc(List<Integer> roleIds);
    List<RoleResourcePO> findByRoleId(Integer roleId);
    void deleteByRoleId(Integer roleId);

    @Modifying
    @Query(value = "update roleResource set isDel=1 where roleId=?",nativeQuery = true)
    void updateIsDelByRoleId(Integer roleId);

    @Modifying
    @Query(value = "update roleResource set isDel=1 where resId=?",nativeQuery = true)
    void updateIsDelByResId(Integer resId);

}
