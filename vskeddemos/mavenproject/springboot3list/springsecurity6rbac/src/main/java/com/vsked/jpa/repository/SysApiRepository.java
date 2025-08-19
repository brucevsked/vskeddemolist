package com.vsked.jpa.repository;

import com.vsked.jpa.model.SysApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysApiRepository extends JpaRepository<SysApi, Long> {
}
