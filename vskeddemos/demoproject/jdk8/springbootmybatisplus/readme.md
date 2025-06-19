
单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181

http://127.0.0.1:8181/test2

http://127.0.0.1/prod-api/test2

http://127.0.0.1/prod-api/profile/images/tiding.png


--------------------------------------------------------------------------------

引入mybatis plus boot start 与 数据库驱动(注意数据库类型与驱动)

		<mybatisPlusStart.version>3.5.3.1</mybatisPlusStart.version>
		<mysqlConnector.version>8.0.33</mysqlConnector.version>

		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus-boot-starter</artifactId>
			<version>${mybatisPlusStart.version}</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>${mysqlConnector.version}</version>
		</dependency>

定义数据模型包与映射包
com.vsked.business.model
com.vsked.business.mapper

启动类上添加映射包扫描
@MapperScan("com.vsked.business.mapper")

添加数据库配置
application-dev.yml

spring:
  datasource:
    url: jdbc:mysql://10.0.193.11:3306/mybatis_plus1?useUnicode=true&characterEncoding=utf8&allowMutiQueries=true&useTimezone=true&serverTimezone=GMT%2B8
    username: root
    password: Y4yhl9tbf110_
    driver-class-name: com.mysql.cj.jdbc.Driver
    hikari:
      connection-test-query: select 1

编写用户模型
com.vsked.business.model.Users
编写映射接口文件继承BaseMapper 也可以编写自定义查询
com.vsked.business.mapper.UserMapper

编写单元测试
com.vsked.business.mapper.UsersMapperTest
