CREATE USER 'springsecurity6rbac'@'%' IDENTIFIED BY 'springsecurity6rbac';

CREATE DATABASE `springsecurity6rbac` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on `springsecurity6rbac`.* to 'springsecurity6rbac'@'%' ;