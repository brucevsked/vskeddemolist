package com.jat.system.service;

import com.jat.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {

    @Autowired
    UserService userService;

    public void delete(Long certificateId){
        User user=userService.findByCertificateId(certificateId);
        if(user!=null){
            user.logout();
            userService.save(user);
        }
    }
}
