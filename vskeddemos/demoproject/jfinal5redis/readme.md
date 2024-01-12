
连接redis与过期管理
微信accesstoken

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1/test
http://127.0.0.1/test2
http://127.0.0.1/test2/flow1Api
http://127.0.0.1/test2/redis1Api

wx开头的为自己实现微信小程序相关接口
http://127.0.0.1/wx/accessToken
圆形太阳码
http://127.0.0.1/wx/createQRCode
方形二维码
http://127.0.0.1/wx/createQRCode1

mywx开头的为jfinalweixin实现的小程序相关接口（推荐这个）
访问令牌
http://127.0.0.1/mywx/accessToken
圆形太阳码
http://127.0.0.1/mywx/createQRCode
方形二维码
http://127.0.0.1/mywx/createQRCode1

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
添加微信小程序支持
pom添加
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>2.0.7</version>
        </dependency>

		<dependency>
			<groupId>com.jfinal</groupId>
			<artifactId>jfinal-weixin</artifactId>
			<version>3.4</version>
		</dependency>

db.txt添加
#######微信小程序配置########
token =
appId = wx0xxxxxxx
appSecret = d0xxxxxxx

DbConfig.java添加
    @Override
    public void onStart() {

        WxaConfig wc = new WxaConfig();
        wc.setAppId(getProperty("appId"));
        wc.setAppSecret(getProperty("appSecret"));
        WxaConfigKit.setWxaConfig(wc);

        super.onStart();
    }
