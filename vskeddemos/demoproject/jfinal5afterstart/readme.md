
要打可执行的jar在cmd中运行g.bat或双击即可
jfinal不连接数据库，打jar包启动  

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1
http://127.0.0.1/test
http://127.0.0.1/test/ver
http://127.0.0.1/test/t1


前台启动看效果
java -jar /opt/testcluster/jfinal5afterstart-1.0.jar
如果没问题后台启动
nohup java -jar /opt/testcluster/jfinal5afterstart-1.0.jar com.jat.Application >/dev/null 2>&1 &
查看进程
ps -ef|grep jfinal5afterstart-1.0.jar
杀进程
ps aux|grep jfinal5afterstart-1.0.jar|grep -v grep |awk '{print $2}'|xargs kill -9


curl http://127.0.0.1:9923
curl http://127.0.0.1:9923/test
curl http://127.0.0.1:9923/test/ver



