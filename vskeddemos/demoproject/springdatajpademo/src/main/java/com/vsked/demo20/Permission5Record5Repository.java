package com.vsked.demo20;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Permission5Record5Repository extends JpaRepository<Permission5Record5,Permission5Record5PK> {
    /**
     * 根据Permission5Record5模型中的permission5变量，
     * 在permission5这个变量的模型中name变量查找数据
     * @param name
     * @return
     */
    Optional<Permission5Record5> findByPermission5Name(String name);
}
