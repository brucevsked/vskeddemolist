
/**
 *this code by vsked
 *create 201802071610
 *lastModify 201802071610
 *任何人有字段修改需要在注释与本头部进行声明！
*/


CREATE USER 'sssdatajpa'@'%' IDENTIFIED BY 'sssdatajpa'; 

CREATE DATABASE sssdatajpa DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on sssdatajpa.* to 'sssdatajpa'@'%' ;

use sssdatajpa;