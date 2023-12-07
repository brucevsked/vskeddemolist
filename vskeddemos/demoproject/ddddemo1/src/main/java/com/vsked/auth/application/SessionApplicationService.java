package com.vsked.auth.application;

import com.vsked.auth.domain.PO.AccountPO;
import com.vsked.auth.domain.aggregate.Account;
import com.vsked.auth.domain.aggregate.Session;
import com.vsked.auth.domain.entity.SessionManagement;
import com.vsked.auth.domain.factory.AccountFactory;
import com.vsked.auth.domain.factory.SessionFactory;
import com.vsked.auth.infrastructure.repository.jpa.JpaAccountRepository;
import com.vsked.auth.infrastructure.repository.jpa.specification.JpaAccountSpecByName;
import com.vsked.auth.web.VO.AccountLoginInfoVO;
import com.vsked.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SessionApplicationService {

    private static final Logger log = LoggerFactory.getLogger(SessionApplicationService.class);

    @Autowired
    JpaAccountRepository jpaAccountRepository;

    /**
     * 创建会话
     */
    public String createSession(AccountLoginInfoVO accountLoginInfoVO){
        Specification<AccountPO> accountPOSpec=new JpaAccountSpecByName(accountLoginInfoVO.getName());
        AccountPO accountPO=jpaAccountRepository.findOne(accountPOSpec).get();
        Account account= AccountFactory.createAccountFromPO(accountPO);
        account.login(accountLoginInfoVO);
        Session session= SessionFactory.createSession(account);
        SessionManagement.createSession(session);
        //String respData=new Response("0000","登录成功").toString();
        String respData=new Response("0000","登录成功",session).toString();
        log.debug(respData);
        return respData;
    }

    /**
     * 销毁会话
     */
    public void destorySession(){

    }
}
