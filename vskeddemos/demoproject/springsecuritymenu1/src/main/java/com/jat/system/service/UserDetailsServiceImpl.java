package com.jat.system.service;

import com.jat.system.model.User;
import com.jat.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userJpaRepositoryImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userJpaRepositoryImpl.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户"+username+"不存在！");
        }
        return user;
    }

}
