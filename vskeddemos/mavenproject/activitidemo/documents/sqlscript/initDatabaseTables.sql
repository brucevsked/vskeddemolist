/**
 *this code by vsked
 *create 201808251415
 *lastModify 201808251415
 *任何人有字段修改需要在注释与本头部进行声明！
*/

/********+*********+*********+*********+*********+*********+*/
drop table if exists sysUserT ;

create table sysUserT(
suId varchar(32)  primary key                 COMMENT '用户编号',
suName varchar(64) unique not null            COMMENT '用户名'  ,
promocode varchar(64)                         COMMENT '推广码'  ,
suPass varchar(64) not null                   COMMENT '密码'    ,
suCredits int                                 COMMENT '用户类型',/*0超级管理员21普通用户*/
suMobile varchar(64)                          COMMENT '手机号'  ,
suNick  varchar(64)                           COMMENT '别名'    ,
suQq    varchar(64)                           COMMENT 'qq'      ,
suEmail varchar(64)                           COMMENT '邮箱'    ,
suRegTime timestamp default CURRENT_TIMESTAMP COMMENT '注册时间',
suLastIp varchar(64)                          COMMENT '最后登陆IP',
parnetSuId varchar(32)                        COMMENT '上级用户编号',
suLastVisit timestamp                         COMMENT '最后访问时间'
) comment='用户表';

insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000001','admin','a1','670b14728ad9902aecba32e22fa4f6bd',0);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000002','testa1','a2','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000003','testa2','a3','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000004','testa3','a4','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000005','testa4','a5','670b14728ad9902aecba32e22fa4f6bd',21);
insert into sysUserT(suId,suName,suNick,suPass,suCredits) VALUES('10000000000000000000000000000006','testa5','a6','670b14728ad9902aecba32e22fa4f6bd',21);

select * from sysUserT;

