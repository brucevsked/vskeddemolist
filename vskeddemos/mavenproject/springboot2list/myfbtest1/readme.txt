本项目示例实现了前后端分离开发测试

后端地址
http://localhost:9010/apia/v1/user/list
前端地址
http://localhost:8080/front/templates/SysUserList.html

测试前后端分离项目

后端myfbtestback
springboot2.17+spring+springmvc

前端myfbtestfront
static存放js与css
templates存放html
html+js+css


本示例用来测试前后端分离
用户列表
------------------------------------------------------------
使用方法
第一步创建数据库

/********+*********+*********+*********+*********+*********+*/
drop table if exists sysPermissionT;

create table sysPermissionT(
syspermissionid varchar(32)  primary key          ,
syspermissionname varchar(64) not null            ,
syspermissioncode varchar(64) not null            ,
syspermissionuri varchar(256)
);

comment on table sysPermissionT is '系统权限表';
comment on column sysPermissionT.syspermissionid is '权限编号';


insert into sysPermissionT(syspermissionid,syspermissionname,syspermissioncode,syspermissionuri) VALUES('10000000000000000000000000000001','查看用户列表','user:list','/user/list');
insert into sysPermissionT(syspermissionid,syspermissionname,syspermissioncode,syspermissionuri) VALUES('10000000000000000000000000000002','添加用户数据','user:add','/user/add');
insert into sysPermissionT(syspermissionid,syspermissionname,syspermissioncode,syspermissionuri) VALUES('10000000000000000000000000000003','修改用户数据','user:edit','/user/edit');
insert into sysPermissionT(syspermissionid,syspermissionname,syspermissioncode,syspermissionuri) VALUES('10000000000000000000000000000004','删除用户数据','user:del','/user/del');

select * from sysPermissionT;
/********+*********+*********+*********+*********+*********+*/
drop table if exists sysRoleT;

create table sysRoleT(
sysroleid varchar(32)  primary key          ,
sysrolename varchar(64) not null            ,
sysroledescribe varchar(64)
);

comment on table sysRoleT is '系统角色表';
comment on column sysRoleT.sysroleid is '角色编号';


insert into sysRoleT(sysroleid,sysrolename,sysroledescribe) VALUES('20000000000000000000000000000001','超级管理员','最大权限');
insert into sysRoleT(sysroleid,sysrolename,sysroledescribe) VALUES('20000000000000000000000000000002','普通管理员','2级权限');
insert into sysRoleT(sysroleid,sysrolename,sysroledescribe) VALUES('20000000000000000000000000000003','普通用户','3级权限');

select * from sysRoleT;
/********+*********+*********+*********+*********+*********+*/
drop table if exists sysRolePermissionT;

create table sysRolePermissionT(
sysrolepermissionid varchar(32)  primary key ,
sysroleid varchar(32) not null            ,
syspermissionid varchar(32) not null
);

comment on table sysRolePermissionT is '系统角色权限表';

insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000001','20000000000000000000000000000001','10000000000000000000000000000001');
insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000002','20000000000000000000000000000001','10000000000000000000000000000002');
insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000003','20000000000000000000000000000001','10000000000000000000000000000003');
insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000004','20000000000000000000000000000001','10000000000000000000000000000004');

insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000005','20000000000000000000000000000002','10000000000000000000000000000001');
insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000006','20000000000000000000000000000002','10000000000000000000000000000002');
insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000007','20000000000000000000000000000002','10000000000000000000000000000003');

insert into sysRolePermissionT(sysrolepermissionid,sysroleid,syspermissionid) VALUES('30000000000000000000000000000008','20000000000000000000000000000002','10000000000000000000000000000001');


select * from sysRolePermissionT;
/********+*********+*********+*********+*********+*********+*/
drop table if exists sysUserT ;

create table sysUserT(
sysuserid varchar(32)  primary key                ,
sysusername varchar(64) unique not null           ,
sysuserpwd varchar(64) not null                   ,
sysusermobile varchar(64)                         ,
sysusernick  varchar(64)                          ,
sysusermail varchar(64)                           ,
sysuseraddtime timestamp default CURRENT_TIMESTAMP
);

comment on table sysUserT is '系统用户表';
comment on column sysUserT.sysuserid is '用户编号';


insert into sysUserT(sysuserid,sysusername,sysuserpwd) VALUES('40000000000000000000000000000001','superadmin','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(sysuserid,sysusername,sysuserpwd) VALUES('40000000000000000000000000000002','commonadmin','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(sysuserid,sysusername,sysuserpwd) VALUES('40000000000000000000000000000003','commonuser','670b14728ad9902aecba32e22fa4f6bd');

select * from sysUserT;
/********+*********+*********+*********+*********+*********+*/
drop table if exists sysUserRoleT;

create table sysUserRoleT(
sysuserroleid varchar(32)  primary key ,
sysuserid varchar(32) not null         ,
sysroleid varchar(32) not null
);

comment on table sysUserRoleT is '系统用户角色表';

insert into sysUserRoleT(sysuserroleid,sysuserid,sysroleid) VALUES('50000000000000000000000000000001','40000000000000000000000000000001','20000000000000000000000000000001');
insert into sysUserRoleT(sysuserroleid,sysuserid,sysroleid) VALUES('50000000000000000000000000000002','40000000000000000000000000000002','20000000000000000000000000000002');
insert into sysUserRoleT(sysuserroleid,sysuserid,sysroleid) VALUES('50000000000000000000000000000003','40000000000000000000000000000003','20000000000000000000000000000003');

select * from sysUserRoleT;
/********+*********+*********+*********+*********+*********+*/


第二步修改数据库连接
后端myfbtestback/src/main/resources/application.yml

第三步启动后端api
后端myfbtestback/
com.vsked.Application

第四步准备前端资源
复制前端myfbtestfront项目中resources目录中front到tomcat的webapp目录
并修改请求后台地址
front/static/js/project/manager/user/sysUserList.js

第五步启动前台tomcat
第六步访问前端地址
http://localhost:8080/front/templates/SysUserList.html