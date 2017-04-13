
/*临时表用来存储激活数据中代理商 每次用之前会清空下*/
drop table tmpAgent;
create table tmpAgent(
agentName nvarchar2(32),
provider nvarchar2(32)
);

insert into tmpAgent(agentName,provider) values('a1','yuante');
insert into tmpAgent(agentName,provider) values('a2','dijia');
insert into tmpAgent(agentName,provider) values('a3','woniu');

select * from tmpAgent;

truncate table tmpAgent;

/*代理商客户激活数据表*/

drop table agentCustomerActiveData;
create table agentCustomerActiveData(
ids nvarchar2(32),
agentName nvarchar2(32),
customerName nvarchar2(32),
provider nvarchar2(32),
activeCount number(10),
batchIds nvarchar2(32),
activedate date
)
partition by range (activedate)
(
partition p1  values less than (to_date('2017-01-1', 'yyyy-mm-dd')),
partition p2  values less than (to_date('2017-02-1', 'yyyy-mm-dd')),
partition p3  values less than (to_date('2017-03-1', 'yyyy-mm-dd')),
partition p4  values less than (to_date('2017-04-1', 'yyyy-mm-dd')),
partition p5  values less than (to_date('2017-05-1', 'yyyy-mm-dd')),
partition p6  values less than (to_date('2017-06-1', 'yyyy-mm-dd')),
partition p7  values less than (to_date('2017-07-1', 'yyyy-mm-dd')),
partition p8  values less than (to_date('2017-08-1', 'yyyy-mm-dd')),
partition p9  values less than (to_date('2017-09-1', 'yyyy-mm-dd')),
partition p10 values less than (to_date('2017-10-1', 'yyyy-mm-dd')),
partition p11 values less than (to_date('2017-11-1', 'yyyy-mm-dd')),
partition p12 values less than (to_date('2017-12-1', 'yyyy-mm-dd')),
partition p13 values less than (to_date('2018-01-1', 'yyyy-mm-dd')),
partition p14 values less than (to_date('2018-02-1', 'yyyy-mm-dd')),
partition p15 values less than (to_date('2018-03-1', 'yyyy-mm-dd')),
partition p16 values less than (to_date('2018-04-1', 'yyyy-mm-dd')),
partition p17 values less than (to_date('2018-05-1', 'yyyy-mm-dd')),
partition p18 values less than (to_date('2018-06-1', 'yyyy-mm-dd')),
partition p19 values less than (to_date('2018-07-1', 'yyyy-mm-dd')),
partition p20 values less than (to_date('2018-08-1', 'yyyy-mm-dd')),
partition p21 values less than (to_date('2018-09-1', 'yyyy-mm-dd')),
partition p22 values less than (to_date('2018-10-1', 'yyyy-mm-dd')),
partition p23 values less than (to_date('2018-11-1', 'yyyy-mm-dd')),
partition p24 values less than (to_date('2018-12-1', 'yyyy-mm-dd')),
partition p25 values less than (to_date('2019-01-1', 'yyyy-mm-dd')),
partition p26 values less than (to_date('2019-02-1', 'yyyy-mm-dd')),
partition p27 values less than (to_date('2019-03-1', 'yyyy-mm-dd')),
partition p28 values less than (to_date('2019-04-1', 'yyyy-mm-dd')),
partition p29 values less than (to_date('2019-05-1', 'yyyy-mm-dd')),
partition p30 values less than (to_date('2019-06-1', 'yyyy-mm-dd')),
partition p31 values less than (to_date('2019-07-1', 'yyyy-mm-dd')),
partition p32 values less than (to_date('2019-08-1', 'yyyy-mm-dd')),
partition p33 values less than (to_date('2019-09-1', 'yyyy-mm-dd')),
partition p34 values less than (to_date('2019-10-1', 'yyyy-mm-dd')),
partition p35 values less than (to_date('2019-11-1', 'yyyy-mm-dd')),
partition p36 values less than (to_date('2019-12-1', 'yyyy-mm-dd'))
);