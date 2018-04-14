
/**
 *this code by vsked
 *create 201804131550
 *lastModify 201804131550
 *任何人有字段修改需要在注释与本头部进行声明！
*/


CREATE USER 'custvs'@'%' IDENTIFIED BY 'custvs'; 

CREATE DATABASE custvs DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on custvs.* to 'custvs'@'%' ;

use custvs;