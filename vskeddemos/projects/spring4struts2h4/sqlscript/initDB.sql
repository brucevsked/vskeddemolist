
------------------------------------

create database spring4struts2h4db;

use spring4struts2h4db;
------------------------------------
drop table loginT;        --1

------------------------------------


--==============================================================
-- Table1: loginT 
--==============================================================
drop table loginT;
CREATE TABLE loginT
(
LogInUserID varchar(255) PRIMARY KEY , 
LogInEmail varchar(255),
LogInLogTime datetime, 
LogInPassWord varchar(255), 
LogInRole varchar(255), 
LogInUserName varchar(255)
);

insert into loginT(LogInUserID,LogInEmail,LogInLogTime,LogInPassWord,LogInRole,LogInUserName) values('admin','admin@aa.com',now(),'admin','root','admin');

select * from loginT;