# log4j2testng7
## 所用技术
maven 3.6.3  
Log4j  2.13.3  
TestNG  7.4.0


单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

log4j2日志级别高亮颜色显示
1在log4j2.xml配置高亮代码设置highlight标识，其中highlight部分为高亮日志显示字段
2 PatternLayout标签添加属性 disableAnsi="false" 

<console name="Console" target="SYSTEM_OUT">
    <!--输出日志的格式 -->
    <PatternLayout charset="utf-8" pattern="%d{yyyy-MM-dd 'at' HH:mm:ss z} traceId:[%X{mdc_trace_id}] %highlight{%-5level} %class{36} %L %M - %msg%xEx%n" disableAnsi="false" />
</console>
