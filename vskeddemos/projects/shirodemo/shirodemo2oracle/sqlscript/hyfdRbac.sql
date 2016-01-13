drop table sysUserT ;
create table sysUserT(
suId varchar2(32)  primary key,
suName varchar2(500) not null,
suPass varchar2(500) not null,
suType number(10), 
suMobile varchar2(50),
suNick  varchar2(50), 
suQq    varchar2(50), 
suRegTime timestamp default sysdate ,
suLastIp varchar2(50),
suLastVisit timestamp
);

comment on table  sysUserT              is '系统用户表'    ;
comment on column sysUserT.suId         is '用户ID'        ;
comment on column sysUserT.suName       is '用户名'        ;
comment on column sysUserT.suPass       is '密码'          ;
comment on column sysUserT.suType       is '类型暂不用'    ;
comment on column sysUserT.suMobile     is '手机号'        ;
comment on column sysUserT.suNick       is '别名'          ;
comment on column sysUserT.suQq         is 'qq号'          ;
comment on column sysUserT.suRegTime    is '注册时间'      ;
comment on column sysUserT.suLastIp     is '最后登陆IP'    ;
comment on column sysUserT.suLastVisit  is '最后访问时间'  ;

drop table sysModuleT;
create table sysModuleT (
smId number(10) ,        
smName varchar2(200),   
smNickName varchar2(200),                 
smCode varchar2(200),                      
smSeq number(10),                          
smIcon varchar2(500),                      
smUrl varchar2(500),                      
isEnable number(1),                        
smLevel number(10),                       
parentSmId number(10),                    
smMemo varchar2(500) 
);

comment on table  sysModuleT              is '模块表'        ;
comment on column sysModuleT.smId         is '模块ID'        ;
comment on column sysModuleT.smName       is '模块名'        ;
comment on column sysModuleT.smNickName   is '模块别名'      ;
comment on column sysModuleT.smCode       is '模块代码'      ;
comment on column sysModuleT.smSeq        is '模块序列'      ;
comment on column sysModuleT.smIcon       is '模块图标'      ;
comment on column sysModuleT.smUrl        is '模块地址'      ;
comment on column sysModuleT.isEnable     is '是否启用'      ;
comment on column sysModuleT.smLevel      is '等级'          ;
comment on column sysModuleT.parentSmId   is '父id'          ;
comment on column sysModuleT.smMemo       is '备忘录'        ;

drop table sysModuleUserT;
create table sysModuleUserT(
smuId varchar2(200) primary key ,
smId number(10),
suId varchar2(200) 
);

comment on table  sysModuleUserT           is '模块用户表'    ;
comment on column sysModuleUserT.smuId     is '模块用户ID'    ;
comment on column sysModuleUserT.smId      is '模块编号'      ;
comment on column sysModuleUserT.suId      is '用户编号'      ;

drop table sysRoleT;
create  table sysRoleT(
srId varchar2(200) primary key,
srName varchar2(200), 
srMemo varchar2(200) 
);

comment on table  sysRoleT             is '角色表'    ;
comment on column sysRoleT.srId        is '角色ID'    ;
comment on column sysRoleT.srName      is '角色名'    ;
comment on column sysRoleT.srMemo      is '角色备注'  ;

drop table sysModuleRoleT;
create table  sysModuleRoleT(
smrId varchar2(200) primary key,
smId number(10),
srId varchar2(200)
);

comment on table  sysModuleRoleT           is '模块角色表'    ;
comment on column sysModuleRoleT.smrId     is '模块角色ID'    ;
comment on column sysModuleRoleT.smId      is '模块编号'      ;
comment on column sysModuleRoleT.srId      is '角色编号'      ;

drop  table  sysRoleUserT;
create table sysRoleUserT(
sruId varchar2(200) primary key,
srId varchar2(200),
suId varchar2(200) 
);

comment on table  sysRoleUserT           is '角色用户表'    ;
comment on column sysRoleUserT.sruId     is '角色用户ID'    ;
comment on column sysRoleUserT.srId      is '角色编号'      ;
comment on column sysRoleUserT.suId      is '用户编号'      ;

