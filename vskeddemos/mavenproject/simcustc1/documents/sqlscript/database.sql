
/**
 *this code by vsk
 *create 201704261019
 *lastModify 201704261019
 *任何人有字段修改需要在注释与本头部进行声明！
*/

/********+*********+*********+*********+*********+*********+*/

/**  公共删除表区，为防止外键冲突,按建表顺序倒序排列  **/

/********+*********+*********+*********+*********+*********+*/

/**  建表区  **/

/**  字段说明区  **/

/**  约束创建区  **/

/**  高耦合初始化数据区，当数据与本初始化耦合度不高时另起脚本initData.sql来进行数据初始化  **/

/**  数据查询区  **/

/********+*********+*********+*********+*********+*********+*/
drop table sysRoleMenuT;
drop table sysFunctionT ;
drop table sysRolePermissionT ;
drop table sysUserRoleT ;
drop table sysRoleT ;
drop table sysPermissionT ;
drop table sysUserT ;
drop table sysMenuT;
/********+*********+*********+*********+*********+*********+*/

create table sysUserT(
suId nvarchar2(64)  primary key,        --用户编号
suName nvarchar2(640) unique not null,  --用户名
suPass nvarchar2(640) not null,         --密码
suCredits int  ,                        --用户类型  0超级管理员  1总经理 2本公司操作员 3本公司财务  4下家渠道
suMobile nvarchar2(64),                 --用户手机号 
suNick  nvarchar2(64),                  --用户别名 
suQq    nvarchar2(64),                  --用户qq号
suEmail nvarchar2(64),                  --用户邮箱  
suRegTime timestamp default sysdate ,   --注册时间
suLastIp nvarchar2(64) ,                --最后登陆IP
suLastVisit timestamp                   --最后访问时间
);

comment on table  sysUserT              is '系统用户表'    ;
comment on column sysUserT.suId         is '用户ID'        ;
comment on column sysUserT.suName       is '用户名'        ;
comment on column sysUserT.suPass       is '密码'          ;
comment on column sysUserT.suCredits    is '类型暂不用'    ;
comment on column sysUserT.suMobile     is '手机号'        ;
comment on column sysUserT.suNick       is '别名'          ;
comment on column sysUserT.suQq         is 'qq号'          ;
comment on column sysUserT.suEmail      is '邮箱'          ;
comment on column sysUserT.suRegTime    is '注册时间'      ;
comment on column sysUserT.suLastIp     is '最后登陆IP'    ;
comment on column sysUserT.suLastVisit  is '最后访问时间'  ;

insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000001','admin'            ,'a1','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000002','zongjingli'       ,'a2','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000003','fuzongjingli'     ,'a3','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000004','ciwuzongjian'     ,'a4','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000005','xushangzongjingli','a5','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000006','dajiangyouluguo'  ,'a6','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000007','test1'            ,'a7','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000008','test2'            ,'a8','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000009','test3'            ,'b1','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000010','test4'            ,'b2','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000011','test5'            ,'b3','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000012','test6'            ,'b4','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000013','test7'            ,'b5','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000014','test8'            ,'b6','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000015','test9'            ,'b7','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000016','test10'           ,'b8','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000017','test11'           ,'c1','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000018','test12'           ,'c2','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000019','test13'           ,'c3','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000020','test14'           ,'c4','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000021','test15'           ,'c5','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000022','test16'           ,'c6','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000023','test17'           ,'c7','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000024','test18'           ,'c8','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000025','test19'           ,'c9','670b14728ad9902aecba32e22fa4f6bd');
insert into sysUserT(suId,suName,suNick,suPass) VALUES('10000000000000000000000000000026','test20'           ,'d1','670b14728ad9902aecba32e22fa4f6bd');

select * from sysUserT;

/********+*********+*********+*********+*********+*********+*/

create table sysPermissionT(
spId nvarchar2(64)  primary key,       --权限编号
spName nvarchar2(640) unique not null, --权限名
spNick nvarchar2(640) unique not null, --权限中文名
spAddTime timestamp default sysdate    --添加时间
);

