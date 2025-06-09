package com.vsked.demo8;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<DeskPO,Long> {
}
