package com.vsked.r2dbc.mysql.service;

import com.vsked.r2dbc.mysql.model.Users;
import com.vsked.r2dbc.mysql.repository.UsersRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class UsersService {

    @Resource
    UsersRepository usersRepository;

    public void save(Users myUser){
        usersRepository.save(myUser).subscribe();
    }


}
