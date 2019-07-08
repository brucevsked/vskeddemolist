
http://localhost:9010/api/v1/testadd

http://localhost:9010/api/v1/testlist?start=1&length=1
http://localhost:9010/api/v1/testlist?start=1&length=5

基本spring boot框架+redis缓存开启+junit单元测试+log4j2日志+slf4j

缓存使用请注意
1 应用启动时要添加启用缓存注解
@EnableCaching
2dao层添加实现类
@CacheNamespace(implementation=MybatisRedisCache.class)
3redis连接初始化类中(如RedisConfig)设置redis连接
MybatisRedisCache.setRedisTemplate(redisTemplate);
4在添加，更新，删除操作上添加更新缓存注解
@Options(flushCache=FlushCachePolicy.TRUE)

如
	@Options(flushCache=FlushCachePolicy.TRUE)
	@Insert("insert into webUserT(uid,username,userpass,phone,status) values(#{uid},#{username},#{userpass},#{phone},1)")
	int add(Map<String, Object> m);

drop table if exists webUserT ;

create table webUserT(
`uid` varchar(32) NOT NULL                    COMMENT 'uid,用户账号,主键',
`username` varchar(32)   NOT NULL             COMMENT '用户名(nick_name)',
`userpass` varchar(64) NOT NULL               COMMENT '密码(MD5(密码+盐))',
`salt` varchar(32)                            COMMENT '盐',
`realname` varchar(128)                       COMMENT '用户真名',
`avatar` varchar(256)                         COMMENT '头像',
`phone` varchar(32)                           COMMENT '电话号码(唯一)',
`email` varchar(128)                          COMMENT '邮件地址(唯一)',
`sex` tinyint(4)                              COMMENT '性别(1.男 2.女)',
`status` tinyint(4)                           COMMENT '账户状态(1.正常 2.锁定 3.删除 4.非法)',
`onlinestate` tinyint(4) DEFAULT 0            COMMENT '在线状态(0离线1在线)',
`addtime` timestamp default CURRENT_TIMESTAMP COMMENT '创建时间',
`updatetime` timestamp                        COMMENT '更新时间',
`createsource` tinyint(4)                     COMMENT '创建来源(1.web 2.android 3.ios 4.win 5.macos 6.ubuntu)',
PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB COMMENT = 'app用户表' ROW_FORMAT = Compact;

INSERT INTO webUserT VALUES ('1', 'webadmin', '670b14728ad9902aecba32e22fa4f6bd','000000','胜哥',null,'13333333333','test@test.com',1,1,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('2', 'webuser', '670b14728ad9902aecba32e22fa4f6bd','000000','aaaa',null,'13333333332','tesat@test.com',2,1,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('3', 'webvips', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333331','testb@test.com',2,1,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);

INSERT INTO webUserT VALUES ('4', 'ta', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333131','testb@test.com',2,1,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('5', 'tb', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333331332','testb@test.com',2,1,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('6', 'tc', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333331333','testb@test.com',2,1,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('7', 'td', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333331334','testb@test.com',2,2,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('8', 'te', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333335','testb@test.com',2,2,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('9', 'tf', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333336','testb@test.com',2,2,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('10', 'tg', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333337','testb@test.com',2,4,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('11', 'th', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333338','testb@test.com',2,4,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('12', 'ti', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333339','testb@test.com',2,3,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
INSERT INTO webUserT VALUES ('13', 'tj', '670b14728ad9902aecba32e22fa4f6bd','000000','bbbb',null,'13333333340','testb@test.com',2,3,0,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);

select * from webUserT;