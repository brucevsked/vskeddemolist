
1解压axis2-1.7.1-bin.zip为axis2目录
2配置环境变量
AXIS2_HOME
K:\JarLibrary\webservice\axis2
path环境变量中最后添加
;%AXIS2_HOME%\bin;

3通过服务端服务列表http://localhost:8080/axis2/services/listServices
找到你要调用服务的地址
http://localhost:8080/axis2/services/HelloWorld

4在d盘新建一个目录叫temptest然后运行以下命令生成webservice调用客户端
D:\temptest>wsdl2java -uri http://localhost:8080/axis2/services/HelloWorld?wsdl
Using AXIS2_HOME:   K:\JarLibrary\webservice\axis2
Using JAVA_HOME:    E:\Program Files\Java\jdk1.7.0_71
Retrieving document at 'http://localhost:8080/axis2/services/HelloWorld?wsdl'.
log4j:WARN No appenders could be found for logger (org.apache.axiom.locator.DefaultOMMetaFactoryLocator).
log4j:WARN Please initialize the log4j system properly.
D:\temptest>

5编写ClientTest.java文件来测试生成的类
