
CREATE SEQUENCE LoginLog_Seq  
INCREMENT BY 1   -- 每次加几个    
START WITH 1     -- 从1开始计数    
NOMAXVALUE       -- 不设置最大值    
NOCYCLE          -- 一直累加，不循环    
CACHE 10; 


CREATE TABLE Users_T
(
userId NUMBER PRIMARY KEY NOT NULL,               
userName VARCHAR2(200) NOT NULL,
password VARCHAR2(200) NOT NULL,
credits NUMBER default 0,
lastIp VARCHAR2(20) NOT NULL,
lastVisit DATE                          
);

insert into Users_T(userId,userName,password,credits,lastIp,lastVisit) 
values(1,'admin','admin',512,'192.168.168.168',sysdate);
insert into Users_T(userId,userName,password,credits,lastIp,lastVisit) 
values(2,'admin1','admin1',88885,'192.168.168.169',sysdate);

CREATE TABLE LoginLog_T
(
loginLog NUMBER PRIMARY KEY NOT NULL, 
userId NUMBER NOT NULL,                
ip VARCHAR2(20),                       
loginDate DATE                          
);
