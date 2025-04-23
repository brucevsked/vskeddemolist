CREATE USER 'authorization-example'@'localhost' IDENTIFIED BY 'authorization-example';

CREATE DATABASE `authorization-example` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on `authorization-example`.* to 'authorization-example'@'localhost' ;