comment on table  sysPermissionT              is '系统权限表'    ;
comment on column sysPermissionT.spId         is '权限ID'        ;
comment on column sysPermissionT.spName       is '权限名'        ;
comment on column sysPermissionT.spNick       is '权限中文名'    ;
comment on column sysPermissionT.spAddTime    is '权限添加时间'  ;


insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000001','userListPage:get'   ,'用户列表页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000002','userListData:post'  ,'用户列表数据')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000003','userAddPage:get'    ,'用户添加页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000004','userAddProc:post'   ,'用户添加处理')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000005','userEditPage:get'   ,'用户修改页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000006','userEditProc:post'  ,'用户修改处理')  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000007','roleListPage:get'   ,'角色列表页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000008','roleListData:post'  ,'角色列表数据')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000009','roleAddPage:get'    ,'角色添加页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000010','roleAddProc:post'   ,'角色添加处理')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000011','roleEditPage:get'   ,'角色修改页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000012','roleEditProc:post'  ,'角色修改处理')  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000013','permissionListPage:get'   ,'权限列表页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000014','permissionListData:post'  ,'权限列表数据')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000015','permissionAddPage:get'    ,'权限添加页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000016','permissionAddProc:post'   ,'权限添加处理')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000017','permissionEditPage:get'   ,'权限修改页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000018','permissionEditProc:post'  ,'权限修改处理')  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000019','functionListPage:get'   ,'功能列表页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000020','functionListData:post'  ,'功能列表数据')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000021','functionAddPage:get'    ,'功能添加页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000022','functionAddProc:post'   ,'功能添加处理')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000023','functionEditPage:get'   ,'功能修改页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000024','functionEditProc:post'  ,'功能修改处理')  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000025','menuListPage:get'   ,'菜单列表页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000026','menuListData:post'  ,'菜单列表数据')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000027','menuAddPage:get'    ,'菜单添加页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000028','menuAddProc:post'   ,'菜单添加处理')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000029','menuEditPage:get'   ,'菜单修改页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000030','menuEditProc:post'  ,'菜单修改处理')  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000031','userRoleListPage:get'   ,'用户角色绑定页'              )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000032','hasSysRoleList:post'    ,'用户角色绑定时已拥有角色列表')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000033','noSysRoleList:post'     ,'用户角色绑定时未拥有角色列表')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000034','userRoleProc:post'      ,'为用户绑定角色处理'          )  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000035','rolePermissionListPage:get'    ,'权限角色绑定页'              )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000036','hasSysRoleListPermission:post' ,'角色权限绑定时已拥有角色列表')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000037','noSysRoleListPermission:post'  ,'角色权限绑定时未拥有角色列表')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000038','rolePermissionProc:post'       ,'为权限绑定角色处理'          )  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000039','userPassPage:get'    ,'密码修改页'            )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000040','userPassProc:post'   ,'密码修改处理'          )  ;

insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000041','carrierListPage:get'   ,'运营商列表页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000042','carrierListData:post'  ,'运营商列表数据')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000043','carrierAddPage:get'    ,'运营商添加页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000044','carrierAddProc:post'   ,'运营商添加处理')  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000045','carrierEditPage:get'   ,'运营商修改页'  )  ;
insert into sysPermissionT(spId,spName,spNick) VALUES('20000000000000000000000000000046','carrierEditProc:post'  ,'运营商修改处理')  ;

select * from sysPermissionT;
/********+*********+*********+*********+*********+*********+*/

create table sysRoleT(
srId nvarchar2(64)  primary key,       --角色编号
srName nvarchar2(640) unique not null, --角色名
srAddTime timestamp default sysdate    --添加时间
);

comment on table  sysRoleT              is '角色表'        ;
comment on column sysRoleT.srId         is '角色ID'        ;
comment on column sysRoleT.srName       is '角色名'        ;
comment on column sysRoleT.srAddTime    is '角色添加时间'  ;


