

执行远程命令示例
远程启动flume示例,需要先将机器设置为无密码登录


http://localhost:9010/hello

http://localhost:9010/rs1

http://localhost:9010/cmd?cmd=dir



windows版本

cmd /c dir 是执行完dir命令后关闭命令窗口。
 
cmd /k dir 是执行完dir命令后不关闭命令窗口。
 
cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。
 
cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭。


centos版本

/home/hadoop/app/jdk/bin/java -jar /opt/remoteshell-1.0.jar

http://192.168.60.12:9010/centos?cmd=ls
http://192.168.60.12:9010/centos?cmd=ssh root@192.168.60.10 "nohup /home/hadoop/app/apache-flume-1.9.0-bin/bin/flume-ng agent --conf conf -z 192.168.60.10:2181 -p /flumeConfig -name a3 -Dflume.root.logger=INFO,console >/logs/flume.log 2>&1 &"

文本框里写这一句
ssh root@192.168.60.10 "nohup /home/hadoop/app/apache-flume-1.9.0-bin/bin/flume-ng agent --conf conf -z 192.168.60.10:2181 -p /flumeConfig -name a3 -Dflume.root.logger=INFO,console >/logs/flume.log 2>&1 &"



