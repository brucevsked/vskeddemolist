create table vskedtest(id bigint primary key,testname varchar(200),userid bigint);
upsert into vskedtest(id,testname,userid) values(1,'halloaa',1);
upsert into vskedtest(id,testname,userid) values(2,'newtestphoenix',2);
upsert into vskedtest(id,testname,userid) values(3,'lovegirl',3);
upsert into vskedtest(id,testname,userid) values(4,'justphoenix',4);
select * from vskedtest;