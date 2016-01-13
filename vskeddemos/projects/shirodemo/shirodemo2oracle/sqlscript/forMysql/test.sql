/*
Navicat MySQL Data Transfer

Source Server         : localmysql56
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-12 11:42:47
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
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `userId` bigint(10) DEFAULT NULL,
  `roleId` bigint(10) DEFAULT NULL,
  KEY `FK_Account_Role` (`roleId`),
  KEY `FK_Account_Role1` (`userId`),
  CONSTRAINT `FK_Account_Role` FOREIGN KEY (`roleId`) REFERENCES `role` (`ID`),
  CONSTRAINT `FK_Account_Role1` FOREIGN KEY (`userId`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `ID` bigint(10) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'read');
INSERT INTO `permission` VALUES ('2', 'write');

-- ----------------------------
-- Table structure for permission_role
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `permissionId` bigint(10) DEFAULT NULL,
  `roleId` bigint(10) DEFAULT NULL,
  KEY `FK_PerMission_Role` (`roleId`),
  KEY `FK_PerMission_Role1` (`permissionId`),
  CONSTRAINT `FK_PerMission_Role` FOREIGN KEY (`roleId`) REFERENCES `role` (`ID`),
  CONSTRAINT `FK_PerMission_Role1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_role
-- ----------------------------
INSERT INTO `permission_role` VALUES ('1', '1');
INSERT INTO `permission_role` VALUES ('2', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` bigint(10) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
