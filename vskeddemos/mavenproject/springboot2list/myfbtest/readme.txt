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