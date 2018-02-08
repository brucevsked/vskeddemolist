
/**
 *this code by vsked
 *create 201802071610
 *lastModify 201802071610
 *任何人有字段修改需要在注释与本头部进行声明！
*/

create table userT(
userId int  primary key AUTO_INCREMENT,
userName varchar(64) not null,
userPass varchar(64) not null,
userEmail varchar(255)
);

insert into userT(userName,userPass,userEmail) values('admin','admin','vsva@163.com');

select * from userT;