insert into sysRoleT(srId,srName) VALUES('30000000000000000000000000000001','超级管理员') ;
insert into sysRoleT(srId,srName) VALUES('30000000000000000000000000000002','总经理'    ) ;
insert into sysRoleT(srId,srName) VALUES('30000000000000000000000000000003','副总经理'  ) ;
insert into sysRoleT(srId,srName) VALUES('30000000000000000000000000000004','财务总监'  ) ;
insert into sysRoleT(srId,srName) VALUES('30000000000000000000000000000005','虚商总经理') ;
insert into sysRoleT(srId,srName) VALUES('30000000000000000000000000000006','测试角色'  ) ;


select * from sysRoleT;
/********+*********+*********+*********+*********+*********+*/

create table sysUserRoleT(
suId nvarchar2(64) ,                 --用户编号
srId nvarchar2(64) ,                 --角色编号
surAddTime timestamp default sysdate --添加时间
);

comment on table  sysUserRoleT              is '用户角色表'      ;
comment on column sysUserRoleT.suId         is '用户编号'        ;
comment on column sysUserRoleT.srId         is '角色编号'        ;
comment on column sysUserRoleT.surAddTime   is '添加时间'        ;

alter table sysUserRoleT add constraint pk_sysUserRoleT primary key(suId,srId);

alter table sysUserRoleT add constraint fk_sysUserRoleT_suId foreign key(suId) references sysUserT(suId);
alter table sysUserRoleT add constraint fk_sysUserRoleT_srId foreign key(srId) references sysRoleT(srId);

insert into sysUserRoleT(suId,srId) VALUES('10000000000000000000000000000001','30000000000000000000000000000001') ;
insert into sysUserRoleT(suId,srId) VALUES('10000000000000000000000000000002','30000000000000000000000000000002') ;
insert into sysUserRoleT(suId,srId) VALUES('10000000000000000000000000000003','30000000000000000000000000000003') ;
insert into sysUserRoleT(suId,srId) VALUES('10000000000000000000000000000004','30000000000000000000000000000004') ;
insert into sysUserRoleT(suId,srId) VALUES('10000000000000000000000000000005','30000000000000000000000000000005') ;
insert into sysUserRoleT(suId,srId) VALUES('10000000000000000000000000000006','30000000000000000000000000000006') ;

select * from sysUserRoleT;

/********+*********+*********+*********+*********+*********+*/

create table sysRolePermissionT(
srId nvarchar2(64) ,                 --角色编号
spId nvarchar2(64) ,                 --权限编号
srpAddTime timestamp default sysdate --添加时间
);

comment on table  sysRolePermissionT              is '角色权限表'      ;
comment on column sysRolePermissionT.srId         is '角色编号'        ;
comment on column sysRolePermissionT.spId         is '权限编号'        ;
comment on column sysRolePermissionT.srpAddTime   is '添加时间'        ;

alter table sysRolePermissionT add constraint pk_sysRolePermissionT primary key(srId,spId);

alter table sysRolePermissionT add constraint fk_sysRolePermissionT_srId foreign key(srId) references sysRoleT(srId)      ;
alter table sysRolePermissionT add constraint fk_sysRolePermissionT_spId foreign key(spId) references sysPermissionT(spId);

insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000001') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000002') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000003') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000004') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000005') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000006') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000007') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000008') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000009') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000010') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000011') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000012') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000013') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000014') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000015') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000016') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000017') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000018') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000019') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000020') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000021') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000022') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000023') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000024') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000025') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000026') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000027') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000028') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000029') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000030') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000031') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000032') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000033') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000034') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000035') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000036') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000037') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000038') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000039') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000040') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000041') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000042') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000043') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000044') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000045') ;
insert into sysRolePermissionT(srId,spId) VALUES('30000000000000000000000000000001','20000000000000000000000000000046') ;




select * from sysRolePermissionT;
/********+*********+*********+*********+*********+*********+*/

create table sysFunctionT(
sfId nvarchar2(64) primary key,      --权限过滤编号
sfValue nvarchar2(640),              --权限过滤路径
spId nvarchar2(64) ,                 --权限编号
srId nvarchar2(64) ,                 --角色编号
sfType nvarchar2(640),               --过滤类型
sfAddTime timestamp default sysdate  --添加时间
);

