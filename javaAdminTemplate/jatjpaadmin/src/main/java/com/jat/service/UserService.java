package com.jat.service;

import com.jat.config.JwtKit;
import com.jat.controller.model.TableView;
import com.jat.controller.model.UserListUserView;
import com.jat.controller.model.UserView;
import com.jat.repository.UserRepository;
import com.jat.repository.model.AccountPO;
import com.jat.repository.model.RolePO;
import com.jat.repository.model.UserAccountPO;
import com.jat.repository.model.UserPO;
import com.jat.repository.model.UserRolePO;
import com.jat.system.model.Phone;
import com.jat.system.model.account.Account;
import com.jat.system.model.account.AccountName;
import com.jat.system.model.account.AccountPass;
import com.jat.system.model.user.User;
import com.jat.system.model.user.UserId;
import com.jat.system.model.user.UserName;
import com.jat.system.model.userAccount.UserAccount;
import com.jat.system.model.userRole.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService{
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    PageService pageService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserAccountService userAccountService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    JwtKit jwtKit;

    public TableView list(Map<String,Object> params){
        PageService pageService1=pageService.getPage(params);
        log.debug("{}",pageService1);
        String name=pageService.getLike(params.get("name"));
        String phone=pageService.getLike(params.get("phone"));
        Integer isDel=0;
        String accountName=pageService.getLike(params.get("accountName"));
        Pageable pageable= PageRequest.of(pageService1.getPageIndex(),pageService1.getPageSize());

        Page<UserPO> userPage=userRepository.findByNameLikeAndPhoneLikeAndIsDelIsLikeAndUserAccountAccountNameLike(name,phone,isDel,accountName,pageable);
        List<UserPO> users=userPage.getContent();
        List<UserListUserView> userList=new LinkedList<>();
        for(UserPO po:users){
            UserListUserView userView=new UserListUserView();
            userView.setId(po.getId());
            userView.setName(po.getName());
            userView.setPhone(po.getPhone());
            userView.setAccountname(po.getUserAccount().getAccount().getName());
            List<UserRolePO> userRoles=po.getUserRoles();
            StringBuffer sb=new StringBuffer();
            for(UserRolePO userRolePO:userRoles){
                sb.append(userRolePO.getRole().getName());
                sb.append(",");
            }
            userView.setRolename(sb.toString());
            userList.add(userView);
        }

        return new TableView(userPage.getTotalElements(),userList);
    }

    public void add(Map<String,Object> params) {
        String accountNameStr = getStr(params.get("accountName"));
        String accountPassStr = getStr(params.get("accountPass"));
        String nameStr = getStr(params.get("name"));
        String phoneStr = getStr(params.get("phone"));
        List<Integer> roleIdsIntList = getIntList(params.get("roleIds"));

        log.debug("{},{},{},{},{}",accountNameStr,accountPassStr,nameStr,phoneStr,roleIdsIntList);
        AccountName accountName=new AccountName(accountNameStr);
        AccountPass accountPass=new AccountPass(accountPassStr);
        Account account=new Account(accountName,accountPass);
        log.debug("{}",account);

        UserName userName=new UserName(nameStr);
        Phone phone=new Phone(phoneStr);
        User user=new User(userName,phone);
        log.debug("{}",user);

        UserAccount userAccount=new UserAccount(user,account);
        userAccount=userAccountService.add(userAccount);
        log.debug("{}",userAccount);

        //保存用户角色
        List<UserRole> userRoles=userRoleService.add(userAccount.getUser(),roleIdsIntList);
        log.debug("{}",userRoles);

    }

    public void edit(Map<String,Object> params) {
        Integer idInt=getInt(params.get("id"));
        String nameStr = getStr(params.get("name"));
        String phoneStr = getStr(params.get("phone"));
        List<Integer> idsIntList = getIntList(params.get("roleIds"));

        log.debug("{},{},{}",idInt,nameStr,phoneStr,idsIntList);

        UserId userId=new UserId(idInt);
        UserName userName=new UserName(nameStr);
        Phone phone=new Phone(phoneStr);
        User user=new User(userId,userName,phone);
        UserPO userPO=user.boToPo(0);
        userPO=userRepository.save(userPO); //保存用户

        List<UserRolePO> userRolePos=new LinkedList<>();

        List<RolePO> roles=roleService.findAllById(idsIntList);
        for(Integer rid:idsIntList){
            RolePO rolePo=roleService.findById(roles,rid);
            UserRolePO userRolePO=new UserRolePO(userPO,rolePo);
            userRolePos.add(userRolePO);
        }
        //清除原用户角色关系
        userRoleService.deleteByUserId(userId.getId());
        //保存新用户角色关系
        userRoleService.save(userRolePos);

    }

    public void del(Map<String,Object> params) {
        Integer idInt=getInt(params.get("id"));
        log.debug("{}", idInt);
        UserPO user=userRepository.findById(idInt).orElse(null);
        user.setIsDel(1);//删除标记
        userRepository.save(user);//保存用户
        AccountPO accountPO=user.getUserAccount().getAccount();
        accountPO.setIsDel(1);//账号删除标记
        Account account=Account.poToBo(accountPO);
        accountService.save(account,1);//保存账号
        UserAccountPO userAccountPO=user.getUserAccount();
        userAccountPO.setIsDel(1);
        userAccountService.save(userAccountPO);//用户账号
        List<UserRolePO> userRolePos=user.getUserRoles();
        List<UserRolePO> userRolePosDel=new LinkedList<>();
        for(UserRolePO po:userRolePos){
            po.setIsDel(1);//删除标记
            userRolePosDel.add(po);
        }
        userRoleService.save(userRolePosDel);//用户角色
    }

    public void changepwd(HttpServletRequest req,Map<String,Object> params){
        UserView userView=jwtKit.getUser(req);
        UserPO userPO=userRepository.findById(userView.getId()).orElse(null);

        String oldValStr = getStr(params.get("oldVal"));
        String newValStr = getStr(params.get("newVal"));

        AccountPO accountPO=userPO.getUserAccount().getAccount();
        Account account=Account.poToBo(accountPO);

        AccountPass accountPassOld=new AccountPass(oldValStr);

        AccountPass accountPassNew=new AccountPass(newValStr);
        account.changePassword(accountPassOld,accountPassNew);

        accountService.save(account,0);
    }

    public void resetUserPwd(Map<String,Object> params){
        Integer idInt=getInt(params.get("id"));
        log.debug("{}", idInt);
        UserPO userPO=userRepository.findById(idInt).orElse(null);

        String accountPassStr = getStr(params.get("accountPass"));

        AccountPO accountPO=userPO.getUserAccount().getAccount();
        Account account=Account.poToBo(accountPO);
        AccountPass accountPass=new AccountPass(accountPassStr);
        account.resetPassword(accountPass);
        accountService.save(account,0);
    }

    public User add(User user,Integer isDel){
        UserPO po=user.boToPo(isDel);
        po=userRepository.save(po);
        return User.poToBo(po);
    }
    public User save(User user,Integer isDel){
        UserPO po=user.boToPo(isDel);
        po=userRepository.save(po);
        return User.poToBo(po);
    }

}
