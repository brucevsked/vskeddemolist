package com.vsked.auth.application.impl;

import com.vsked.auth.application.LoginService;
import com.vsked.auth.web.model.LoginInfoVO;
import com.vsked.domain.shared.model.RespModel;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public RespModel login(LoginInfoVO loginInfo) {
        return null;
    }
}
