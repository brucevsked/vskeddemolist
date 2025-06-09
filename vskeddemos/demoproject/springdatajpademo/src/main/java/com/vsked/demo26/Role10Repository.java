package com.vsked.demo26;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Role10Repository extends JpaRepository<Role10,Long> {

//    Role10 findAllByIdNotAndNameIs(Long id,String name);
    Role10 findByIdNotAndNameIs(Long id,String name);

    Optional<Role10> findAllByIdNotAndNameIs(Long id, String name);

}
