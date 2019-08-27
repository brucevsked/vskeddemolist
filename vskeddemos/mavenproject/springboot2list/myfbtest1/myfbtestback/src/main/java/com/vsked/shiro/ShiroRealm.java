package com.vsked.shiro;

import com.vsked.common.StringTool;
import com.vsked.common.SysConstant;
import com.vsked.dao.SysRolePermissionDao;
import com.vsked.dao.SysUserDao;
import com.vsked.dao.SysUserRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
    SysUserDao sysUserDao;
	
	@Autowired
    SysUserRoleDao sysUserRoleDao;
	
	@Autowired
    SysRolePermissionDao sysRolePermissionDao;
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof Token;
    }

    @SuppressWarnings("unchecked")
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	Map<String, String> userData=(Map<String, String>) principalCollection.getPrimaryPrincipal();
    	log.debug("userData|"+userData+"");
        // 获取登录用户名
        String sysusername = userData.get("sysusername");
        // 从redis查询用户权限详情
        Object obj = redisTemplate.opsForValue().get(SysConstant.REDIS_PERM + sysusername);
        Map<String, Object> user;
        // 为空则从数据库获取
        if (obj == null) {
            user=sysUserDao.getSysUserByUserName(sysusername);
        } else {
            user = (Map<String, Object>) obj;
        }
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Map<String, String>> roleList=sysUserRoleDao.getSysUserRolesByUserId( user.get("sysuserid")+"");
        for (Map<String, String> role : roleList) {
            // 添加角色
            simpleAuthorizationInfo.addRole(role.get("sysrolename"));
            List<Map<String, Object>> permissionList=sysRolePermissionDao.getSysPermissionByRoleId(role.get("sysroleid"));
            for (Map<String, Object> permission : permissionList) {
                // 添加权限
                simpleAuthorizationInfo.addStringPermission((String) permission.get("code"));
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        Map<String, Object> userMap=JwtUtil.tokenToMap(token);
        String sysusername = (String) userMap.get("sysusername");

        Map<String, Object> user = sysUserDao.getSysUserByUserName(sysusername);
        if (user==null || StringTool.isBlank(user.get("sysuserid")+"")) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException("user not exists");
        }
        
        String sysuserstate=user.get("sysuserstate")+"";

        if (!"1".equals(sysuserstate)) {
        	log.warn(""+user+" has been locked");
            throw new LockedAccountException("account has been locked");
        }
      
        //TODO 验证jwt是否过期自动刷新
        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        return new SimpleAuthenticationInfo(user, token, getName());

    }
}
