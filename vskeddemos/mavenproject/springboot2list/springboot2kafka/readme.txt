查看主题列表
kafka-topics.sh --bootstrap-server 10.0.193.11:9092 --list
删除主题
kafka-topics.sh --bootstrap-server 10.0.193.11:9092 --delete --topic wtss

生产主题测试
kafka-console-producer.sh --broker-list 10.0.193.11:9092 --topic wtss

automobile,location=jinan,deviceId=c001 inte=5i32,psst=L"A",saco=12i32,lati=L"117.0000002",nshe=L"E",longi=L"36.0000002",ewhe=L"N",alti=93.1,spee=50.0,hoan=90i32,vean=90i32,acce=25.0,temp=28.0,status=3i32 1682402249902000009
automobile,location=jinan,deviceId=c001 inte=5i32,psst=L"A",saco=12i32,lati=L"117.0000002",nshe=L"E",longi=L"36.0000002",ewhe=L"N",alti=93.1,spee=50,hoan=90i32,vean=90i32,acce=25,temp=28,status=3i32 1682402249902000010

消费消息 按回车以后会收到生产者发的消息
kafka-console-consumer.sh --bootstrap-server 10.0.193.11:9092 --topic wtss


启动zookeeper，需要配置好环境变量
zkServer.sh start
查看zookeeper状态
zkServer.sh status
停止zookeeper
zkServer.sh stop

kafka前台启动
kafka-server-start.sh /opt/kafka_2.12-3.1.0/config/server.properties
后台启动
kafka-server-start.sh -daemon /opt/kafka_2.12-3.1.0/config/server.properties
关闭kafka
/opt/kafka_2.12-3.1.0/bin/kafka-server-stop.sh

netstat -lnp|grep 9092

sysctl -w net.ipv6.conf.all.disable_ipv6=1
sysctl -w net.ipv6.conf.default.disable_ipv6=1

