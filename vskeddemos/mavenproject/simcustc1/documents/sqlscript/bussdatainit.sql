
/**
 *this code by vsked
 *create 201705150918
 *lastModify 201705150918
 *任何人有字段修改需要在注释与本头部进行声明！
*/

/********+*********+*********+*********+*********+*********+*/

/**  公共删除表区，为防止外键冲突,按建表顺序倒序排列  **/

/********+*********+*********+*********+*********+*********+*/

/**  建表区  **/

/**  字段说明区  **/

/**  约束创建区  **/

/**  高耦合初始化数据区，当数据与本初始化耦合度不高时另起脚本initData.sql来进行数据初始化  **/

/**  数据查询区  **/

/********+*********+*********+*********+*********+*********+*/
drop table carrierT;

/********+*********+*********+*********+*********+*********+*/

create table carrierT(
carrierId nvarchar2(64)  primary key,       --编号
carrierName nvarchar2(64) unique not null,  --运营商名
carrierNick nvarchar2(64) ,                 --别名
carrierShortName nvarchar2(64) ,            --简称
officialWebSite nvarchar2(256),             --官网
hotline  nvarchar2(64),                     --客服电话
carrierAddTime timestamp default sysdate    --添加时间
);

comment on table  carrierT                   is '运营商表'    ;
comment on column carrierT.carrierId         is '运营商编号'  ;
comment on column carrierT.carrierName       is '运营商名'    ;
comment on column carrierT.carrierNick       is '别名'        ;
comment on column carrierT.carrierShortName  is '简称'        ;
comment on column carrierT.officialWebSite   is '官网'        ;
comment on column carrierT.hotline           is '客服电话'    ;
comment on column carrierT.carrierAddTime    is '添加时间'    ;

insert into carrierT(carrierId,carrierName,carrierNick,carrierShortName,officialWebSite,hotline) values('carrier0000000000000000000000001','远特通信','远特','远特','http://www.yuantel.com/','4006091100');
insert into carrierT(carrierId,carrierName,carrierNick,carrierShortName,officialWebSite,hotline) values('carrier0000000000000000000000002','国美极信通信','极信通信','国美','http://www.g-mobile.com.cn/','10037');
insert into carrierT(carrierId,carrierName,carrierNick,carrierShortName,officialWebSite,hotline) values('carrier0000000000000000000000003','迪信通','迪迦通信','迪加','http://www.10026.cn/','4001610026');
insert into carrierT(carrierId,carrierName,carrierNick,carrierShortName,officialWebSite,hotline) values('carrier0000000000000000000000004','蜗牛移动','蜗牛','蜗牛','http://10040.snail.com/pc/','10040');


select * from carrierT;

/********+*********+*********+*********+*********+*********+*/