drop table sysPermissionT;
create table sysPermissionT(
spId varchar2(200) primary key,
spName varchar2(200),
spOwner number(10),
ownerId varchar2(200),
spType number(10),
spResId varchar2(200),
spState number(10),
spValue varchar2(200),
spAddTime timestamp default sysdate ,
spMemo varchar2(500)
);

comment on table  sysPermissionT           is '授权表'                                               ;
comment on column sysPermissionT.spId      is '授权编号'                                             ;
comment on column sysPermissionT.spName    is '授权名称'                                             ;
comment on column sysPermissionT.spOwner   is '权限拥有者 1角色 2用户'                               ;
comment on column sysPermissionT.ownerId   is '拥有者编号 角色编号或用户编号'                        ;
comment on column sysPermissionT.spType    is '权限类型 1模块 2地区 3机构 4表 5列'                   ;
comment on column sysPermissionT.spResId   is '资源编号 模块编号这里暂只用模块'                      ;
comment on column sysPermissionT.spState   is '权限状态 0禁用 1启用'                                 ;
comment on column sysPermissionT.spValue   is '权限值 0000所有 0001添加 0010修改 0100删除 1000查看'  ;
comment on column sysPermissionT.spAddTime is '添加时间'                                             ;
comment on column sysPermissionT.spMemo    is '权限备注'                                             ;

insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000000','admin'  ,'admin'  );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000001','admin1' ,'admin1' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000002','admin2' ,'admin2' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000003','admin3' ,'admin3' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000004','admin4' ,'admin4' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000005','admin5' ,'admin5' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000006','admin6' ,'admin6' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000007','admin7' ,'admin7' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000008','admin8' ,'admin8' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000009','admin9' ,'admin9' );
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000010','admin10','admin10');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000011','admin11','admin11');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000012','admin12','admin12');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000013','admin13','admin13');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000014','admin14','admin14');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000015','admin15','admin15');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000016','admin16','admin16');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000017','admin17','admin17');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000018','admin18','admin18');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000019','admin19','admin19');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000020','admin20','admin20');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000021','admin21','admin21');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000022','admin22','admin22');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000023','admin23','admin23');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000024','admin24','admin24');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000025','admin25','admin25');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000026','admin26','admin26');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000027','admin27','admin27');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000028','admin28','admin28');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000029','admin29','admin29');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000030','admin30','admin30');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000031','admin31','admin31');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000032','admin32','admin32');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000033','admin33','admin33');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000034','admin34','admin34');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000035','admin35','admin35');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000036','admin36','admin36');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000037','admin37','admin37');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000038','admin38','admin38');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000039','admin39','admin39');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000040','admin40','admin40');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000041','admin41','admin41');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000042','admin42','admin42');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000043','admin43','admin43');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000044','admin44','admin44');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000045','admin45','admin45');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000046','admin46','admin46');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000047','admin47','admin47');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000048','admin48','admin48');
insert into sysUserT(suId,suName,suPass) values('10000000000000000000000000000049','admin49','admin49');

insert into sysModuleT(smId,smName,parentSmId) values('1'    ,' 潜行平台A01'    ,'0'    );                                          
insert into sysModuleT(smId,smName,parentSmId) values('10000',' 进销存子系统'   ,'1'    );                                          
insert into sysModuleT(smId,smName,parentSmId) values('10001',' 订单模块'       ,'10000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('10002',' 采购模块'       ,'10000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('10003',' 库存模块'       ,'10000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('10004',' 出库模块'       ,'10000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('10005',' 报表'           ,'10000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('20000',' 开卡网站'       ,'1'    );                                          
insert into sysModuleT(smId,smName,parentSmId) values('20001',' 身份识别'       ,'20000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('20002',' 联系方式'       ,'20000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('20003',' 开卡数据管理'   ,'20000');                                          
insert into sysModuleT(smId,smName,parentSmId) values('30000',' 商城'           ,'1'    );                                          
insert into sysModuleT(smId,smName,parentSmId) values('40000',' 风控数据'       ,'1'    );                                         
insert into sysModuleT(smId,smName,parentSmId) values('50000',' 客户管理'       ,'1'    );                                         
insert into sysModuleT(smId,smName,parentSmId) values('50001',' 客户信息'       ,'50000');                                         
insert into sysModuleT(smId,smName,parentSmId) values('50002',' 客户维护记录'   ,'50000');                                         
insert into sysModuleT(smId,smName,parentSmId) values('60000',' 无线数据'       ,'1'    );
                                                                                                                                                                   
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000000','1'    ,'10000000000000000000000000000000');
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000001','10000','10000000000000000000000000000001');
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000002','10000','10000000000000000000000000000002');
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000003','10000','10000000000000000000000000000003');
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000004','20000','10000000000000000000000000000002');
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000005','30000','10000000000000000000000000000001');
insert into sysModuleUserT(smuId,smId,suId) values('60000000000000000000000000000006','40000','10000000000000000000000000000001');

insert into sysRoleT(srId,srName) values('20000000000000000000000000000000','平台超级管理员'   );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000001','系统超级管理员'   );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000002','财务总监 '        );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000003','总经理 '          );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000004','副总经理'         );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000005','部门主管'         );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000006','部门副主管'       );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000007','会计'             );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000008','会计主管'         );
insert into sysRoleT(srId,srName) values('20000000000000000000000000000009','客服'             );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000010','客服主管'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000011','店长'             );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000012','后勤'             );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000013','后勤主管'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000014','部门经理'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000015','董事长'           );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000016','销售副总裁'       );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000017','研发主管'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000018','研发总监'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000019','营销总监'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000020','市场总监'         );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000021','人力资源总监'     );
insert into sysRoleT(srId,srName) values('11000000000000000000000000000022','人力资源助理'     );

insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000000','1'    ,'20000000000000000000000000000000');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000001','10000','20000000000000000000000000000001');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000002','10001','20000000000000000000000000000002');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000003','10002','20000000000000000000000000000003');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000004','10003','20000000000000000000000000000004');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000005','10004','20000000000000000000000000000005');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000006','20000','20000000000000000000000000000006');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000007','30000','20000000000000000000000000000007');
insert into sysModuleRoleT(smrId,smId,srId) values('30000000000000000000000000000008','40000','20000000000000000000000000000008');

insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000000','20000000000000000000000000000000','10000000000000000000000000000000');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000001','20000000000000000000000000000001','10000000000000000000000000000001');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000002','20000000000000000000000000000002','10000000000000000000000000000002');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000003','20000000000000000000000000000003','10000000000000000000000000000003');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000004','20000000000000000000000000000004','10000000000000000000000000000002');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000005','20000000000000000000000000000005','10000000000000000000000000000001');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000006','20000000000000000000000000000006','10000000000000000000000000000001');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000007','20000000000000000000000000000007','10000000000000000000000000000004');
insert into sysRoleUserT(sruId,srId,suId) values('40000000000000000000000000000008','20000000000000000000000000000008','10000000000000000000000000000001');

insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000000' ,'使用平台所有系统模块' ,  1  , '20000000000000000000000000000000' , 1 ,'1'    ,'0000' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000001' ,'使用进销存'           ,  1  , '20000000000000000000000000000001' , 1 ,'1000' ,'0001' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000002' ,'使用客户管理系统'     ,  1  , '20000000000000000000000000000002' , 1 ,'5000' ,'0010' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000003' ,'使用开卡网站'         ,  1  , '20000000000000000000000000000003' , 1 ,'2000' ,'0100' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000004' ,'使用a3系统'           ,  1  , '20000000000000000000000000000004' , 1 ,'7000' ,'0000' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000005' ,'使用无线数据'         ,  1  , '20000000000000000000000000000005' , 1 ,'6000' ,'0000' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000006' ,'访问进销存'           ,  2  , '10000000000000000000000000000001' , 1 ,'1000' ,'0000' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000007' ,'访问进销存库存模块'   ,  2  , '10000000000000000000000000000002' , 1 ,'1003' ,'0000' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000008' ,'使用客户管理系统'     ,  2  , '10000000000000000000000000000003' , 1 ,'5000' ,'0000' ,1);
insert into sysPermissionT(spId,spName,spOwner,ownerId,spType,spResId,spValue,spState) values('50000000000000000000000000000009' ,'使用平台所有系统模块' ,  2  , '10000000000000000000000000000001' , 1 ,'1'    ,'0000' ,1);

select * from sysUserT;
select * from sysModuleT;
select * from sysModuleUserT;
select * from sysRoleT;
select * from sysModuleRoleT;
select * from sysRoleUserT;
select * from sysPermissionT;
