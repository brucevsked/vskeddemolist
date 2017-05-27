


热部署方法

hottest2.war

hottest2##1.war
hottest2##2.war
hottest2##3.war


http://localhost:8080/hottest2/


每一步在tomcat中部署你的项目使用war包部署
第二步我们升级了项目重新打一个war包名为hottest2##1.war
这个是版本1号。然后我们部署上这个war包以后新访问的请求就会发送到这上面
如果发现这个版本有问题。可以立即下线，新的请求会自动回到老版本

经过测试证明线程也可以使用这种方式进行热部署，但原有线程并不会销毁


还可以使用springloaded
