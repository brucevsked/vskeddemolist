# log4j2testng7
## 所用技术
maven 3.6.3  
Log4j  2.13.3  
TestNG  7.4.0


单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

## testng7.5 需要JDK1.8以上
## testng7.6 需要JDK11以上

权限拦截：
在执行对象方法前判断是否有权限执行方法
如读取属性值是一个方法,这样系统里就只有方法的权限判断了。

创建对象，使用哪些参数创建对象

系统中所有概念都要有封装
所有对象执行动作前与执行动作后都会有操作记录，可以通过操作记录将系统重置到初始化状态。
执行完动作对象属性必定发生变化，只记录变化的属性即可

