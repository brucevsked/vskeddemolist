package com.jat.system.service;

import com.jat.system.model.Certificate;
import com.jat.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;

    public String authentication(String name, String password) {
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, password));
        User user= (User) authentication.getPrincipal();
        Certificate certificate=new Certificate();
        user.setCertificate(certificate);
        user=userService.save(user);
        return user.getCertificate().toString();
    }

}
