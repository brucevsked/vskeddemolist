
CREATE SEQUENCE loginLogSeq  
INCREMENT BY 1   -- 每次加几个    
START WITH 1     -- 从1开始计数    
NOMAXVALUE       -- 不设置最大值    
NOCYCLE          -- 一直累加，不循环    
CACHE 10; 

drop table userT;
CREATE TABLE userT
(
usId NUMBER(10) PRIMARY KEY NOT NULL,               
usName VARCHAR2(200) NOT NULL,
usPass VARCHAR2(200) NOT NULL,
usCredits NUMBER(10) default 0,
usLastIp VARCHAR2(20) NOT NULL,
usLastVisit DATE                          
);

insert into userT(usId,usName,usPass,usCredits,usLastIp,usLastVisit) values(1,'admin','admin',512,'192.168.168.168',sysdate);
insert into userT(usId,usName,usPass,usCredits,usLastIp,usLastVisit) values(2,'admin1','admin1',88885,'192.168.168.169',sysdate);

drop table loginLogT;
CREATE TABLE loginLogT
(
llId NUMBER PRIMARY KEY NOT NULL, 
usId NUMBER NOT NULL,                
llIp VARCHAR2(20),                       
llDate DATE                          
);