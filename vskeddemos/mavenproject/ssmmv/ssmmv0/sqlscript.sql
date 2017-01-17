
CREATE USER 'ssmmv0'@'%' IDENTIFIED BY 'ssmmv0'; 

CREATE DATABASE ssmmv0 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on ssmmv0.* to 'ssmmv0'@'%' ;

use ssmmv0;

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `userinfo`(`username`,`password`) values('admin','admin');

select * from `userinfo`;