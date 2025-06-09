package com.vsked.demo7;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
