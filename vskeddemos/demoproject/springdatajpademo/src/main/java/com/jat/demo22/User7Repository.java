package com.jat.demo22;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User7Repository extends JpaRepository<User7PO,Long> {

    Optional<User7PO> findOneByCertificateId(Long id);
}
