package com.vsked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vsked.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer>,JpaSpecificationExecutor<Commodity>{
	
}
