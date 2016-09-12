/*
*this script create by vsked
*oracle 12c version
*201609121111
*/

create temporary tablespace test_temp 
  tempfile 'D:\ORACLE12C\ORADATA\ORCL\test_temp.dbf' 
  size 30M 
  autoextend on 
  next 10M 
  maxsize unlimited 
  extent management local;
  
 create tablespace test_data 
  logging 
  datafile 'D:\ORACLE12C\ORADATA\ORCL\test_data.dbf' 
  size 150M 
  autoextend on 
  next 10M 
  maxsize unlimited 
  extent management local;
  
  
create user test identified by test default tablespace test_data  temporary tablespace test_temp;

grant connect,resource,dba to test;

------------------------------------------------------------------------------------------
CDB模式创建用户与授权[12c版本新特性或将多个库虚拟为一个库来管理]
  
create user c##brucevsked identified by Y4yhl9tbf110 default tablespace brucevsked_data  temporary tablespace brucevsked_temp;

grant connect,resource,dba to c##brucevsked;