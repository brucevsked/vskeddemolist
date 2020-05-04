package com.vsked.auth.application;

import com.vsked.auth.web.model.LoginInfoVO;
import com.vsked.domain.shared.model.RespModel;

public interface LoginService {
    RespModel login(LoginInfoVO loginInfo);
}
