package com.vsked.shiro;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.service.SysRolePermissionSer;
import com.vsked.service.SysUserRoleSer;
import com.vsked.service.SysUserSer;


/**
 * 自定义Realm,进行数据源配置
 *
 */

@Service
@Transactional
public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	SysUserSer sysUserSer;
	
	@Autowired
	SysUserRoleSer sysUserRoleSer;
	
	@Autowired
	SysRolePermissionSer sysRolePermissionSer;

    
    /**
     * 获取授权信息
     */
    @SuppressWarnings("unchecked")
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名  
    	Map<String,Object> userData = (Map<String, Object>) principalCollection.fromRealm(getName()).iterator().next();
    	String loginName=(String) userData.get("suName");
        Map<String, Object> sysUserParMap=new HashMap<String, Object>();
        sysUserParMap.put("suName", loginName);
        //到数据库获取此用户
        Map<String, Object> user=sysUserSer.getSysUserBySuName(loginName);
        if(user!=null){
        	String suId=(String)user.get("SUID");
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            
            List<Map<String, Object>> sysUserRoleList=sysUserRoleSer.getSysUserRoleListBySuId(suId);
            
            Set<String> userRoleNameSet=new HashSet<String>();
            for(Map<String, Object> sysUserRole:sysUserRoleList){
            	String srId=(String)sysUserRole.get("SRID");
            	String srName=(String)sysUserRole.get("SRNAME");
            	userRoleNameSet.add(srName);
            	
            	List<Map<String, Object>> sysRolePermissionList=sysRolePermissionSer.getSysRolePermissionBySrId(srId);
            	
            	Set<String> permissionNameSet=new HashSet<String>();
            	
            	 //用户的角色对应的所有权限，如果只使用角色定义访问权限
            	for(Map<String, Object> sysRolePermission:sysRolePermissionList){
            		String spName=(String)sysRolePermission.get("SPNAME");
            		permissionNameSet.add(spName);
            	}
            	info.addStringPermissions(permissionNameSet);
    		}
            //用户的角色集合
            info.setRoles(userRoleNameSet);
            
            return info;
        }
        return null;
    }

    /**
     * 获取身份验证相关信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息  
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String suName=token.getUsername();
        //查出是否有此用户  
        Map<String, Object> user=sysUserSer.getSysUserBySuName(suName);
        if(user!=null){
        	//-----------------------------------start single user---开启单用户登陆
        	DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        	DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
        	Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
            for(Session session:sessions){
                //清除该用户以前登录时保存的session
                if(suName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
                    sessionManager.getSessionDAO().delete(session);
                }
            }
        	//-----------------------------------end single user
            //将用户信息放入session
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            //若存在，将此用户存放到登录认证info中  
            return new SimpleAuthenticationInfo(user, user.get("SUPASS"), getName());
        }
        return null;
    }

}
