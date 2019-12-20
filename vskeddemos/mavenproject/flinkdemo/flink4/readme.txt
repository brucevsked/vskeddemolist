本示例自定义socket数据源，发送到http接口

注意运行时需要的jar包要放到flink的lib目录中
flink-connector-kafka-base_2.12-1.9.1.jar
flink-connector-kafka_2.12-1.9.1.jar
flink-shaded-hadoop-2-uber-2.7.5-7.0.jar
kafka-clients-2.2.0.jar
kotlin-stdlib-1.3.50.jar
kotlin-stdlib-common-1.3.50.jar
okhttp-4.2.2.jar
okio-2.4.1.jar
retrofit-2.6.2.jar

自定义source与sink


需要在项目中声明一个接口
http://project:9110/sendwebsocket

通过retrofit技术将数据发送到对应接口


lettuce连接池

maven打包可运行的jar包

maven clean
maven package

参考
https://blog.csdn.net/silentwolfyh/article/details/81506977

https://www.cnblogs.com/ALittleMoreLove/archive/2018/08/09/9449992.html

flink run -m yarn-cluster -yn 2 -yjm 1024 /tmp/flink4-1.0.jar

