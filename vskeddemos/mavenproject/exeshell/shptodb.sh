#!/bin/bash
set -x #打开脚本调试
TABLE_PREFIX=asdfasdf
v=0
pgsql_path=/usr/bin

USERNAME=postgres
PGPASSWORD=aaa
database=gis_base_map
name_spaces=public
port=5432
target_host=192.168.111.52

shpfilepath=`ls /tmp/vskedtest/*.shp` #定义遍历的目录


for shpFile in $shpfilepath
  do
    ((v++))
    #echo $pgsql_path/shp2pgsql -s 3857 -c -W "GBK" $shpFile $name_spaces.$1_$v -- $1_$v.sql
    $pgsql_path/shp2pgsql -s 3857 -c -W "GBK" $shpFile $name_spaces.$1_$v >> $1_$v.sql
done

sleep 3

sqlfilepath=`ls /tmp/vskedtest/*.sql` #定义遍历sql目录不要移位置

for sqlFile in $sqlfilepath
  do
    #echo  $pgsql_path/psql -h $target_host -U $USERNAME -d $database -p 5432 -f $sqlFile
    $pgsql_path/psql -h $target_host -U $USERNAME -d $database -p 5432 -f $sqlFile
done


