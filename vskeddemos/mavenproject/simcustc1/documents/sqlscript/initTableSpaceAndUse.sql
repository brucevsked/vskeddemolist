/*
*this script create by vsked
*oracle 12c version
*201704261019
*/

create temporary tablespace simcustc1_temp 
  tempfile 'D:\oracle12c\oradata\ORCL\simcustc1_temp.dbf' 
  size 30M 
  autoextend on 
  next 10M 
  extent management local;
  
 create tablespace simcustc1_data 
  logging 
  datafile 'D:\oracle12c\oradata\ORCL\simcustc1_data.dbf' 
  size 150M 
  autoextend on 
  next 10M 
  extent management local;
  
  
create user simcustc1 identified by simcustc1 default tablespace simcustc1_data  temporary tablespace simcustc1_temp;

grant connect,resource,dba to simcustc1;

ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;