comment on table  sysFunctionT              is '权限过滤表'      ;
comment on column sysFunctionT.sfId         is '权限过滤编号'    ;
comment on column sysFunctionT.sfValue      is '权限过滤路径'    ;
comment on column sysFunctionT.spId         is '权限编号'        ;
comment on column sysFunctionT.srId         is '角色编号'        ;
comment on column sysFunctionT.sfType       is '过滤类型'        ;
comment on column sysFunctionT.sfAddTime    is '添加时间'        ;

alter table sysFunctionT add constraint fk_sysFunctionT_spId foreign key(spId) references sysPermissionT(spId);
alter table sysFunctionT add constraint fk_sysFunctionT_srId foreign key(srId) references sysRoleT(srId)      ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000001','login'                        ,null                              ,null,'anon'   ) ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000002','/userListPage'                ,'20000000000000000000000000000001',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000003','/userListData'                ,'20000000000000000000000000000002',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000004','/userAddPage'                 ,'20000000000000000000000000000003',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000005','/userAddProc'                 ,'20000000000000000000000000000004',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000006','/userEditPage'                ,'20000000000000000000000000000005',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000007','/userEditProc'                ,'20000000000000000000000000000006',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000008','/roleListPage'                ,'20000000000000000000000000000007',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000009','/roleListData'                ,'20000000000000000000000000000008',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000010','/roleAddPage'                 ,'20000000000000000000000000000009',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000011','/roleAddProc'                 ,'20000000000000000000000000000010',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000012','/roleEditPage'                ,'20000000000000000000000000000011',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000013','/roleEditProc'                ,'20000000000000000000000000000012',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000014','/permissionListPage'          ,'20000000000000000000000000000013',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000015','/permissionListData'          ,'20000000000000000000000000000014',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000016','/permissionAddPage'           ,'20000000000000000000000000000015',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000017','/permissionAddProc'           ,'20000000000000000000000000000016',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000018','/permissionEditPage'          ,'20000000000000000000000000000017',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000019','/permissionEditProc'          ,'20000000000000000000000000000018',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000020','/functionListPage'            ,'20000000000000000000000000000019',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000021','/functionListData'            ,'20000000000000000000000000000020',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000022','/functionAddPage'             ,'20000000000000000000000000000021',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000023','/functionAddProc'             ,'20000000000000000000000000000022',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000024','/functionEditPage'            ,'20000000000000000000000000000023',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000025','/functionEditProc'            ,'20000000000000000000000000000024',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000026','/menuListPage'            ,'20000000000000000000000000000025',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000027','/menuListData'            ,'20000000000000000000000000000026',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000028','/menuAddPage'             ,'20000000000000000000000000000027',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000029','/menuAddProc'             ,'20000000000000000000000000000028',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000030','/menuEditPage'            ,'20000000000000000000000000000029',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000031','/menuEditProc'            ,'20000000000000000000000000000030',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000032','/userRoleListPage'        ,'20000000000000000000000000000031',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000033','/hasSysRoleList'          ,'20000000000000000000000000000032',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000034','/noSysRoleList'           ,'20000000000000000000000000000033',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000035','/userRoleProc'            ,'20000000000000000000000000000034',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000036','/rolePermissionListPage'    ,'20000000000000000000000000000035',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000037','/hasSysRoleListPermission'  ,'20000000000000000000000000000036',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000038','/noSysRoleListPermission'   ,'20000000000000000000000000000037',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000039','/rolePermissionProc'        ,'20000000000000000000000000000038',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000040','/userPassPage'    ,'20000000000000000000000000000039',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000041','/userPassProc'    ,'20000000000000000000000000000040',null,'cusperm') ;

insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000042','/carrierListPage'            ,'20000000000000000000000000000041',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000043','/carrierListData'            ,'20000000000000000000000000000042',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000044','/carrierAddPage'             ,'20000000000000000000000000000043',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000045','/carrierAddProc'             ,'20000000000000000000000000000044',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000046','/carrierEditPage'            ,'20000000000000000000000000000045',null,'cusperm') ;
insert into sysFunctionT(sfId,sfValue,spId,srId,sfType) VALUES('40000000000000000000000000000047','/carrierEditProc'            ,'20000000000000000000000000000046',null,'cusperm') ;


