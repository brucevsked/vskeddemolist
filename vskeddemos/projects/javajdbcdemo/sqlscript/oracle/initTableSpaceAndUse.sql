/*
*this script create by vsked
*oracle 12c version
*20150919
*/

create temporary tablespace brucevsked_temp 
  tempfile 'D:\ORACLE12C\ORADATA\ORCL\brucevsked_temp.dbf' 
  size 30M 
  autoextend on 
  next 10M 
  extent management local;
  
 create tablespace brucevsked_data 
  logging 
  datafile 'D:\ORACLE12C\ORADATA\ORCL\brucevsked_data.dbf' 
  size 150M 
  autoextend on 
  next 10M 
  extent management local;
  
  
create user brucevsked identified by Y4yhl9tbf110 default tablespace brucevsked_data  temporary tablespace brucevsked_temp;

grant connect,resource,dba to brucevsked;

------------------------------------------------------------------------------------------
CDB模式创建用户与授权[12c版本新特性或将多个库虚拟为一个库来管理]
  
create user c##brucevsked identified by Y4yhl9tbf110 default tablespace brucevsked_data  temporary tablespace brucevsked_temp;

grant connect,resource,dba to c##brucevsked;