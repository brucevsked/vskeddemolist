
------------------------------------建库区

create database jfinaldemo;

use jfinaldemo;
------------------------------------数据清空区
drop table userT;        --1用户表

------------------------------------建表区


--==============================================================
-- Table1: userT 用户表
--==============================================================
CREATE TABLE userT
(
uId int PRIMARY KEY auto_increment,    
uName varchar(200) unique NOT NULL ,
uNick varchar(200) default '', 
uPass  varchar(50) NOT NULL ,
regTime timestamp default CURRENT_TIMESTAMP,
lastLoginTime timestamp                     
);

insert into userT(uName,uNick,uPass,lastLoginTime) values('admin','adminnick','admin','2015-10-09 15:24:19');
insert into userT(uName,uNick,uPass,lastLoginTime) values('admin1','adminnick1','admin1','2015-10-09 15:41:22');

select * from  userT;
                            
                            
--==============================================================
-- Table2: classesT 用户表
--==============================================================
CREATE TABLE classesT
(
cId int PRIMARY KEY auto_increment,    
cName varchar(200) unique NOT NULL ,
cAddr varchar(200) default '' 
);

insert into classesT(cName,cAddr) values('1班','a1');
insert into classesT(cName,cAddr) values('2班','a2');

select * from  classesT;  

--==============================================================
-- Table3: studentT 用户表
--==============================================================
CREATE TABLE studentT
(
sId int PRIMARY KEY auto_increment,    
sName varchar(200)  ,
sAge int ,
sSex varchar(2),
cid int 
);

insert into studentT(sName,sAge,sSex,cid) values('王大牛',18,'男',1);
insert into studentT(sName,sAge,sSex,cid) values('张小美',16,'女',2);

select * from  studentT;                                 