select * from sysFunctionT;
/********+*********+*********+*********+*********+*********+*/
create table sysMenuT(
smId nvarchar2(64)  primary key,        --菜单编号
smName nvarchar2(640)  not null,        --菜单显示名
smHref nvarchar2(640)          ,        --菜单超链接
smClick nvarchar2(64)          ,        --单击事件
smClass nvarchar2(128)         ,        --样式
smDataOptions nvarchar2(256)   ,        --easyui dataoptions
parentSmId nvarchar2(64)       ,        --父级菜单编号
smAddTime timestamp default sysdate     --添加时间
);

comment on table  sysMenuT               is '系统菜单表'    ;
comment on column sysMenuT.smId          is '菜单编号'      ;
comment on column sysMenuT.smName        is '菜单名称'      ;
comment on column sysMenuT.smHref        is '菜单链接'      ;
comment on column sysMenuT.smClick       is '菜单单击'      ;
comment on column sysMenuT.smClass       is '菜单样式'      ;
comment on column sysMenuT.smDataOptions is '菜单扩展'      ;
comment on column sysMenuT.parentSmId    is '菜单父级'      ;
comment on column sysMenuT.smAddTime     is '添加时间'      ;

alter table sysMenuT add constraint fk_sysMenuT_parentSmId foreign key(parentSmId) references sysMenuT(smId);

insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('1','主页','index',null,'easyui-linkbutton','plain:true',null) ;

insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2'   ,'系统管理','javascript:void(0);',null,'easyui-splitbutton','menu:''#mm1''',null) ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_1' ,'用户列表','javascript:void(0);','userListPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_2' ,'用户添加','javascript:void(0);','userAddPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_3' ,'角色列表','javascript:void(0);','roleListPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_4' ,'角色添加','javascript:void(0);','roleAddPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_5' ,'权限列表','javascript:void(0);','permissionListPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_6' ,'权限添加','javascript:void(0);','permissionAddPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_7' ,'功能列表','javascript:void(0);','functionListPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_8' ,'功能添加','javascript:void(0);','functionAddPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_9' ,'菜单列表','javascript:void(0);','menuListPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_10','菜单添加','javascript:void(0);','menuAddPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_11','运营商列表','javascript:void(0);','carrierListPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('2_12','运商商添加','javascript:void(0);','carrierAddPage();',null,null,'2') ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('9'   ,'注销','logout',null,'easyui-linkbutton','plain:true',null) ;
insert into sysMenuT(smId,smName,smHref,smClick,smClass,smDataOptions,parentSmId) VALUES('100' ,'修改密码','javascript:void(0);','myPassPage()','easyui-linkbutton','plain:true',null) ;

select * from sysMenuT;
/********+*********+*********+*********+*********+*********+*/
create table sysRoleMenuT(
srId nvarchar2(64) ,                 --角色编号
smId nvarchar2(64) ,                 --菜单编号
srmAddTime timestamp default sysdate --添加时间
);

comment on table  sysRoleMenuT              is '角色菜单表'      ;
comment on column sysRoleMenuT.srId         is '角色编号'        ;
comment on column sysRoleMenuT.smId         is '菜单编号'        ;
comment on column sysRoleMenuT.srmAddTime   is '添加时间'        ;

alter table sysRoleMenuT add constraint pk_sysRoleMenuT primary key(srId,smId);

alter table sysRoleMenuT add constraint fk_sysRoleMenuT_srId foreign key(srId) references sysRoleT(srId);
alter table sysRoleMenuT add constraint fk_sysRoleMenuT_suId foreign key(smId) references sysMenuT(smId);

insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','1');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_1');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_2');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_3');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_4');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_5');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_6');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_7');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_8');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_9');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_10');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_11');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','2_12');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','9');
insert into sysRoleMenuT(srId,smId) VALUES('30000000000000000000000000000001','100');

select * from sysRoleMenuT;
/********+*********+*********+*********+*********+*********+*/