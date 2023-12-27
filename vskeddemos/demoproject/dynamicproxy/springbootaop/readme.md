
单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

需要将类添加spring 相关注解，并且类要交给spring来管理，对spring依赖太强。

