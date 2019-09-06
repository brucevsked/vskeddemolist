特别注意
请先安装lombok插件!

websocket通过redis订阅实现消息推送

启动类
com.vsked.Application
配置文件
src/main/resources/application-dev.yml
测试文件
/src/test/java/com/vsked/service/目录中html文件


技术原理
第一步
ServerWebSocket1类中
onOpen方法建立连接
第二步
将会话放入本地map
SysConstant.webSocketSessionMap.put(token, session);
第三步
ServerWebSocket1类中
onMessage方法发送消息
redisTemplate.convertAndSend(SysConstant.webSocketChannel, msg);
消息扔到redis中
第四步
redis监听器监听到消息改变
RedisSubListenerConfig
第五步
RedisReceiver类处理消息发送情况
