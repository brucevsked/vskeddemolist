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