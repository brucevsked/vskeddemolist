package com.jat.service;

import com.jat.model.IJwtAble;

public interface IJwtUserService {
    /**
     * 登录接口 返回一个 IJwtAble  的数据
     *
     * @param username
     * @param password 
     * @return IJwtAble
     */
	
	IJwtAble login(String username, String password);

    void logout(String token);
}
