CREATE USER 'mybatisplus'@'%' IDENTIFIED BY 'mybatisplus';

CREATE DATABASE `mybatisplus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on `mybatisplus`.* to 'mybatisplus'@'%' ;