package com.jat.system.service;

import com.jat.system.model.User;
import com.jat.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userJpaRepositoryImpl;

    public User findByCertificateId(Long certificateId){
        return userJpaRepositoryImpl.findByCertificateId(certificateId);
    }

    public User save(User user){
        return userJpaRepositoryImpl.save(user);
    }

}
