
/**
 *this code by vsk
 *create 201702191550
 *lastModify 201702191550
 *任何人有字段修改需要在注释与本头部进行声明！
*/

use shirorestful;

/********+*********+*********+*********+*********+*********+*/

/**  公共删除表区，为防止外键冲突,按建表顺序倒序排列  **/

/********+*********+*********+*********+*********+*********+*/

/**  建表区  **/

/**  字段说明区  **/

/**  约束创建区  **/

/**  高耦合初始化数据区，当数据与本初始化耦合度不高时另起脚本initData.sql来进行数据初始化  **/

/**  数据查询区  **/

/********+*********+*********+*********+*********+*********+*/
DROP TABLE IF EXISTS `sysFunctionT`;
DROP TABLE IF EXISTS `sysRolePermissionT`;
DROP TABLE IF EXISTS `sysUserRoleT`;
DROP TABLE IF EXISTS `sysRoleT`;
DROP TABLE IF EXISTS `sysPermissionT`;
DROP TABLE IF EXISTS `sysUserT`;
/********+*********+*********+*********+*********+*********+*/

-- ----------------------------
-- Table structure for sysUserT 用户表
-- ----------------------------
CREATE TABLE `sysUserT` (
  `suId` varchar(64) NOT NULL                      COMMENT '用户编号'      ,
  `suName` varchar(64) unique                      COMMENT '用户名'        ,
  `suPass` varchar(64)                             COMMENT '用户密码'      ,
  `suCredits` int(8)                               COMMENT '用户授权暂不用',
  `suMobile` varchar(64)                           COMMENT '用户手机'      ,
  `suNick` varchar(64)                             COMMENT '用户别名'      ,
  `suQq` varchar(64)                               COMMENT '用户QQ'        ,
  `suEmail` varchar(64)                            COMMENT '用户邮箱'      ,
  `suRegTime` timestamp  DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间'  ,
  `suLastIp` varchar(64) DEFAULT NULL              COMMENT '用户最后IP'    ,
  `suLastVisit` timestamp                          COMMENT '最后访问时间'  ,
  PRIMARY KEY (`suId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysUserT
-- ----------------------------

insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000001','admin'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000002','zongjingli'       ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000003','fuzongjingli'     ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000004','ciwuzongjian'     ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000005','xushangzongjingli','670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000006','dajiangyouluguo'  ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000007','test1'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000008','test2'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000009','test3'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000010','test4'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000011','test5'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000012','test6'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000013','test7'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000014','test8'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000015','test9'            ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000016','test10'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000017','test11'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000018','test12'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000019','test13'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000020','test14'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000021','test15'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000022','test16'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000023','test17'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000024','test18'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000025','test19'           ,'670b14728ad9902aecba32e22fa4f6bd');
insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('10000000000000000000000000000026','test20'           ,'670b14728ad9902aecba32e22fa4f6bd');

update `sysUserT` set `suLastVisit`=`suRegTime`;

select * from `sysUserT` ;

/********+*********+*********+*********+*********+*********+*/

-- ----------------------------
-- Table structure for sysPermissionT
-- ----------------------------

CREATE TABLE `sysPermissionT` (
  `spId` varchar(64) NOT NULL                       COMMENT '权限编号',
  `spName` varchar(64) NOT NULL unique              COMMENT '权限名',
  `spNick` varchar(64) NOT NULL                     COMMENT '权限中文名',
  `spAddTime` timestamp DEFAULT CURRENT_TIMESTAMP   COMMENT '添加时间',
  PRIMARY KEY (`spId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysPermissionT
-- ----------------------------


insert into `sysPermissionT`(`spId`,`spName`,`spNick`) VALUES('20000000000000000000000000000001','user:query'  ,'用户列表') ;
insert into `sysPermissionT`(`spId`,`spName`,`spNick`) VALUES('20000000000000000000000000000002','user:add'    ,'用户添加')  ;
insert into `sysPermissionT`(`spId`,`spName`,`spNick`) VALUES('20000000000000000000000000000003','user:update' ,'用户修改') ;
insert into `sysPermissionT`(`spId`,`spName`,`spNick`) VALUES('20000000000000000000000000000004','user:del'    ,'用户删除')  ;


select * from `sysPermissionT`;
/********+*********+*********+*********+*********+*********+*/

-- ----------------------------
-- Table structure for sysRoleT
-- ----------------------------

CREATE TABLE `sysRoleT` (
  `srId` varchar(64) NOT NULL                     COMMENT '角色编号',
  `srName` varchar(64) NOT NULL unique            COMMENT '角色名',
  `srAddTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`srId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysRoleT
-- ----------------------------

insert into `sysRoleT`(`srId`,`srName`) VALUES('30000000000000000000000000000001','超级管理员') ;
insert into `sysRoleT`(`srId`,`srName`) VALUES('30000000000000000000000000000002','总经理')     ;
insert into `sysRoleT`(`srId`,`srName`) VALUES('30000000000000000000000000000003','副总经理')   ;
insert into `sysRoleT`(`srId`,`srName`) VALUES('30000000000000000000000000000004','财务总监')   ;
insert into `sysRoleT`(`srId`,`srName`) VALUES('30000000000000000000000000000005','虚商总经理') ;
insert into `sysRoleT`(`srId`,`srName`) VALUES('30000000000000000000000000000006','打酱油参观') ;


select * from `sysRoleT`;
/********+*********+*********+*********+*********+*********+*/

-- ----------------------------
-- Table structure for `sysUserRoleT`
-- ----------------------------

CREATE TABLE `sysUserRoleT` (
  `suId` varchar(64) NOT NULL                      COMMENT '用户编号',
  `srId` varchar(64) NOT NULL                      COMMENT '角色编号',
  `surAddTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`suId`,`srId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


alter table `sysUserRoleT` add constraint fk_sysUserRoleT_suId foreign key(`suId`) references `sysUserT`(`suId`);
alter table `sysUserRoleT` add constraint fk_sysUserRoleT_srId foreign key(`srId`) references `sysRoleT`(`srId`);

-- ----------------------------
-- Records of `sysUserRoleT`
-- ----------------------------

insert into `sysUserRoleT`(`suId`,`srId`) VALUES('10000000000000000000000000000001','30000000000000000000000000000001') ;
insert into `sysUserRoleT`(`suId`,`srId`) VALUES('10000000000000000000000000000002','30000000000000000000000000000002') ;
insert into `sysUserRoleT`(`suId`,`srId`) VALUES('10000000000000000000000000000003','30000000000000000000000000000003') ;
insert into `sysUserRoleT`(`suId`,`srId`) VALUES('10000000000000000000000000000004','30000000000000000000000000000004') ;
insert into `sysUserRoleT`(`suId`,`srId`) VALUES('10000000000000000000000000000005','30000000000000000000000000000005') ;
insert into `sysUserRoleT`(`suId`,`srId`) VALUES('10000000000000000000000000000006','30000000000000000000000000000006') ;

select * from `sysUserRoleT`;

/********+*********+*********+*********+*********+*********+*/

-- ----------------------------
-- Table structure for sysRolePermissionT
-- ----------------------------

CREATE TABLE `sysRolePermissionT` (
  `srId` varchar(64) NOT NULL                      COMMENT '角色编号',
  `spId` varchar(64) NOT NULL                      COMMENT '权限编号',
  `srpAddTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`srId`,`spId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


alter table `sysRolePermissionT` add constraint fk_sysRolePermissionT_srId foreign key(`srId`) references `sysRoleT`(`srId`)      ;
alter table `sysRolePermissionT` add constraint fk_sysRolePermissionT_spId foreign key(`spId`) references `sysPermissionT`(`spId`);

-- ----------------------------
-- Records of sysRolePermissionT
-- ----------------------------

insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000001','20000000000000000000000000000001') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000001','20000000000000000000000000000002') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000001','20000000000000000000000000000003') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000001','20000000000000000000000000000004') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000002','20000000000000000000000000000001') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000002','20000000000000000000000000000002') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000003','20000000000000000000000000000001') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000004','20000000000000000000000000000001') ;
insert into `sysRolePermissionT`(`srId`,`spId`) VALUES('30000000000000000000000000000005','20000000000000000000000000000001') ;


select * from `sysRolePermissionT`;
/********+*********+*********+*********+*********+*********+*/

-- ----------------------------
-- Table structure for sysfunctiont
-- ----------------------------

CREATE TABLE `sysFunctionT` (
  `sfId` varchar(64) NOT NULL                      COMMENT '权限过滤编号',
  `sfValue` varchar(640)                           COMMENT '权限过滤路径',
  `spId` varchar(64)                               COMMENT '权限编号',
  `srId` varchar(64)                               COMMENT '角色编号',
  `sfType` varchar(64)                             COMMENT '过滤类型',
  `sfAddTime` timestamp  DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`sfId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `sysFunctionT` add constraint fk_sysFunctionT_spId foreign key(`spId`) references `sysPermissionT`(`spId`);
alter table `sysFunctionT` add constraint fk_sysFunctionT_srId foreign key(`srId`) references `sysRoleT`(`srId`)      ;

-- ----------------------------
-- Records of sysFunctionT
-- ----------------------------

insert into `sysFunctionT`(`sfId`,`sfValue`,`spId`,`srId`,`sfType`) VALUES('40000000000000000000000000000001','/login.html'        ,null                              ,null,'anon')  ;
insert into `sysFunctionT`(`sfId`,`sfValue`,`spId`,`srId`,`sfType`) VALUES('40000000000000000000000000000002','/user/list.html'    ,'20000000000000000000000000000001',null,'perms') ;
insert into `sysFunctionT`(`sfId`,`sfValue`,`spId`,`srId`,`sfType`) VALUES('40000000000000000000000000000003','/user/add.html'     ,'20000000000000000000000000000002',null,'perms') ;
insert into `sysFunctionT`(`sfId`,`sfValue`,`spId`,`srId`,`sfType`) VALUES('40000000000000000000000000000004','/user/edit.html'    ,'20000000000000000000000000000003',null,'perms') ;
insert into `sysFunctionT`(`sfId`,`sfValue`,`spId`,`srId`,`sfType`) VALUES('40000000000000000000000000000005','/user/del.html'     ,'20000000000000000000000000000004',null,'perms') ;
insert into `sysFunctionT`(`sfId`,`sfValue`,`spId`,`srId`,`sfType`) VALUES('40000000000000000000000000000006','/test.html'         ,'20000000000000000000000000000001',null,'roles') ;

select * from `sysFunctionT`;
/********+*********+*********+*********+*********+*********+*/