create database testdb;
use testdb;

CREATE TABLE UsersT
(
userId int PRIMARY KEY auto_increment,                 
userName VARCHAR(200) NOT NULL unique,
password VARCHAR(200) NOT NULL,
credits int default 0,
lastIp VARCHAR(20) NOT NULL,
lastVisit TIMESTAMP                       
);

insert into UsersT(userName,password,credits,lastIp,lastVisit) 
values('admin','admin',512,'192.168.168.168',CURRENT_TIMESTAMP);
insert into UsersT(userName,password,credits,lastIp,lastVisit) 
values('admin1','admin1',88885,'192.168.168.169',CURRENT_TIMESTAMP);

CREATE TABLE LoginLogT
(
loginLog int PRIMARY KEY auto_increment,
userId int NOT NULL,                
ip VARCHAR(20),                       
loginDate TIMESTAMP                          
);
