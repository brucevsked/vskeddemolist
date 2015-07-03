create database jpademodb;

use jpademodb;

drop table customerT;
CREATE TABLE customerT
(
customerId int PRIMARY KEY auto_increment , 
customerName varchar(200),
customerShortName varchar(100), 
resisteredCapital double precision(10,2)
);

insert into customerT(customerName,customerShortName,resisteredCapital) values('这个比较牛责任有限公司','这个比较牛',100000.00);

select * from customerT;