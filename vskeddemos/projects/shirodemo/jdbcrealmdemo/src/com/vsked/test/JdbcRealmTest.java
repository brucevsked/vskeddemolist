package com.vsked.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JdbcRealmTest {

	public static void main(String[] args) {
		MysqlDataSource mds=new MysqlDataSource();
		mds.setUser("root");
		mds.setPassword("bufu110");
		mds.setServerName("localhost");
		mds.setUrl("jdbc:mysql://localhost:3306/shirodemodb");
		
		JdbcRealm jr=new JdbcRealm();
		jr.setDataSource(mds);
		jr.setPermissionsLookupEnabled(true);
		jr.setAuthenticationQuery("SELECT PASSWORD FROM account WHERE name = ?");  
		jr.setUserRolesQuery("SELECT NAME FROM role WHERE id =(SELECT roleId FROM account_role WHERE userId = (SELECT id FROM account WHERE NAME = ?))");  
		jr.setPermissionsQuery("SELECT NAME FROM permission WHERE id in (SELECT permissionId FROM permission_role WHERE (SELECT id FROM role WHERE NAME = ?))"); 
		
		DefaultSecurityManager dsm=new DefaultSecurityManager(jr);
		SecurityUtils.setSecurityManager(dsm); 
		Subject currentUser = SecurityUtils.getSubject();  
		
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token=new UsernamePasswordToken("vsked","admin");
			token.setRememberMe(true);
			try{
			currentUser.login(token);
			System.out.println("login successfully");
			} catch (UnknownAccountException uae) { 				  
                System.out.println("There is no user with username of " + token.getPrincipal());  
  
            } catch (IncorrectCredentialsException ice) {    
                System.out.println("Password for account "+ token.getPrincipal() + " was incorrect!");  
  
            } catch (LockedAccountException lae) {    
                System.out.println("The account for username " + token.getPrincipal() + " is locked.  " + "Please contact your administrator to unlock it.");  
  
            }  
			// ... catch more exceptions here (maybe custom ones specific to  
            // your application?  
			catch (AuthenticationException ae) {  
                // unexpected condition? error?  
            }  
		}
		
		// say who they are:  
		  
        // print their identifying principal (in this case, a username):  
        if(currentUser.getPrincipal()!=null){
        System.out.println("User [" + currentUser.getPrincipal()      + "] logged in successfully.");  
        }else{
        System.out.println("login fail");
        }
        
        // test a role:  
        
        if (currentUser.hasRole("admin")) {  
            System.out.println("May the admin be with you!");  
        } else {  
            System.out.println("Hello, mere mortal.");  
        }  
        
        // test a typed permission (not instance-level)  
        
        if (currentUser.isPermitted("write")) {  
            System.out.println("You can write!.");  
        } else {  
            System.out.println("Sorry, lightsaber rings are for schwartz masters only.");  
        }  
        // a (very powerful) Instance Level permission:  
        
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {    
            System.out.println("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " + "Here are the keys - have fun!");  
        } else {    
            System.out.println("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");  
        }  
        
     // all done - log out!  
        currentUser.logout();  
	}

}
