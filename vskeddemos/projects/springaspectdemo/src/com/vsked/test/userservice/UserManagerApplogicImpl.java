package com.vsked.test.userservice;

   
 import org.springframework.stereotype.Component;  
   
 @Component("userManager")   
 public class UserManagerApplogicImpl implements UserManagerApplogic {  
   
     @BussAnnotation(moduleName="人员管理",option="添加用户")  
     public void addUser(String name) {  
         System.out.println("UserManagerApplogicImpl_add a User!Name is "+name);  
     }  
 }  


