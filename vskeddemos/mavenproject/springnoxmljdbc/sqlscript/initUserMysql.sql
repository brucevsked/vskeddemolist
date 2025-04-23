
/**
 *this code by vsked
 *create 201612021533
 *lastModify 201612021533
 *任何人有字段修改需要在注释与本头部进行声明！
*/


CREATE USER 'springnoxmljdbc'@'localhost' IDENTIFIED BY 'springnoxmljdbc'; 

CREATE DATABASE springnoxmljdbc DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on springnoxmljdbc.* to 'springnoxmljdbc'@'localhost' ;

use springnoxmljdbc;

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

insert into `sysUserT`(`suId`,`suName`,`suPass`) VALUES('su1','admin'            ,'670b14728ad9902aecba32e22fa4f6bd');

update `sysUserT` set `suLastVisit`=`suRegTime`;

select * from `sysUserT` ;