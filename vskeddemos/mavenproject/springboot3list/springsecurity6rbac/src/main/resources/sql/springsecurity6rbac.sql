/*
 Navicat Premium Dump SQL

 Source Server         : Mysql_root_localhost
 Source Server Type    : MySQL
 Source Server Version : 80404 (8.4.4)
 Source Host           : localhost:3306
 Source Schema         : springsecurity6rbac

 Target Server Type    : MySQL
 Target Server Version : 80404 (8.4.4)
 File Encoding         : 65001

 Date: 19/08/2025 13:46:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sysapi
-- ----------------------------
DROP TABLE IF EXISTS `sysapi`;
CREATE TABLE `sysapi`  (
  `id` bigint NOT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '地址',
  `method` int NOT NULL COMMENT '请求方式0所有1get2post3put4delete5head6options7patch8trace9connect',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态0禁用1启用',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'API接口' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysapi
-- ----------------------------

-- ----------------------------
-- Table structure for sysmenu
-- ----------------------------
DROP TABLE IF EXISTS `sysmenu`;
CREATE TABLE `sysmenu`  (
  `id` bigint NOT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `type` int NULL DEFAULT NULL COMMENT '类型，1目录2菜单3按钮',
  `parentid` bigint NULL DEFAULT NULL COMMENT '上级编号',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件',
  `visible` tinyint NULL DEFAULT 1 COMMENT '是否可见0不可见1可见',
  `isFrame` tinyint NULL DEFAULT 0 COMMENT '是否外链0否1是',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parentid`(`parentid` ASC) USING BTREE,
  CONSTRAINT `sysmenu_ibfk_1` FOREIGN KEY (`parentid`) REFERENCES `sysmenu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysmenu
-- ----------------------------

-- ----------------------------
-- Table structure for syspermission
-- ----------------------------
DROP TABLE IF EXISTS `syspermission`;
CREATE TABLE `syspermission`  (
  `id` bigint NOT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `resourcetype` int NULL DEFAULT NULL COMMENT '类型1API 2菜单, 3页面, 4按钮,5table,6column,7row,8自定义',
  `action` int NULL DEFAULT NULL COMMENT '动作1读2写',
  `resourceid` bigint NULL DEFAULT NULL COMMENT '资源编号',
  `attributejson` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'JSON格式的规则',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of syspermission
-- ----------------------------

-- ----------------------------
-- Table structure for sysrole
-- ----------------------------
DROP TABLE IF EXISTS `sysrole`;
CREATE TABLE `sysrole`  (
  `id` bigint NOT NULL COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysrole
-- ----------------------------
INSERT INTO `sysrole` VALUES (1, '超级管理员', '拥有系统最高权限', 0);
INSERT INTO `sysrole` VALUES (2, '普通用户', '只是一个普通打工人', 0);

-- ----------------------------
-- Table structure for sysrolepermission
-- ----------------------------
DROP TABLE IF EXISTS `sysrolepermission`;
CREATE TABLE `sysrolepermission`  (
  `roleid` bigint NOT NULL COMMENT '角色编号',
  `permissionid` bigint NOT NULL COMMENT '权限编号',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`roleid`, `permissionid`) USING BTREE,
  INDEX `permissionid`(`permissionid` ASC) USING BTREE,
  CONSTRAINT `sysrolepermission_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sysrole` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sysrolepermission_ibfk_2` FOREIGN KEY (`permissionid`) REFERENCES `syspermission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysrolepermission
-- ----------------------------

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser`  (
  `id` bigint NOT NULL COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态0禁用1启用',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES (1, 'admin', '$2a$10$iBHfdqG7.TmMbEnR0FfWGuD3c9lCt6FFfWMR/Spat6UpbbauCvCkS', '18888888888', 1, '2025-08-19 10:45:22', 0);

-- ----------------------------
-- Table structure for sysuserrole
-- ----------------------------
DROP TABLE IF EXISTS `sysuserrole`;
CREATE TABLE `sysuserrole`  (
  `userid` bigint NOT NULL COMMENT '用户编号',
  `roleid` bigint NOT NULL COMMENT '角色编号',
  `isdel` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  PRIMARY KEY (`userid`, `roleid`) USING BTREE,
  INDEX `roleid`(`roleid` ASC) USING BTREE,
  CONSTRAINT `sysuserrole_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `sysuser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sysuserrole_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `sysrole` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysuserrole
-- ----------------------------
INSERT INTO `sysuserrole` VALUES (1, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
