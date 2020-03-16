

动态创建kafka消费者
动态停止kafka消息者

com.vsked.controller.TestController

根据主题创建消费者组
http://localhost:8080/topicedit?tp=1&topicname=mytpoics6012
根据主题停止消息者组
http://localhost:8080/topicedit?tp=3&topicname=mytpoic3
多个不同类型消费者同时消费一个主题下同一条消费
http://localhost:8080/topicedit?tp=4&topicname=vskedtesttopic1



kafka中listener停止与启动参考
https://www.jianshu.com/p/2447592ca5a9

动态修改topic参考
可以先在yml中配置多个预留的topic到时候用的时候再对应即可?