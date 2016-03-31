aar包发布方式
1编写 HelloWorld.java接口类
2编写HelloWorldImpl.java接口实现类
3在src目录中新建META-INF目录
4在META-INF目录新建services.xml文件
5services.xml文件中设置服务方法与服务类
6导出为jar包改名为.aar
7放到%TOMCAT_HOME%/webapps/axis2/WEB-INF/services目录下
8访问
http://localhost:8080/axis2/services/listServices
会看到HelloWorld的service