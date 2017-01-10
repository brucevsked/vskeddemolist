

http://localhost:8080/springloadeddemo

第一步复制
springloaded-1.2.6.RELEASE.jar
这个jar包到tomcat的bin目录

第二步
在tomcat/bin目录中catalina.bat中添加一句话

set JAVA_OPTS=-javaagent:springloaded-1.2.6.RELEASE.jar -noverify

第三步启动这个tomcat不停止他并替换你已经修改的类再次访问这个类你会发现已经被改变