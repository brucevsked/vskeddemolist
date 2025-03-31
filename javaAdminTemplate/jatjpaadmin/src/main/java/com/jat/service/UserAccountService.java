package com.jat.service;

import com.jat.config.JwtKit;
import com.jat.controller.model.LoginAccount;
import com.jat.controller.model.UserView;
import com.jat.repository.UserAccountRepository;
import com.jat.repository.model.UserAccountPO;
import com.jat.system.model.account.Account;
import com.jat.system.model.account.AccountName;
import com.jat.system.model.account.AccountPass;
import com.jat.system.model.user.User;
import com.jat.system.model.userAccount.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserAccountService {

    private static final Logger log = LoggerFactory.getLogger(UserAccountService.class);

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;

    @Autowired
    JwtKit jwtKit;

    public UserAccount findBy(AccountName accountName){
        UserAccountPO userAccountPO=userAccountRepository.findByAccountName(accountName.getName()).orElse(null);
        return UserAccount.poToBo(userAccountPO);
    }

    public String login(LoginAccount loginAccount){
        AccountName accountName=new AccountName(loginAccount.getUserName());
        UserAccount userAccount=findBy(accountName);

        AccountPass accountPass=new AccountPass(loginAccount.getPassword());
        Account account=new Account(accountName,accountPass);
        userAccount.login(account);

        UserView userView=UserView.userToView(userAccount.getUser());
        String token=jwtKit.getToken(userView);
        log.debug("{}",token);
        return token;
    }

    public void logout(HttpServletRequest req){
        jwtKit.removeToken(req);
    }

    public UserView getUserInfo(HttpServletRequest req){
        return jwtKit.getUser(req);
    }

    public UserAccount add(UserAccount userAccount){
        Account account=userAccount.getAccount();
        account=accountService.add(account,0);
        User user=userAccount.getUser();
        user=userService.add(user,0);
        userAccount=new UserAccount(user,account);
        UserAccountPO po=userAccount.boToPo(0);
        po=save(po);
        return UserAccount.poToBo(po);
    }

    public UserAccountPO save(UserAccountPO po){
        return userAccountRepository.save(po);
    }

    public void deleteByUserId(Integer userId){
        userAccountRepository.deleteByUserId(userId);
    }


}
