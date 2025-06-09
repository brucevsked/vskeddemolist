package com.vsked.demo11;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<ActionPO, Long> {
}
