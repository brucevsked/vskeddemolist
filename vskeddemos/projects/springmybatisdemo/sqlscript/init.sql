--oracle 11g database

create table baseUserT(
buId number(10) primary key,
buSeq number(10) unique,
buLoginId varchar(500) unique,
buLoginName varchar(500),
buLoginMobile varchar(20),
buLoginEmail varchar(100),
buLoginPass varchar(100),
buAvata blob,
buAvataUrl varchar(500),
buStatus number(4),
buRegTime date,
buLastLoginTime date,
buLastLoginIp varchar(20),
buMemo varchar(200)
);

create sequence seqForBaseUserT Increment by 1 start with 0 minvalue 0;

--CREATE OR REPLACE TRIGGER trigForBaseUserTAutoIncrement 
--before insert on baseUserT 
--for each row 
--begin 
--select seqForBaseUserT.nextval into :new.buId from dual;
--end;

--drop TRIGGER trigForBaseUserTAutoIncrement;

INSERT INTO BASEUSERT 
(BUSEQ, BULOGINID, BULOGINNAME, BULOGINMOBILE, BULOGINEMAIL, BULOGINPASS,  BUSTATUS, BUREGTIME, BULASTLOGINTIME, BULASTLOGINIP, BUMEMO) 
VALUES (1, 'root', 'root0', '13888888888', 'godkiller@ter.com', 'root', 1, TIMESTAMP '2014-08-07 11:05:07', TIMESTAMP '2014-08-07 11:05:07', '192.168.66.39', 'god is here');
commit;