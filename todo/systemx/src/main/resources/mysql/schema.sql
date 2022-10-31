DROP TABLE IF EXISTS `rolePermission`;
DROP TABLE IF EXISTS `permission`;
DROP TABLE IF EXISTS `platformUserRole`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `platformUserAccount`;
DROP TABLE IF EXISTS `platformUser`;
DROP TABLE IF EXISTS `platformAccount`;

CREATE TABLE IF NOT EXISTS `platformAccount`
(
    `id`         integer PRIMARY KEY,
    `name`       VARCHAR(100),
    `password`   VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `platformUser`
(
    `id`        integer PRIMARY KEY,
    `name`      VARCHAR(100),
    `birthday`  date
);

CREATE TABLE IF NOT EXISTS `platformUserAccount`
(
    `userId`    integer,
    `accountId` integer,
    primary key (`userId`,`accountId`),
    foreign key (`userId`)    references `platformUser`(`id`),
    foreign key (`accountId`) references `platformAccount`(`id`)
) ;

CREATE TABLE IF NOT EXISTS `role`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `platformUserRole`
(
    `userId`    integer,
    `roleId`    integer,
    primary key (`userId`,`roleId`),
    foreign key (`userId`) references `platformUser`(`id`),
    foreign key (`roleId`) references `role`(`id`)
) ;

CREATE TABLE IF NOT EXISTS `permission`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `rolePermission`
(
    `roleId`        integer,
    `permissionId`  integer,
    primary key (`roleId`,`permissionId`),
    foreign key (`roleId`)       references `role`(`id`),
    foreign key (`permissionId`) references `permission`(`id`)
) ;


-- 对象名称
CREATE TABLE IF NOT EXISTS `resource`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

-- 对象类型 后台业务对象，前端页面对象,URL地址
CREATE TABLE IF NOT EXISTS `resourceType`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

-- 对象属性
CREATE TABLE IF NOT EXISTS `resourceAttribute`
(
    `id`        integer PRIMARY KEY,
    `name`      VARCHAR(100),
    `dataType`  VARCHAR(100)
);

-- 对象名称+对象类型
CREATE TABLE IF NOT EXISTS `resourceTypeMiddle`
(
    `resourceId`           integer,
    `resourceTypeId`  integer,
    primary key (`resourceId`,`resourceTypeId`),
    foreign key (`resourceId`)          references `resource`(`id`),
    foreign key (`resourceTypeId`) references `resourceType`(`id`)
);


-- 对象名称+对象属性
CREATE TABLE IF NOT EXISTS `resourceAttributeMiddle`
(
    `resourceId`           integer,
    `resourceAttributeId`  integer,
    primary key (`resourceId`,`resourceAttributeId`),
    foreign key (`resourceId`)          references `resource`(`id`),
    foreign key (`resourceAttributeId`) references `resourceAttribute`(`id`)
);

-- 对象动作
CREATE TABLE IF NOT EXISTS `resourceAction`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

-- 对象动作参数
CREATE TABLE IF NOT EXISTS `resourceActionParameter`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

-- 对象名称+对象动作
CREATE TABLE IF NOT EXISTS `resourceActionMiddle`
(
    `resourceId`        integer,
    `resourceActionId`  integer,
    primary key (`resourceId`,`resourceActionId`),
    foreign key (`resourceId`)       references `resource`(`id`),
    foreign key (`resourceActionId`) references `resourceAction`(`id`)
);

-- 对象数据 1全部 2指定数据 3指定属性所有数据 4对象数据属性规则
CREATE TABLE IF NOT EXISTS `resourceData`
(
    `id`    integer PRIMARY KEY,
    `type`  integer,
    `dataIdKey1`  VARCHAR(100),
    `dataIdKey2`  VARCHAR(100),
    `dataIdKey3`  VARCHAR(100)
);

-- 对象数据属性规则
CREATE TABLE IF NOT EXISTS `resourceAttributeDataRule`
(
    `id`    integer PRIMARY KEY,
    `name`  VARCHAR(100)
);

-- 根据对象数据属性规则显示对象数据
CREATE TABLE IF NOT EXISTS `resourceAttributeDataRuleMiddle`
(
    `resourceAttributeId`      integer,
    `resourceAttributeRuleId`  integer
);

-- 操作日志
CREATE TABLE IF NOT EXISTS `operateLog`
(
    `id`    integer PRIMARY KEY,
    `operateId`  VARCHAR(100),
    `resource`  VARCHAR(100),
    `level`  VARCHAR(100),
    `operateMan`  VARCHAR(100),
    `startTime`  VARCHAR(100),
    `endTime`  VARCHAR(100),
    `operateBefore`  VARCHAR(100),
    `operateAfter`  VARCHAR(100),
    `operateResult`  VARCHAR(100)
);

-- 回收站
CREATE TABLE IF NOT EXISTS `recycle`
(
    `id`      integer,
    `time`  VARCHAR(100),
    `operateMan`  VARCHAR(100),
    `columns`  VARCHAR(100),
    `jsonData`  VARCHAR(100)
);