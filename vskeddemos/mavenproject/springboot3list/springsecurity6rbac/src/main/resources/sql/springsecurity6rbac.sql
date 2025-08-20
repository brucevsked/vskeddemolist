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

 Date: 19/08/2025 17:04:04
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
  `id` bigint NOT NULL COMMENT '菜单ID',
  `parentid` bigint NULL DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称/显示标题 (对应 meta.title)',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由名称 (对应 JSON name)',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由路径 (对应 path)',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件路径 (对应 component)',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '重定向路径 (对应 redirect)',
  `type` int NULL DEFAULT NULL COMMENT '菜单类型 1:目录 2:菜单 3:按钮',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标 (对应 meta.icon)',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态 0:禁用 1:启用',
  `visible` tinyint NULL DEFAULT 1 COMMENT '是否可见 0:不可见 1:可见',
  `isframe` tinyint NULL DEFAULT 0 COMMENT '是否外链 0:否 1:是',
  `alwaysshow` tinyint NULL DEFAULT 0 COMMENT '总是显示根菜单 (对应 meta.alwaysShow)',
  `nocache` tinyint NULL DEFAULT 0 COMMENT '不缓存页面 (对应 meta.noCache)',
  `affix` tinyint NULL DEFAULT 0 COMMENT '固定标签页 (对应 meta.affix)',
  `notagsview` tinyint NULL DEFAULT 0 COMMENT '不在标签页显示 (对应 meta.noTagsView)',
  `hidden` tinyint NULL DEFAULT 0 COMMENT '是否隐藏 (对应 meta.hidden)',
  `canto` tinyint NULL DEFAULT 0 COMMENT '是否可以跳转 (对应 meta.canTo)',
  `showmainroute` tinyint NULL DEFAULT 0 COMMENT '显示主路由 (对应 meta.showMainRoute)',
  `activemenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '侧边栏高亮菜单 (对应 meta.activeMenu)',
  `permission` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限标识 (对应 meta.permission)',
  `titlekey` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '原始标题key (如 router.dashboard)',
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isdeleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除 0:否 1:是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idxparentid`(`parentid` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysmenu
-- ----------------------------
INSERT INTO `sysmenu` VALUES (1, NULL, 'Dashboard', 'Dashboard', '/dashboard', '#', '/dashboard/analysis', 1, 'vi-ant-design:dashboard-filled', 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.dashboard', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (2, 1, 'Analysis', 'Analysis', 'analysis', 'views/Dashboard/Analysis', '', 2, '', 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, '', '[]', 'router.analysis', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (3, 1, 'Workplace', 'Workplace', 'workplace', 'views/Dashboard/Workplace', '', 2, '', 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, '', '[]', 'router.workplace', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (4, NULL, 'ExternalLink', 'ExternalLink', '/external-link', '#', '', 1, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', '', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (5, 4, 'DocumentLink', 'DocumentLink', 'https://element-plus-admin-doc.cn/', '', '', 1, 'vi-clarity:document-solid', 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.document', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (6, NULL, 'Guide', 'Guide', '/guide', '#', '', 1, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', '', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (7, 6, 'GuideDemo', 'GuideDemo', 'index', 'views/Guide/Guide', '', 2, 'vi-cib:telegram-plane', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.guide', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (8, NULL, 'ComponentsDemo', 'ComponentsDemo', '/components', '#', '/components/form/default-form', 1, 'vi-bx:bxs-component', 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.component', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (9, 8, 'Form', 'Form', 'form', '##', '', 1, '', 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.form', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (10, 9, 'DefaultForm', 'DefaultForm', 'default-form', 'views/Components/Form/DefaultForm', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.defaultForm', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (11, 9, 'UseForm', 'UseForm', 'use-form', 'views/Components/Form/UseFormDemo', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'UseForm', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (12, 8, 'TableDemo', 'TableDemo', 'table', '##', '/components/table/default-table', 1, '', 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.table', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (13, 12, 'DefaultTable', 'DefaultTable', 'default-table', 'views/Components/Table/DefaultTable', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.defaultTable', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (14, 12, 'UseTable', 'UseTable', 'use-table', 'views/Components/Table/UseTableDemo', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'UseTable', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (15, 12, 'TreeTable', 'TreeTable', 'tree-table', 'views/Components/Table/TreeTable', '', 2, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'TreeTable', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (16, 12, 'TableImagePreview', 'TableImagePreview', 'table-image-preview', 'views/Components/Table/TableImagePreview', '', 2, '', 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.PicturePreview', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (17, 12, 'TableVideoPreview', 'TableVideoPreview', 'table-video-preview', 'views/Components/Table/TableVideoPreview', '', 2, '', 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.tableVideoPreview', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (18, 12, 'CardTable', 'CardTable', 'card-table', 'views/Components/Table/CardTable', '', 2, '', 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.cardTable', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (19, 8, 'EditorDemo', 'EditorDemo', 'editor-demo', '##', '/components/editor-demo/editor', 1, '', 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.editor', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (20, 19, 'Editor', 'Editor', 'editor', 'views/Components/Editor/Editor', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.richText', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (21, 19, 'JsonEditor', 'JsonEditor', 'json-editor', 'views/Components/Editor/JsonEditor', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.jsonEditor', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (22, 19, 'CodeEditor', 'CodeEditor', 'code-editor', 'views/Components/Editor/CodeEditor', '', 2, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.codeEditor', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (23, 8, 'Search', 'Search', 'search', 'views/Components/Search', '', 2, '', 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.search', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (24, 8, 'Descriptions', 'Descriptions', 'descriptions', 'views/Components/Descriptions', '', 2, '', 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.descriptions', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (25, 8, 'ImageViewer', 'ImageViewer', 'image-viewer', 'views/Components/ImageViewer', '', 2, '', 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.imageViewer', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (26, 8, 'Dialog', 'Dialog', 'dialog', 'views/Components/Dialog', '', 2, '', 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.dialog', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (27, 8, 'Icon', 'Icon', 'icon', 'views/Components/Icon', '', 2, '', 7, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.icon', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (28, 8, 'IconPicker', 'IconPicker', 'icon-picker', 'views/Components/IconPicker', '', 2, '', 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.iconPicker', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (29, 8, 'Echart', 'Echart', 'echart', 'views/Components/Echart', '', 2, '', 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.echart', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (30, 8, 'CountTo', 'CountTo', 'count-to', 'views/Components/CountTo', '', 2, '', 10, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.countTo', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (31, 8, 'Qrcode', 'Qrcode', 'qrcode', 'views/Components/Qrcode', '', 2, '', 11, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.qrcode', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (32, 8, 'Highlight', 'Highlight', 'highlight', 'views/Components/Highlight', '', 2, '', 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.highlight', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (33, 8, 'Infotip', 'Infotip', 'infotip', 'views/Components/Infotip', '', 2, '', 13, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.infotip', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (34, 8, 'InputPassword', 'InputPassword', 'input-password', 'views/Components/InputPassword', '', 2, '', 14, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.inputPassword', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (35, 8, 'Waterfall', 'Waterfall', 'waterfall', 'views/Components/Waterfall', '', 2, '', 15, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.waterfall', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (36, 8, 'ImageCropping', 'ImageCropping', 'image-cropping', 'views/Components/ImageCropping', '', 2, '', 16, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.imageCropping', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (37, 8, 'VideoPlayer', 'VideoPlayer', 'video-player', 'views/Components/VideoPlayer', '', 2, '', 17, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.videoPlayer', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (38, 8, 'Avatars', 'Avatars', 'avatars', 'views/Components/Avatars', '', 2, '', 18, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.avatars', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (39, 8, 'IAgree', 'IAgree', 'i-agree', 'views/Components/IAgree', '', 2, '', 19, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.iAgree', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (40, 8, 'Tree', 'Tree', 'tree', 'views/Components/Tree', '', 2, '', 20, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.tree', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (41, NULL, 'Function', 'Function', '/function', '#', '/function/multipleTabs', 1, 'vi-ri:function-fill', 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.function', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (42, 41, 'MultipleTabs', 'MultipleTabs', 'multipleTabs', 'views/Function/MultipleTabs', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.multipleTabs', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (43, 41, 'MultipleTabsDemo', 'MultipleTabsDemo', 'multiple-tabs-demo/:id', 'views/Function/MultipleTabsDemo', '', 2, '', 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, '', '[]', 'router.details', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (44, 41, 'Request', 'Request', 'request', 'views/Function/Request', '', 2, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.request', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (45, 41, 'Test', 'Test', 'test', 'views/Function/Test', '', 2, '', 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[\"add\", \"edit\", \"delete\"]', 'router.permission', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (46, NULL, 'Hooks', 'Hooks', '/hooks', '#', '/hooks/useWatermark', 1, 'vi-ic:outline-webhook', 5, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'hooks', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (47, 46, 'UseWatermark', 'UseWatermark', 'useWatermark', 'views/hooks/useWatermark', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'useWatermark', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (48, 46, 'UseTagsView', 'UseTagsView', 'useTagsView', 'views/hooks/useTagsView', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'useTagsView', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (49, 46, 'UseValidator', 'UseValidator', 'useValidator', 'views/hooks/useValidator', '', 2, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'useValidator', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (50, 46, 'UseCrudSchemas', 'UseCrudSchemas', 'useCrudSchemas', 'views/hooks/useCrudSchemas', '', 2, '', 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'useCrudSchemas', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (51, 46, 'UseClipboard', 'UseClipboard', 'useClipboard', 'views/hooks/useClipboard', '', 2, '', 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'useClipboard', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (52, 46, 'UseNetwork', 'UseNetwork', 'useNetwork', 'views/hooks/useNetwork', '', 2, '', 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'useNetwork', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (53, NULL, 'Level', 'Level', '/level', '#', '/level/menu1/menu1-1/menu1-1-1', 1, 'vi-carbon:skill-level-advanced', 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.level', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (54, 53, 'Menu1', 'Menu1', 'menu1', '##', '/level/menu1/menu1-1/menu1-1-1', 1, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.menu1', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (55, 54, 'Menu11', 'Menu11', 'menu1-1', '##', '/level/menu1/menu1-1/menu1-1-1', 1, '', 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.menu11', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (56, 55, 'Menu111', 'Menu111', 'menu1-1-1', 'views/Level/Menu111', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.menu111', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (57, 54, 'Menu12', 'Menu12', 'menu1-2', 'views/Level/Menu12', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.menu12', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (58, 53, 'Menu2Demo', 'Menu2Demo', 'menu2', 'views/Level/Menu2', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.menu2', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (59, NULL, 'Example', 'Example', '/example', '#', '/example/example-dialog', 1, 'vi-ep:management', 7, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.example', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (60, 59, 'ExampleDialog', 'ExampleDialog', 'example-dialog', 'views/Example/Dialog/ExampleDialog', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.exampleDialog', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (61, 59, 'ExamplePage', 'ExamplePage', 'example-page', 'views/Example/Page/ExamplePage', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.examplePage', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (62, 59, 'ExampleAdd', 'ExampleAdd', 'example-add', 'views/Example/Page/ExampleAdd', '', 2, '', 2, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, '/example/example-page', '[]', 'router.exampleAdd', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (63, 59, 'ExampleEdit', 'ExampleEdit', 'example-edit', 'views/Example/Page/ExampleEdit', '', 2, '', 3, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, '/example/example-page', '[]', 'router.exampleEdit', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (64, 59, 'ExampleDetail', 'ExampleDetail', 'example-detail', 'views/Example/Page/ExampleDetail', '', 2, '', 4, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, '/example/example-page', '[]', 'router.exampleDetail', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (65, NULL, 'Error', 'Error', '/error', '#', '/error/404', 1, 'vi-ci:error', 8, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.errorPage', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (66, 65, '404Demo', '404Demo', '404-demo', 'views/Error/404', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', '404', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (67, 65, '403Demo', '403Demo', '403-demo', 'views/Error/403', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', '403', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (68, 65, '500Demo', '500Demo', '500-demo', 'views/Error/500', '', 2, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', '500', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (69, NULL, 'Authorization', 'Authorization', '/authorization', '#', '/authorization/user', 1, 'vi-eos-icons:role-binding', 9, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, '', '[]', 'router.authorization', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (70, 69, 'Department', 'Department', 'department', 'views/Authorization/Department/Department', '', 2, '', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.department', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (71, 69, 'User', 'User', 'user', 'views/Authorization/User/User', '', 2, '', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.user', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (72, 69, 'Menu', 'Menu', 'menu', 'views/Authorization/Menu/Menu', '', 2, '', 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.menuManagement', '2025-08-19 15:54:35', 0);
INSERT INTO `sysmenu` VALUES (73, 69, 'Role', 'Role', 'role', 'views/Authorization/Role/Role', '', 2, '', 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, '', '[]', 'router.role', '2025-08-19 15:54:35', 0);

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
INSERT INTO `syspermission` VALUES (1, '菜单权限', 2, 2, 1, '', 0);
INSERT INTO `syspermission` VALUES (2, '菜单权限', 2, 2, 2, '', 0);
INSERT INTO `syspermission` VALUES (3, '菜单权限', 2, 2, 3, '', 0);
INSERT INTO `syspermission` VALUES (4, '菜单权限', 2, 2, 4, '', 0);
INSERT INTO `syspermission` VALUES (5, '菜单权限', 2, 2, 5, '', 0);
INSERT INTO `syspermission` VALUES (6, '菜单权限', 2, 2, 6, '', 0);
INSERT INTO `syspermission` VALUES (7, '菜单权限', 2, 2, 7, '', 0);
INSERT INTO `syspermission` VALUES (8, '菜单权限', 2, 2, 8, '', 0);
INSERT INTO `syspermission` VALUES (9, '菜单权限', 2, 2, 9, '', 0);
INSERT INTO `syspermission` VALUES (10, '菜单权限', 2, 2, 10, '', 0);
INSERT INTO `syspermission` VALUES (11, '菜单权限', 2, 2, 11, '', 0);
INSERT INTO `syspermission` VALUES (12, '菜单权限', 2, 2, 12, '', 0);
INSERT INTO `syspermission` VALUES (13, '菜单权限', 2, 2, 13, '', 0);
INSERT INTO `syspermission` VALUES (14, '菜单权限', 2, 2, 14, '', 0);
INSERT INTO `syspermission` VALUES (15, '菜单权限', 2, 2, 15, '', 0);
INSERT INTO `syspermission` VALUES (16, '菜单权限', 2, 2, 16, '', 0);
INSERT INTO `syspermission` VALUES (17, '菜单权限', 2, 2, 17, '', 0);
INSERT INTO `syspermission` VALUES (18, '菜单权限', 2, 2, 18, '', 0);
INSERT INTO `syspermission` VALUES (19, '菜单权限', 2, 2, 19, '', 0);
INSERT INTO `syspermission` VALUES (20, '菜单权限', 2, 2, 20, '', 0);
INSERT INTO `syspermission` VALUES (21, '菜单权限', 2, 2, 21, '', 0);
INSERT INTO `syspermission` VALUES (22, '菜单权限', 2, 2, 22, '', 0);
INSERT INTO `syspermission` VALUES (23, '菜单权限', 2, 2, 23, '', 0);
INSERT INTO `syspermission` VALUES (24, '菜单权限', 2, 2, 24, '', 0);
INSERT INTO `syspermission` VALUES (25, '菜单权限', 2, 2, 25, '', 0);
INSERT INTO `syspermission` VALUES (26, '菜单权限', 2, 2, 26, '', 0);
INSERT INTO `syspermission` VALUES (27, '菜单权限', 2, 2, 27, '', 0);
INSERT INTO `syspermission` VALUES (28, '菜单权限', 2, 2, 28, '', 0);
INSERT INTO `syspermission` VALUES (29, '菜单权限', 2, 2, 29, '', 0);
INSERT INTO `syspermission` VALUES (30, '菜单权限', 2, 2, 30, '', 0);
INSERT INTO `syspermission` VALUES (31, '菜单权限', 2, 2, 31, '', 0);
INSERT INTO `syspermission` VALUES (32, '菜单权限', 2, 2, 32, '', 0);
INSERT INTO `syspermission` VALUES (33, '菜单权限', 2, 2, 33, '', 0);
INSERT INTO `syspermission` VALUES (34, '菜单权限', 2, 2, 34, '', 0);
INSERT INTO `syspermission` VALUES (35, '菜单权限', 2, 2, 35, '', 0);
INSERT INTO `syspermission` VALUES (36, '菜单权限', 2, 2, 36, '', 0);
INSERT INTO `syspermission` VALUES (37, '菜单权限', 2, 2, 37, '', 0);
INSERT INTO `syspermission` VALUES (38, '菜单权限', 2, 2, 38, '', 0);
INSERT INTO `syspermission` VALUES (39, '菜单权限', 2, 2, 39, '', 0);
INSERT INTO `syspermission` VALUES (40, '菜单权限', 2, 2, 40, '', 0);
INSERT INTO `syspermission` VALUES (41, '菜单权限', 2, 2, 41, '', 0);
INSERT INTO `syspermission` VALUES (42, '菜单权限', 2, 2, 42, '', 0);
INSERT INTO `syspermission` VALUES (43, '菜单权限', 2, 2, 43, '', 0);
INSERT INTO `syspermission` VALUES (44, '菜单权限', 2, 2, 44, '', 0);
INSERT INTO `syspermission` VALUES (45, '菜单权限', 2, 2, 45, '', 0);
INSERT INTO `syspermission` VALUES (46, '菜单权限', 2, 2, 46, '', 0);
INSERT INTO `syspermission` VALUES (47, '菜单权限', 2, 2, 47, '', 0);
INSERT INTO `syspermission` VALUES (48, '菜单权限', 2, 2, 48, '', 0);
INSERT INTO `syspermission` VALUES (49, '菜单权限', 2, 2, 49, '', 0);
INSERT INTO `syspermission` VALUES (50, '菜单权限', 2, 2, 50, '', 0);
INSERT INTO `syspermission` VALUES (51, '菜单权限', 2, 2, 51, '', 0);
INSERT INTO `syspermission` VALUES (52, '菜单权限', 2, 2, 52, '', 0);
INSERT INTO `syspermission` VALUES (53, '菜单权限', 2, 2, 53, '', 0);
INSERT INTO `syspermission` VALUES (54, '菜单权限', 2, 2, 54, '', 0);
INSERT INTO `syspermission` VALUES (55, '菜单权限', 2, 2, 55, '', 0);
INSERT INTO `syspermission` VALUES (56, '菜单权限', 2, 2, 56, '', 0);
INSERT INTO `syspermission` VALUES (57, '菜单权限', 2, 2, 57, '', 0);
INSERT INTO `syspermission` VALUES (58, '菜单权限', 2, 2, 58, '', 0);
INSERT INTO `syspermission` VALUES (59, '菜单权限', 2, 2, 59, '', 0);
INSERT INTO `syspermission` VALUES (60, '菜单权限', 2, 2, 60, '', 0);
INSERT INTO `syspermission` VALUES (61, '菜单权限', 2, 2, 61, '', 0);
INSERT INTO `syspermission` VALUES (62, '菜单权限', 2, 2, 62, '', 0);
INSERT INTO `syspermission` VALUES (63, '菜单权限', 2, 2, 63, '', 0);
INSERT INTO `syspermission` VALUES (64, '菜单权限', 2, 2, 64, '', 0);
INSERT INTO `syspermission` VALUES (65, '菜单权限', 2, 2, 65, '', 0);
INSERT INTO `syspermission` VALUES (66, '菜单权限', 2, 2, 66, '', 0);
INSERT INTO `syspermission` VALUES (67, '菜单权限', 2, 2, 67, '', 0);
INSERT INTO `syspermission` VALUES (68, '菜单权限', 2, 2, 68, '', 0);
INSERT INTO `syspermission` VALUES (69, '菜单权限', 2, 2, 69, '', 0);
INSERT INTO `syspermission` VALUES (70, '菜单权限', 2, 2, 70, '', 0);
INSERT INTO `syspermission` VALUES (71, '菜单权限', 2, 2, 71, '', 0);
INSERT INTO `syspermission` VALUES (72, '菜单权限', 2, 2, 72, '', 0);
INSERT INTO `syspermission` VALUES (73, '菜单权限', 2, 2, 73, '', 0);

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
INSERT INTO `sysrolepermission` VALUES (1, 1, 0);
INSERT INTO `sysrolepermission` VALUES (1, 2, 0);
INSERT INTO `sysrolepermission` VALUES (1, 3, 0);
INSERT INTO `sysrolepermission` VALUES (1, 4, 0);
INSERT INTO `sysrolepermission` VALUES (1, 5, 0);
INSERT INTO `sysrolepermission` VALUES (1, 6, 0);
INSERT INTO `sysrolepermission` VALUES (1, 7, 0);
INSERT INTO `sysrolepermission` VALUES (1, 8, 0);
INSERT INTO `sysrolepermission` VALUES (1, 9, 0);
INSERT INTO `sysrolepermission` VALUES (1, 10, 0);
INSERT INTO `sysrolepermission` VALUES (1, 11, 0);
INSERT INTO `sysrolepermission` VALUES (1, 12, 0);
INSERT INTO `sysrolepermission` VALUES (1, 13, 0);
INSERT INTO `sysrolepermission` VALUES (1, 14, 0);
INSERT INTO `sysrolepermission` VALUES (1, 15, 0);
INSERT INTO `sysrolepermission` VALUES (1, 16, 0);
INSERT INTO `sysrolepermission` VALUES (1, 17, 0);
INSERT INTO `sysrolepermission` VALUES (1, 18, 0);
INSERT INTO `sysrolepermission` VALUES (1, 19, 0);
INSERT INTO `sysrolepermission` VALUES (1, 20, 0);
INSERT INTO `sysrolepermission` VALUES (1, 21, 0);
INSERT INTO `sysrolepermission` VALUES (1, 22, 0);
INSERT INTO `sysrolepermission` VALUES (1, 23, 0);
INSERT INTO `sysrolepermission` VALUES (1, 24, 0);
INSERT INTO `sysrolepermission` VALUES (1, 25, 0);
INSERT INTO `sysrolepermission` VALUES (1, 26, 0);
INSERT INTO `sysrolepermission` VALUES (1, 27, 0);
INSERT INTO `sysrolepermission` VALUES (1, 28, 0);
INSERT INTO `sysrolepermission` VALUES (1, 29, 0);
INSERT INTO `sysrolepermission` VALUES (1, 30, 0);
INSERT INTO `sysrolepermission` VALUES (1, 31, 0);
INSERT INTO `sysrolepermission` VALUES (1, 32, 0);
INSERT INTO `sysrolepermission` VALUES (1, 33, 0);
INSERT INTO `sysrolepermission` VALUES (1, 34, 0);
INSERT INTO `sysrolepermission` VALUES (1, 35, 0);
INSERT INTO `sysrolepermission` VALUES (1, 36, 0);
INSERT INTO `sysrolepermission` VALUES (1, 37, 0);
INSERT INTO `sysrolepermission` VALUES (1, 38, 0);
INSERT INTO `sysrolepermission` VALUES (1, 39, 0);
INSERT INTO `sysrolepermission` VALUES (1, 40, 0);
INSERT INTO `sysrolepermission` VALUES (1, 41, 0);
INSERT INTO `sysrolepermission` VALUES (1, 42, 0);
INSERT INTO `sysrolepermission` VALUES (1, 43, 0);
INSERT INTO `sysrolepermission` VALUES (1, 44, 0);
INSERT INTO `sysrolepermission` VALUES (1, 45, 0);
INSERT INTO `sysrolepermission` VALUES (1, 46, 0);
INSERT INTO `sysrolepermission` VALUES (1, 47, 0);
INSERT INTO `sysrolepermission` VALUES (1, 48, 0);
INSERT INTO `sysrolepermission` VALUES (1, 49, 0);
INSERT INTO `sysrolepermission` VALUES (1, 50, 0);
INSERT INTO `sysrolepermission` VALUES (1, 51, 0);
INSERT INTO `sysrolepermission` VALUES (1, 52, 0);
INSERT INTO `sysrolepermission` VALUES (1, 53, 0);
INSERT INTO `sysrolepermission` VALUES (1, 54, 0);
INSERT INTO `sysrolepermission` VALUES (1, 55, 0);
INSERT INTO `sysrolepermission` VALUES (1, 56, 0);
INSERT INTO `sysrolepermission` VALUES (1, 57, 0);
INSERT INTO `sysrolepermission` VALUES (1, 58, 0);
INSERT INTO `sysrolepermission` VALUES (1, 59, 0);
INSERT INTO `sysrolepermission` VALUES (1, 60, 0);
INSERT INTO `sysrolepermission` VALUES (1, 61, 0);
INSERT INTO `sysrolepermission` VALUES (1, 62, 0);
INSERT INTO `sysrolepermission` VALUES (1, 63, 0);
INSERT INTO `sysrolepermission` VALUES (1, 64, 0);
INSERT INTO `sysrolepermission` VALUES (1, 65, 0);
INSERT INTO `sysrolepermission` VALUES (1, 66, 0);
INSERT INTO `sysrolepermission` VALUES (1, 67, 0);
INSERT INTO `sysrolepermission` VALUES (1, 68, 0);
INSERT INTO `sysrolepermission` VALUES (1, 69, 0);
INSERT INTO `sysrolepermission` VALUES (1, 70, 0);
INSERT INTO `sysrolepermission` VALUES (1, 71, 0);
INSERT INTO `sysrolepermission` VALUES (1, 72, 0);
INSERT INTO `sysrolepermission` VALUES (1, 73, 0);

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
