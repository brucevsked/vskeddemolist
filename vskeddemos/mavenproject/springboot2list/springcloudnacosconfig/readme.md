# springcloudnacosconfig
## 一 所用技术
maven 3.6.3  
SpringBoot  2.6.7  
SpringCloudBootstrap 3.1.2  
Spring cloud alibaba 2021.0.1.0  
TestNG  7.5  
Nacos 2.1.0  


spring-cloud-alibaba结合nacos配置中心  

1动态加载yml自定义属性  
2动态加载yml内容为spring boot类属性

http://127.0.0.1:8080/user0


在 Nacos Spring Cloud 中，dataId 的完整格式如下
${prefix}-${spring.profiles.active }.${file-exetension}  
prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
spring.profiles.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档。 注意：当 spring.profiles.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}，其实就算 spring.profiles.active 不为空，使用 ${prefix}.${file-extension} 同样可以找到对应配置。
file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。


http://10.0.193.11:8848/nacos/
进入nacos配置中心，添加配置
springcloudnacosconfig-mysql.yml
project:
  id: 1002
  name: test2

也可以把application-mysql中相关内容复制一下



