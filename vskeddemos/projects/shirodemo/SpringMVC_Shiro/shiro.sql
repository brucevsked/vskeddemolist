/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2014-10-04 17:08:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'sam', '670b14728ad9902aecba32e22fa4f6bd');
INSERT INTO `t_user` VALUES ('2', 'ding', '670b14728ad9902aecba32e22fa4f6bd');
INSERT INTO `t_user` VALUES ('3', 'baoseed', '670b14728ad9902aecba32e22fa4f6bd');
INSERT INTO `t_user` VALUES ('4', 'jeremie', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL,
  `permissionname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'user:add');
INSERT INTO `t_permission` VALUES ('2', 'user:del');
INSERT INTO `t_permission` VALUES ('3', 'user:update');
INSERT INTO `t_permission` VALUES ('4', 'user:query');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL,
  `rolename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin');
INSERT INTO `t_role` VALUES ('2', 'manager');
INSERT INTO `t_role` VALUES ('3', 'normal');
INSERT INTO `t_role` VALUES ('4', 'user');


-- ----------------------------
-- Table structure for `t_function`
-- ----------------------------
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function` (
  `id` int(11) NOT NULL,
  `value` varchar(50) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_function_role` (`role_id`),
  KEY `fk_function_permission` (`permission_id`),
  CONSTRAINT `fk_function_permission` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`),
  CONSTRAINT `fk_function_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('2', '/login.html', null, null, 'anon');
INSERT INTO `t_function` VALUES ('3', '/user.html', '4', null, 'perms');
INSERT INTO `t_function` VALUES ('4', '/user/add.html', '1', null, 'perms');
INSERT INTO `t_function` VALUES ('5', '/user/del.html', '2', null, 'perms');
INSERT INTO `t_function` VALUES ('6', '/user/edit.html', '3', null, 'perms');
INSERT INTO `t_function` VALUES ('7', '/test.html', null, '4', 'roles');



-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1');
INSERT INTO `t_role_permission` VALUES ('1', '2');
INSERT INTO `t_role_permission` VALUES ('1', '3');
INSERT INTO `t_role_permission` VALUES ('1', '4');
INSERT INTO `t_role_permission` VALUES ('2', '1');
INSERT INTO `t_role_permission` VALUES ('2', '2');
INSERT INTO `t_role_permission` VALUES ('2', '3');
INSERT INTO `t_role_permission` VALUES ('3', '4');
INSERT INTO `t_role_permission` VALUES ('4', '4');
INSERT INTO `t_role_permission` VALUES ('4', '3');


-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `FK_role_user` (`role_id`),
  KEY `FK_user_role` (`user_id`),
  CONSTRAINT `FK_role_user` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('1', '3');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('2', '3');
INSERT INTO `t_user_role` VALUES ('3', '3');
INSERT INTO `t_user_role` VALUES ('4', '4');
