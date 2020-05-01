package com.vsked.auth.service;

import com.vsked.auth.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
