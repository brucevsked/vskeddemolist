
本示例参考了：
https://jfinal.com/share/2004


单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1/test
http://127.0.0.1/test2
http://127.0.0.1/test2/flow1Api
http://127.0.0.1/test2/redis1Api

--------------------------------------------------------------------------------
第一步建表
test2a
第二步，在model包里添加类，对应表名
Test2a extends Model<Test2a>

第三步，写控制器com.jat.controller
Test2Controller extends Controller

要继承Controller
查数据库时候用Db.find

--------------------------------------------------------------------------------
添加redis支持  

添加依赖
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>4.2.3</version>
</dependency>

<dependency>
    <groupId>de.ruedigermoeller</groupId>
    <artifactId>fst</artifactId>
    <version>2.57</version>
</dependency>

添加插件 com.jat.DbConfig 中

String cacheName="ktvdata";
String host=getProperty("redisHost");
int port=getPropertyToInt("redisPort");
int timeout=10000;
String redisPass=getProperty("redisPass");
// 用于缓存bbs模块的redis服务
RedisPlugin ktvRedisPlugin = new RedisPlugin(cacheName, host, port, timeout, redisPass);
plugins.add(ktvRedisPlugin);

使用
放值
Redis.use("ktvdata").set("ktv1:room1:user1","mynameisvsked");
取值
String user1=Redis.use("ktvdata").get("ktv1:room1:user1");

--------------------------------------------------------------------------------
添加websocket支持
添加依赖

<!-- 开发 WebSockets 时开启下面的依赖 -->
<dependency>
    <groupId>io.undertow</groupId>
    <artifactId>undertow-websockets-jsr</artifactId>
    <version>2.2.18.Final</version>
</dependency>

在undertow启动添加websocket集成
UndertowServer.create(DbConfig.class).setPort(80).setDevMode(true).configWeb(build->{
build.addWebSocketEndpoint(WebSocket.class);
}).start();

不拦截websocket的访问（DbConfig.class配置文件）
public void configHandler(Handlers handlers) {
handlers.add(new UrlSkipHandler("^/websocket.ws",false));
}

编写WebSocket.class的方法

其他业务地方触发消息发送（message可以用json格式，这样便于传递更多信息到前端）
// 引用websocket
private WebSocket ws = new WebSocket();
// websocket推送回复消息
ws.onMessage("{\"userId\":\"" + receiver + "\",\"message\":{\"tp\":\"" + type + "\",\"mes\":\"" + content + "\"}}");


客户端测试
ServerWebSocket1Client.html