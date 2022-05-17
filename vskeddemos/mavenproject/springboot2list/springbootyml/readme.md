# springbootyml
## 一 所用技术
maven 3.6.3  
SpringBoot  2.4.4  
Log4j  2.13.3  
TestNG  7.1.0

spring boot读取yml信息

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

http://127.0.0.1:8181
http://127.0.0.1:8181/p1
http://127.0.0.1:8181/p2
http://127.0.0.1:8181/p3

方案1 @value方式  
推荐 能读取系统自带与自定义的  
方案2 @ConfigurationProperties  
全是自定义属性推荐这种方案  
方案3 Environment  
仅作参考  



对象、Map（属性和值）（键值对）
对象还是k: v的方式
k: v：在下一行来写对象的属性和值的关系；注意缩进(不支持tab,使用空格),如:
person:
  age: 18
  name: mysgk

数组（List、Set）
用- 值表示数组中的一个元素,如:
hands:
  - left
  - right

