package com.jat.repository;

import com.jat.repository.model.ResourcePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ResourceRepository extends JpaRepository<ResourcePO,Integer>, JpaSpecificationExecutor<ResourcePO> {

    List<ResourcePO> findAllByIsDelIsOrderBySequenceAsc(Integer isDel);

}
