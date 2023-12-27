/*
 Navicat Premium Data Transfer

 Source Server         : 10.0.193.11_mysql5_3306
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 10.0.193.11:3306
 Source Schema         : mybatis_plus1

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 12/07/2023 11:03:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin');
INSERT INTO `user` VALUES (2, 'user1');

SET FOREIGN_KEY_CHECKS = 1;
