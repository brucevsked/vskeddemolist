
------------------------------------建库区

create database logtestdb;

use logtestdb;
------------------------------------数据清空区
drop table myLogsT;        --1日志表

------------------------------------建表区


--==============================================================
-- Table1: userT 用户表
--==============================================================
CREATE TABLE myLogsT
(
logId int PRIMARY KEY auto_increment,       --编号
userId varchar(200) ,                      --用户id
userName varchar(200) ,                    --用户名
logClass  varchar(200)  ,                  --日志记录类
logMethod varchar(200),                    --方法名
logTime timestamp default CURRENT_TIMESTAMP, --记录时间
logLevel varchar(20),                       --日志级别
logMsg varchar(500)                        --日志内容
);

insert into myLogsT(userId,userName,logClass,logMethod,logTime,logLevel,logMsg) 
values(1,'vsked','UserClass','loginMethod',now(),'error','login error please check userInfo');

select * from myLogsT;