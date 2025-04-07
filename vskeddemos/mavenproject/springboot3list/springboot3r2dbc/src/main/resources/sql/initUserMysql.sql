CREATE USER 'springboot3r2dbc'@'%' IDENTIFIED BY 'springboot3r2dbc';

CREATE DATABASE `springboot3r2dbc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

grant all  on `springboot3r2dbc`.* to 'springboot3r2dbc'@'%' ;