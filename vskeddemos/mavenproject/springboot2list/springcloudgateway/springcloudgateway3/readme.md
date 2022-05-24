
springcloudgateway3  
配合负载均衡loadbalance使用在多个服务之间切换
将配置放到nacos配置中心

配合项目使用
springcloudnacosservice\springcloudnacosserviceprovide
springcloudnacosservice\springcloudnacosserviceprovide2
springcloudnacosservice\springcloudnacosserviceprovide3


配置文件放到nacos集群里面
服务名.yml  
myGateWay3.yml
spring:
  cloud:
    gateway:
      # 核心概念1：路由，一个路由代表一个处理逻辑，
      # 该逻辑里面包含三个元素：匹配条件(是否该此路由处理)、真实处理地址、过滤器
      routes:
        # id要确保唯一性
        - id: router1LB
        # 真实处理地址，请求一旦确定是当前路由处理，就会转发到这个地址去
        uri: lb://myprovide1
        # 核心概念2：谓语或者断言，作用是判断请求是否由当前路由处理
        predicates:
          - Path=/user1/**


http://127.0.0.1:7082/user1?id=goodluck




