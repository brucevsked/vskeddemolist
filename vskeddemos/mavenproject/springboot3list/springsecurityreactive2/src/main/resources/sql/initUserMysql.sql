CREATE USER 'springsecurityreactive2'@'%' IDENTIFIED WITH caching_sha2_password BY 'springsecurityreactive2';

CREATE DATABASE `springsecurityreactive2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on `springsecurityreactive2`.* to 'springsecurityreactive2'@'%' ;