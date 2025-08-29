/*
 Navicat Premium Dump SQL

 Source Server         : Mysql_root_localhost
 Source Server Type    : MySQL
 Source Server Version : 80404 (8.4.4)
 Source Host           : localhost:3306
 Source Schema         : springboot3datajpa

 Target Server Type    : MySQL
 Target Server Version : 80404 (8.4.4)
 File Encoding         : 65001

 Date: 29/08/2025 16:44:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a1
-- ----------------------------
DROP TABLE IF EXISTS `a1`;
CREATE TABLE `a1`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a1
-- ----------------------------
INSERT INTO `a1` VALUES (1, 'aaa1');
INSERT INTO `a1` VALUES (2, 'aaa2');
INSERT INTO `a1` VALUES (3, 'aaa3');
INSERT INTO `a1` VALUES (4, 'aaa4');
INSERT INTO `a1` VALUES (5, 'aaa5');

-- ----------------------------
-- Table structure for a1b1
-- ----------------------------
DROP TABLE IF EXISTS `a1b1`;
CREATE TABLE `a1b1`  (
  `a1id` bigint NOT NULL,
  `b1id` bigint NOT NULL,
  `isdel` tinyint(1) NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `deltime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`a1id`, `b1id`) USING BTREE,
  INDEX `b1fk1`(`b1id` ASC) USING BTREE,
  CONSTRAINT `a1fk1` FOREIGN KEY (`a1id`) REFERENCES `a1` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b1fk1` FOREIGN KEY (`b1id`) REFERENCES `b1` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a1b1
-- ----------------------------
INSERT INTO `a1b1` VALUES (1, 1, 0, '2025-08-29 16:25:44', NULL);
INSERT INTO `a1b1` VALUES (2, 2, 0, '2025-08-29 16:25:51', NULL);
INSERT INTO `a1b1` VALUES (3, 3, 0, '2025-08-29 16:25:57', NULL);
INSERT INTO `a1b1` VALUES (4, 4, 1, '2025-08-29 16:41:00', NULL);

-- ----------------------------
-- Table structure for b1
-- ----------------------------
DROP TABLE IF EXISTS `b1`;
CREATE TABLE `b1`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b1
-- ----------------------------
INSERT INTO `b1` VALUES (1, 'bbb1');
INSERT INTO `b1` VALUES (2, 'bbb2');
INSERT INTO `b1` VALUES (3, 'bbb3');
INSERT INTO `b1` VALUES (4, 'bb4');
INSERT INTO `b1` VALUES (5, 'bbbb5');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int NOT NULL,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `upass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `ubirth` date NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
