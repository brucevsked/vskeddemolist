/*
 Navicat Premium Data Transfer

 Source Server         : 10.0.193.11_mysql5_3306
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 10.0.193.11:3306
 Source Schema         : jatjfinaladmin

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 10/05/2023 11:04:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账号编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '账号名称',
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '账号密码',
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '账号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `account` VALUES (2, 'user1', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `account` VALUES (3, 'user2', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `account` VALUES (4, 'user4', 'e10adc3949ba59abbe56e057f20f883e', 0);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '资源名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '资源URL',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '图标',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '资源标识 0 目录 1 菜单 2 按钮',
  `sequence` int(11) NULL DEFAULT 99 COMMENT '顺序',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '资源的上一级',
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '系统管理', '', 'el-icon-lx-settings', '0', 2, NULL, 0);
INSERT INTO `resource` VALUES (2, '菜单', 'resourceList', 'el-icon-lx-sort', '1', 3, 1, 0);
INSERT INTO `resource` VALUES (3, '角色', 'roleList', 'el-icon-lx-group', '1', 4, 1, 0);
INSERT INTO `resource` VALUES (4, '用户', 'userList', 'el-icon-lx-people', '1', 5, 1, 0);
INSERT INTO `resource` VALUES (5, '测试菜单1级', '/testmenu1', 'el-icon-lx-mobile', '0', 6, NULL, 0);
INSERT INTO `resource` VALUES (6, '测试菜单2级', '/testmenu2', 'el-icon-lx-voice', '0', 7, 5, 0);
INSERT INTO `resource` VALUES (7, '测试菜单3级', '/testmenu3', 'el-icon-lx-servicefill', '1', 8, 6, 0);
INSERT INTO `resource` VALUES (8, '权限测试1级', '/t1', 'el-icon-lx-like', '0', 9, NULL, 0);
INSERT INTO `resource` VALUES (9, '权限测试2级', '/t2', 'el-icon-lx-favor', '0', 10, 8, 0);
INSERT INTO `resource` VALUES (10, '权限测试3级', '/t3', 'el-icon-lx-tagfill', '1', 11, 9, 0);
INSERT INTO `resource` VALUES (11, '首页', 'dashboard', 'el-icon-lx-home', '1', 1, NULL, 0);
INSERT INTO `resource` VALUES (12, '图标列表', 'icon', 'el-icon-lx-pic', '1', 12, 9, 0);
INSERT INTO `resource` VALUES (13, 'a', 'b', '', '0', 0, NULL, 0);
INSERT INTO `resource` VALUES (14, 'b', 'b', '', '0', 0, NULL, 0);
INSERT INTO `resource` VALUES (15, 'c', 'b', '', '1', 2, NULL, 0);
INSERT INTO `resource` VALUES (16, 'd', 'b', '', '0', 0, NULL, 0);
INSERT INTO `resource` VALUES (17, 'e', '', '', '0', 0, 1, 0);
INSERT INTO `resource` VALUES (18, 'f', '', '', '0', 0, 5, 0);
INSERT INTO `resource` VALUES (19, 'g', '', '', '1', 6, 1, 0);
INSERT INTO `resource` VALUES (20, 'h1', 'h2', '', '2', 98, 13, 0);
INSERT INTO `resource` VALUES (21, 'ia1a', 'ia2b', 'ia3c', '2', 15, 1, 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `descript` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '角色描述',
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '最大的权限', 0);
INSERT INTO `role` VALUES (2, '普通用户', '', 0);
INSERT INTO `role` VALUES (3, '测试权限', '', 0);
INSERT INTO `role` VALUES (4, 'a', '', 0);
INSERT INTO `role` VALUES (5, 'b', '', 0);
INSERT INTO `role` VALUES (6, 'c', '', 0);
INSERT INTO `role` VALUES (8, '主角', '强大的人', 0);
INSERT INTO `role` VALUES (9, 'e', 'e2', 0);
INSERT INTO `role` VALUES (10, 'f', 'f1', 0);
INSERT INTO `role` VALUES (11, 'g', 'g2', 0);

-- ----------------------------
-- Table structure for roleResource
-- ----------------------------
DROP TABLE IF EXISTS `roleResource`;
CREATE TABLE `roleResource`  (
  `roleId` int(11) NOT NULL,
  `resId` int(11) NOT NULL,
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`roleId`, `resId`) USING BTREE,
  INDEX `fk6`(`resId`) USING BTREE,
  CONSTRAINT `fk5` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk6` FOREIGN KEY (`resId`) REFERENCES `resource` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roleResource
-- ----------------------------
INSERT INTO `roleResource` VALUES (1, 1, 0);
INSERT INTO `roleResource` VALUES (1, 2, 0);
INSERT INTO `roleResource` VALUES (1, 3, 0);
INSERT INTO `roleResource` VALUES (1, 4, 0);
INSERT INTO `roleResource` VALUES (1, 5, 0);
INSERT INTO `roleResource` VALUES (1, 6, 0);
INSERT INTO `roleResource` VALUES (1, 7, 0);
INSERT INTO `roleResource` VALUES (1, 11, 0);
INSERT INTO `roleResource` VALUES (1, 12, 0);
INSERT INTO `roleResource` VALUES (2, 1, 0);
INSERT INTO `roleResource` VALUES (2, 2, 0);
INSERT INTO `roleResource` VALUES (2, 3, 0);
INSERT INTO `roleResource` VALUES (2, 4, 0);
INSERT INTO `roleResource` VALUES (2, 11, 0);
INSERT INTO `roleResource` VALUES (2, 12, 0);
INSERT INTO `roleResource` VALUES (3, 8, 0);
INSERT INTO `roleResource` VALUES (3, 9, 0);
INSERT INTO `roleResource` VALUES (3, 10, 0);
INSERT INTO `roleResource` VALUES (3, 11, 0);
INSERT INTO `roleResource` VALUES (3, 12, 0);
INSERT INTO `roleResource` VALUES (8, 13, 0);
INSERT INTO `roleResource` VALUES (8, 14, 0);
INSERT INTO `roleResource` VALUES (8, 15, 0);
INSERT INTO `roleResource` VALUES (9, 1, 0);
INSERT INTO `roleResource` VALUES (9, 2, 0);
INSERT INTO `roleResource` VALUES (9, 3, 0);
INSERT INTO `roleResource` VALUES (9, 4, 0);
INSERT INTO `roleResource` VALUES (9, 5, 0);
INSERT INTO `roleResource` VALUES (9, 6, 0);
INSERT INTO `roleResource` VALUES (9, 7, 0);
INSERT INTO `roleResource` VALUES (9, 8, 0);
INSERT INTO `roleResource` VALUES (9, 9, 0);
INSERT INTO `roleResource` VALUES (9, 10, 0);
INSERT INTO `roleResource` VALUES (9, 11, 0);
INSERT INTO `roleResource` VALUES (9, 12, 0);
INSERT INTO `roleResource` VALUES (9, 13, 0);
INSERT INTO `roleResource` VALUES (9, 14, 0);
INSERT INTO `roleResource` VALUES (9, 15, 0);
INSERT INTO `roleResource` VALUES (9, 16, 0);
INSERT INTO `roleResource` VALUES (9, 17, 0);
INSERT INTO `roleResource` VALUES (9, 18, 0);
INSERT INTO `roleResource` VALUES (9, 19, 0);
INSERT INTO `roleResource` VALUES (9, 20, 0);
INSERT INTO `roleResource` VALUES (9, 21, 0);
INSERT INTO `roleResource` VALUES (10, 11, 0);
INSERT INTO `roleResource` VALUES (10, 14, 0);
INSERT INTO `roleResource` VALUES (10, 15, 0);
INSERT INTO `roleResource` VALUES (10, 16, 0);
INSERT INTO `roleResource` VALUES (11, 11, 0);
INSERT INTO `roleResource` VALUES (11, 14, 0);
INSERT INTO `roleResource` VALUES (11, 16, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户名称',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '用户状态(0正常1停用)',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户手机号',
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '超管员', 0, '18888888888', 0);
INSERT INTO `user` VALUES (2, '用户1', 0, '18888888880', 0);
INSERT INTO `user` VALUES (3, '用户3', 0, '13333331113', 0);
INSERT INTO `user` VALUES (4, '用户4', 0, '18811115515', 0);

-- ----------------------------
-- Table structure for userAccount
-- ----------------------------
DROP TABLE IF EXISTS `userAccount`;
CREATE TABLE `userAccount`  (
  `userId` int(11) NOT NULL COMMENT '用户编号',
  `accountId` int(11) NOT NULL COMMENT '账号编号',
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`userId`, `accountId`) USING BTREE,
  INDEX `fk2`(`accountId`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk2` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户账号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userAccount
-- ----------------------------
INSERT INTO `userAccount` VALUES (1, 1, 0);
INSERT INTO `userAccount` VALUES (2, 2, 0);
INSERT INTO `userAccount` VALUES (3, 3, 0);
INSERT INTO `userAccount` VALUES (4, 4, 0);

-- ----------------------------
-- Table structure for userRole
-- ----------------------------
DROP TABLE IF EXISTS `userRole`;
CREATE TABLE `userRole`  (
  `userId` int(11) NOT NULL COMMENT '用户编号',
  `roleId` int(11) NOT NULL COMMENT '角色编号',
  `isDel` int(1) NULL DEFAULT 0 COMMENT '0未删除  1已删除',
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `fk4`(`roleId`) USING BTREE,
  CONSTRAINT `fk3` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk4` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userRole
-- ----------------------------
INSERT INTO `userRole` VALUES (1, 1, 0);
INSERT INTO `userRole` VALUES (1, 3, 0);
INSERT INTO `userRole` VALUES (2, 2, 0);
INSERT INTO `userRole` VALUES (2, 3, 0);
INSERT INTO `userRole` VALUES (3, 1, 0);
INSERT INTO `userRole` VALUES (3, 9, 0);
INSERT INTO `userRole` VALUES (3, 10, 1);
INSERT INTO `userRole` VALUES (3, 11, 1);
INSERT INTO `userRole` VALUES (4, 1, 0);
INSERT INTO `userRole` VALUES (4, 2, 0);
INSERT INTO `userRole` VALUES (4, 3, 0);
INSERT INTO `userRole` VALUES (4, 4, 0);
INSERT INTO `userRole` VALUES (4, 5, 0);
INSERT INTO `userRole` VALUES (4, 6, 0);

SET FOREIGN_KEY_CHECKS = 1;
