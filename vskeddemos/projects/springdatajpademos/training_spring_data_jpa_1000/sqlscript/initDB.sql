
------------------------------------

create database jpa2jdbcdb;

use jpa2jdbcdb;
------------------------------------
drop table employeeT;        

------------------------------------


--==============================================================
-- Table1: employeeT
--==============================================================
CREATE TABLE employeeT
(
eid int PRIMARY KEY auto_increment,       
ename varchar(200) unique NOT NULL ,      
salary double(12,2) default 0,        
deg  varchar(200) default ''
);

insert into employeeT(ename,salary,deg) values('green lostvti',125601.12,'c');
insert into employeeT(ename,salary,deg) values('mike jackson',5000.12,'h');
insert into employeeT(ename,salary,deg) values('bruce alieyou',8520.63,'d');


select * from employeeT;