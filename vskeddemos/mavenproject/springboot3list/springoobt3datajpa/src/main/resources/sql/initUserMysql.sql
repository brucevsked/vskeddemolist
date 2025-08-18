CREATE USER 'springboot3datajpa'@'%' IDENTIFIED BY 'springboot3datajpa';

CREATE DATABASE `springboot3datajpa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on `springboot3datajpa`.* to 'springboot3datajpa'@'%' ;