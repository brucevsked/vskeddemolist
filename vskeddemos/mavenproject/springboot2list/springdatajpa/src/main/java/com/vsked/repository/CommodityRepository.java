package com.vsked.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsked.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer>{
	
}
