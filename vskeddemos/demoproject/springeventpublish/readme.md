
实际分布式系统中如果要异步发送短信与邮件通知我们会使用rabbitmq之类的中间件  
实际系统中如果要异步存储到数据库与文件我们会使用rabbitmq之类的中间件  

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181


