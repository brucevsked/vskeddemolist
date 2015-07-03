
------------------------------------建库区

create database hibernate4demo;

use hibernate4demo;
------------------------------------数据清空区
drop table stockT;        --1股票表

------------------------------------建表区

--==============================================================
-- Table1: userT 用户表
--==============================================================
CREATE TABLE userT
(
userId int PRIMARY KEY auto_increment,       --编号
userName varchar(200) unique NOT NULL ,      --用户名
userNickName varchar(200) default '',        --用户昵称
userPass  varchar(50) NOT NULL ,             --密码
regTime timestamp default CURRENT_TIMESTAMP, --注册时间
lastLoginTime timestamp                      --最后登陆时间
);

--清空数据区域
delete from  userT        ;--1用户表



insert into userT(userName,userNickName,userPass,lastLogintime) values ('player1','player1n','player1',current_timestamp);
insert into userT(userName,userNickName,userPass,lastLogintime) values ('player2','player2n','player2',current_timestamp);
insert into userT(userName,userNickName,userPass,lastLogintime) values ('player3','player3n','player3',current_timestamp);
insert into userT(userName,userNickName,userPass,lastLogintime) values ('player4','player4n','player4',current_timestamp);
insert into userT(userName,userNickName,userPass,lastLogintime) values ('player5','player5n','player5',current_timestamp);
insert into userT(userName,userNickName,userPass,lastLogintime) values ('player6','player6n','player6',current_timestamp);
insert into userT(userName,userNickName,userPass,lastLogintime) values ('player7','player7n','player7',current_timestamp);


select * from userT;
--==============================================================
-- Table2: stockT 股票表
--==============================================================
CREATE TABLE stockT
(
stockId int PRIMARY KEY auto_increment,       --
stockCode varchar(200) unique NOT NULL ,      --
stockName varchar(200) default ''        --
);  