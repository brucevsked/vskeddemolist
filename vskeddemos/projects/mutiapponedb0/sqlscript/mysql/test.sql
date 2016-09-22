/*
Navicat MySQL Data Transfer

Source Server         : localmysql56
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-09-22 16:22:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` bigint(10) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'ynp', '111111');

-- ----------------------------
-- Table structure for usertest
-- ----------------------------
DROP TABLE IF EXISTS `usertest`;
CREATE TABLE `usertest` (
  `ids` varchar(64) NOT NULL COMMENT '用户编号',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `userpass` varchar(255) DEFAULT NULL COMMENT '密码',
  `balance` double(16,3) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertest
-- ----------------------------
INSERT INTO `usertest` VALUES ('1user', 'testuser1', 'testuser1', '2110.000');
INSERT INTO `usertest` VALUES ('2user', 'testuser2', 'testuser2', '3000.000');
INSERT INTO `usertest` VALUES ('3user', 'testuser3', 'testuser3', '4000.000');
INSERT INTO `usertest` VALUES ('4user', 'testuser4', 'testuser4', '5000.000');
INSERT INTO `usertest` VALUES ('5user', 'testuser5', 'testuser5', '6000.000');
INSERT INTO `usertest` VALUES ('6user', 'testuser6', 'testuser6', '7000.000');

-- ----------------------------
-- Table structure for usertestrechargehis
-- ----------------------------
DROP TABLE IF EXISTS `usertestrechargehis`;
CREATE TABLE `usertestrechargehis` (
  `ids` varchar(64) NOT NULL COMMENT '记录编号',
  `userids` varchar(64) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `oldbalance` double(16,3) DEFAULT NULL COMMENT '原始金额',
  `money` double(16,3) DEFAULT NULL COMMENT '将要冲扣金额',
  `newbalance` double(16,3) DEFAULT NULL COMMENT '冲扣后金额',
  `opertime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  `type` char(1) DEFAULT NULL COMMENT '操作类型 1系统冲扣',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertestrechargehis
-- ----------------------------
INSERT INTO `usertestrechargehis` VALUES ('a1a1', '1user', 'testuser1', '10.000', '10.000', '20.000', '2016-09-18 09:00:43', '1');
