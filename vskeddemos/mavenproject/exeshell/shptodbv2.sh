#!/bin/bash
set -x #打开脚本调试
#本脚本传两个参数第一个参数为版本号第二个参数为要解压的zip包名称,执行完成后会清理本目录下所有除sh脚本外文件
TABLE_PREFIX=asdfasdf
v=0
pgsql_path=/usr/bin

USERNAME=postgres
PGPASSWORD=Y4yhl9tbf110
database=gis_base_map
name_spaces=public
port=5432
target_host=192.168.111.52

unzip $2

shpfilepath=`ls /tmp/vskedtest/*.shp` #定义遍历的目录


for shpFile in $shpfilepath
  do
    ((v++))
    #echo $pgsql_path/shp2pgsql -s 3857 -c -W "GBK" $shpFile $name_spaces.$1_$v -- $1_$v.sql
    $pgsql_path/shp2pgsql -s 3857 -c -W "GBK" $shpFile $name_spaces.$1_$v >> $1_$v.sql
done


sqlfilepath=`ls /tmp/vskedtest/*.sql` #定义遍历sql目录不要移位置

for sqlFile in $sqlfilepath
  do
    #echo  $pgsql_path/psql -h $target_host -U $USERNAME -d $database -p 5432 -f $sqlFile
    $pgsql_path/psql -h $target_host -U $USERNAME -d $database -p 5432 -f $sqlFile
done

find . -not -name "*.sh"|xargs rm -rf #删除本目录下除sh脚本外其他所有文件


