package com.jat.repository;

import com.jat.repository.model.RolePO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RolePO,Integer> {

    Page<RolePO> findByNameLikeAndIsDelIs(String name,Integer isDel,Pageable pageable);
    List<RolePO> findAllByIsDelIsOrderByIdAsc(Integer isDel);


}
