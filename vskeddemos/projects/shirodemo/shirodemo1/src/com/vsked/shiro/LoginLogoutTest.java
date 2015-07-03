package com.vsked.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class LoginLogoutTest {

	public static void main(String[] args) {
		Factory<SecurityManager> f=new IniSecurityManagerFactory(LoginLogoutTest.class.getResource("/")+"shiro.ini");
		SecurityManager sm=f.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject sj=SecurityUtils.getSubject();
		UsernamePasswordToken upt=new UsernamePasswordToken("vsked","123");
		try{
			sj.login(upt);
			System.out.println("login ok");
		}catch(AuthenticationException e){
			e.printStackTrace();
			System.out.println("login fail");
		}
		sj.logout();

	}

}
