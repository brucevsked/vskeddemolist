
/**
 *this code by vsk
 *create 201702191547
 *lastModify 201702191547
 *任何人有字段修改需要在注释与本头部进行声明！
*/


CREATE USER 'shirorestful'@'%' IDENTIFIED BY 'shirorestful'; 

CREATE DATABASE shirorestful DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on shirorestful.* to 'shirorestful'@'%' ;