package com.jat.system.repository;

import com.jat.system.model.User;

public interface UserRepository {

    User save(User user);
    User findByUserName(String name);
    User findByCertificateId(Long certificateId);
}
