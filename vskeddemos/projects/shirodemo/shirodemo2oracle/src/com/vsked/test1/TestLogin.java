package com.vsked.test1;


import oracle.jdbc.pool.OracleDataSource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class TestLogin {

	public static void main(String[] args) throws Exception {
		
		String testLoginUserName="admin";
		String testLoginUserPass="admin";
		String testRoleName="平台超级管理员";
		String testPermissionName="使用平台所有系统模块";
		
		String dbHost="localhost";
		String dbPort="1521";
		String dbName="orcl";
		String userName = "SHIRODEMO2";
	    String userPass = "shirodemo2";
	    String dbUrl="jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbName;
	    
		OracleDataSource ds=new OracleDataSource();
		ds.setUser(userName);
		ds.setPassword(userPass);
		ds.setServerName(dbHost);
		ds.setURL(dbUrl);
		
		
		JdbcRealm jdbcRealmA01=new JdbcRealm();
		jdbcRealmA01.setDataSource(ds);
		
		jdbcRealmA01.setPermissionsLookupEnabled(true);
		
		String authenticationQuery="select SUPASS from SYSUSERT where SUNAME=?";
		jdbcRealmA01.setAuthenticationQuery(authenticationQuery);
		
		String userRolesQuery="SELECT SRNAME FROM SYSROLET WHERE SRID IN (SELECT SRID FROM SYSROLEUSERT WHERE SUID=(SELECT SUID FROM SYSUSERT WHERE SUNAME=?)  )";
		jdbcRealmA01.setUserRolesQuery(userRolesQuery);
		
		String permissionsQuery="select SPNAME from SYSPERMISSIONT where SPOWNER=1 and SPTYPE=1 and SPSTATE=1 and SPRESID='1' and OWNERID IN (select SRID from SYSROLET where SRNAME=?)";
		jdbcRealmA01.setPermissionsQuery(permissionsQuery);
		
		DefaultSecurityManager security = new DefaultSecurityManager(jdbcRealmA01);
		SecurityUtils.setSecurityManager(security);
		Subject currentUser = SecurityUtils.getSubject();  
		
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken userToken= new UsernamePasswordToken(testLoginUserName,testLoginUserPass);
			userToken.setRememberMe(true);
			try{
			currentUser.login(userToken);
			System.out.println("login ok");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValueffss1");
        String value = (String) session.getAttribute("someKey");
        System.out.println("session:"+value);
        
		
		System.out.println("User [" + currentUser.getPrincipal()   + "] logged in successfully.");  
		try{
		if(currentUser.hasRole(testRoleName)){
			System.out.println("has role "+testRoleName);
		}else{
			System.out.println("no role "+testRoleName);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//spName
		if(currentUser.isPermitted(testPermissionName)){
			System.out.println("has permiss "+testPermissionName);
		}else{
			System.out.println("no permiss "+testPermissionName);
		}
		//springSide4 有个完整的例子
		//资源标识:操作:对象ID 哪个资源的哪个实例可以进行什么操作 默认支持通配符字符串
		/**
		 * 单个资源单个权限
		 * subject().checkPermissions("system:user:update"); 
		 * 单个资源多个权限
		 * ini配置文件 role42="system:user:update,delete"
		 * Java代码 subject().checkPermissions("system:user:update,delete");
		 * 单个资源全部权限
		 * ini配置文件 role52=system:user:*
		 * Java代码 subject().checkPermissions("system:user:*"); 
		 * 所有资源全部权限
		 * role61=*:view
		 */
		/*
		if(currentUser.isPermitted("role:user:update")){
			
		}else{
			
		}
		*/
		
		//currentUser.logout();

	}

}
