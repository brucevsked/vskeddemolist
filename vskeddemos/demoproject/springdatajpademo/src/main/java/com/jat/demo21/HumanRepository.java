package com.jat.demo21;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human,Long> {
}
