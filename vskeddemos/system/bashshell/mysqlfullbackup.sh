#!/bin/bash

# now time 20200813
dateNow=$(date "+%Y%m%d")

mysqlUserName=root
mysqlUserPass=root123456
backUpDatabaseName=ry
# my socket path
mysqlSocket=/data/mysql/mysql/mysql.sock
#default socket path
# mysqlSocket=/var/lib/mysql/mysql.sock

fullBackUpFolderBase=/data/backup/mysql/fullbackup
fullBackUpFolder="${fullBackUpFolderBase}/${dateNow}"

mkdir -p ${fullBackUpFolder}

fullBackUpLog="${fullBackUpFolderBase}/mysqlFullBackUp.log"

echo "start full back up:$(date "+%Y-%m-%d %H:%M:%S")" >> ${fullBackUpLog}
echo $(date) >> ${fullBackUpLog}

backUpFileNameBase="$(date "+%Y%m%d%H%M%S")fullback.sql"
backUpFileName="${fullBackUpFolder}/${backUpFileNameBase}"
mysqldump --socket=${mysqlSocket} -u${mysqlUserName} -p${mysqlUserPass} -B ${backUpDatabaseName} > ${backUpFileName}

cd ${fullBackUpFolder}
tar -zcvf ${backUpFileName}.tar.gz ${backUpFileNameBase}
rm -rf ${backUpFileName}

#delete 7 day ago folder
find ${fullBackUpFolderBase} -mtime +7 -exec rm -rf {} \;

echo "finish full back up:$(date "+%Y-%m-%d %H:%M:%S")" >> ${fullBackUpLog}