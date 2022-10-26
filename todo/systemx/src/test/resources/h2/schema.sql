
DROP TABLE IF EXISTS `platformUserAccount`;
DROP TABLE IF EXISTS `platformUser`;
DROP TABLE IF EXISTS `platformAccount`;

CREATE TABLE IF NOT EXISTS `platformAccount`
(
    `id`             integer PRIMARY KEY,
    `name`    VARCHAR(100),
    `password`       VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `platformUser`
(
    `id`        integer PRIMARY KEY,
    `name`      VARCHAR(100),
    `birthday`  date
);

CREATE TABLE IF NOT EXISTS `platformUserAccount`
(
    `userId`        integer,
    `accountId`     integer,
    primary key (`userId`,`accountId`),
    foreign key (`userId`) references `platformUser`(`id`),
    foreign key (`accountId`) references `platformAccount`(`id`)
) ;