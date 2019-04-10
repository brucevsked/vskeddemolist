
/**
 *this code by vsked
 *create 201808251415
 *lastModify 201808251415
 *任何人有字段修改需要在注释与本头部进行声明！
*/


CREATE USER 'activitidemo'@'%' IDENTIFIED BY 'Activitidemo_888'; 

CREATE DATABASE activitidemo DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on activitidemo.* to 'activitidemo'@'%' ;

use activitidemo;