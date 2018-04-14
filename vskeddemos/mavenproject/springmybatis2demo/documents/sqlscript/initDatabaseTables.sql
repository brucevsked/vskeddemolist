/**
 *this code by vsked
 *create 201804141025
 *lastModify 201804141025
 *任何人有字段修改需要在注释与本头部进行声明！
*/

/********+*********+*********+*********+*********+*********+*/
drop table sysUserT ;

create table sysUserT(
suId varchar(64)  primary key                 COMMENT '用户编号',
suName varchar(64) unique not null            COMMENT '用户名'  ,
suPass varchar(64) not null                   COMMENT '密码'    ,
suCredits int                                 COMMENT '用户类型',/*0超级管理员 21客服售前 22客服售后 23其他咨询*/
suMobile varchar(64)                          COMMENT '手机号'  ,
suNick  varchar(64)                           COMMENT '别名'    ,
suQq    varchar(64)                           COMMENT 'qq'      ,
suEmail varchar(64)                           COMMENT '邮箱'    ,
suRegTime timestamp default CURRENT_TIMESTAMP COMMENT '注册时间',
suLastIp varchar(64)                          COMMENT '最后登陆IP',
suLastVisit timestamp                         COMMENT '最后访问时间'
);

insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000001','admin','a1','670b14728ad9902aecba32e22fa4f6bd',0);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000002','hyfdkefu1','a2','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000003','hyfdkefu2','a3','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000004','hyfdkefu3','a4','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000005','hyfdkefu4','a5','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000006','hyfdkefu5','a6','670b14728ad9902aecba32e22fa4f6bd',21);


select * from sysUserT;

