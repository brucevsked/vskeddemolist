

/*
*this script create by vsked
*mysql 5.7.30 version
*202110290955
*/


show variables like 'version';
select column_name,column_comment,data_type 
from information_schema.columns 
where table_name='oscshop_lionfish_comshop_goods' and table_schema='grouptooljat';

alter table oscshop_lionfish_comshop_goods  add orderby  int(5) not null default 100 comment '排序';

select column_name,column_comment,data_type 
from information_schema.columns 
where table_name='oscshop_lionfish_comshop_goods' and table_schema='grouptooljat';