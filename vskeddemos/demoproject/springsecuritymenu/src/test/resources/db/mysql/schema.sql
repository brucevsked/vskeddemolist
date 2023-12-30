DROP TABLE IF EXISTS `user_certificate`;
DROP TABLE IF EXISTS `role_menu`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `menu`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `certificate`;

CREATE TABLE IF NOT EXISTS `menu`
(
    `id`        INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '菜单编号',
    `name`      VARCHAR(100) NOT NULL COMMENT '菜单名称',
    `url`       VARCHAR(200) COMMENT '菜单链接',
    `parent_id` INTEGER UNSIGNED COMMENT '上级菜单编号',
    INDEX (`parent_id`),
    FOREIGN KEY (`parent_id`) REFERENCES `menu` (`id`)
) engine = InnoDB,COMMENT='菜单表';

CREATE TABLE IF NOT EXISTS `role`
(
    `id`       INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '角色编号',
    `name`     VARCHAR(100) COMMENT '角色名称',
    INDEX (`name`)
) engine = InnoDB,COMMENT='角色表';

CREATE TABLE IF NOT EXISTS `role_menu`
(
    `role_id` INTEGER UNSIGNED COMMENT '角色编号',
    `menu_id` INTEGER UNSIGNED COMMENT '菜单编号',
    FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
    FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) engine = InnoDB,COMMENT='角色菜单表';

CREATE TABLE IF NOT EXISTS `user`
(
    `id`                      INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '用户编号',
    `name`                    VARCHAR(100) NOT NULL COMMENT '用户名称',
    `password`                VARCHAR(100) NOT NULL COMMENT '用户密码',
    `account_non_expired`     boolean COMMENT '用户账号是否过期',
    `account_non_lock`        boolean COMMENT '用户账号是否锁定',
    `credentials_non_expired` boolean COMMENT '用户证书是否过期',
    `enable`                  boolean COMMENT '用户是否启用',
    INDEX (`name`)
) engine = InnoDB,COMMENT='用户表';

CREATE TABLE IF NOT EXISTS `user_role`
(
    `user_id` INTEGER UNSIGNED COMMENT '用户编号',
    `role_id` INTEGER UNSIGNED COMMENT '角色编号',
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) engine = InnoDB,COMMENT='用户角色表';

CREATE TABLE IF NOT EXISTS `certificate`
(
    `id`          INTEGER UNSIGNED NOT NULL PRIMARY KEY COMMENT '登录证书编号',
    `expire_time` DATETIME NOT NULL COMMENT '登录证书过期时间',
    INDEX (`expire_time`)
) engine = InnoDB,COMMENT='登录证书表';

CREATE TABLE IF NOT EXISTS `user_certificate`
(
    `user_id`        INTEGER UNSIGNED COMMENT '用户编号',
    `certificate_id` INTEGER UNSIGNED COMMENT '登录证书编号',
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    FOREIGN KEY (`certificate_id`) REFERENCES `certificate` (`id`)
) engine = InnoDB,COMMENT='用户登录证书表';