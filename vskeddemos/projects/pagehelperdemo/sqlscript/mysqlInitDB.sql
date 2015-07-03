
------------------------------------建库区

create database pagehelperdb;

use pagehelperdb;
------------------------------------数据清空区
drop table userT;        --1用户表

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

insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa111','aaa111','adminaaa111',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa112','aaa112','adminaaa112',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa113','aaa113','adminaaa113',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa114','aaa114','adminaaa114',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa115','aaa115','adminaaa115',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa116','aaa116','adminaaa116',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa117','aaa117','adminaaa117',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa118','aaa118','adminaaa118',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa119','aaa119','adminaaa119',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa110','aaa110','adminaaa110',now());
insert into userT(userName,userNickName,userPass,lastLoginTime) values('adminaaa121','aaa121','adminaaa121',now());

select * from userT;