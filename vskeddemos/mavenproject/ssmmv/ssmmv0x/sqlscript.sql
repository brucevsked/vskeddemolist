
CREATE USER 'ssmmv0x'@'%' IDENTIFIED BY 'ssmmv0x'; 

CREATE DATABASE ssmmv0x DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on ssmmv0x.* to 'ssmmv0x'@'%' ;

use ssmmv0x;

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `userinfo`(`username`,`password`) values('admin','admin');

select * from `userinfo`;