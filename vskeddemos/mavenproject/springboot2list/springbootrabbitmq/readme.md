
spring boot+rabbitm+redis用在异步将数据写入缓存跟磁盘上。

rabbitmq在必要时候还可以替换为kafka等其他消息中间件，根据业务场景来选择。

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181


