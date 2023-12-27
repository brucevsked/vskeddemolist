# log4j2testng7
## 所用技术
maven 3.6.3  
Log4j  2.13.3  
TestNG  7.4.0


单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

Byte Buddy 动态增强代码总共有三种方式：
subclass:对应 ByteBuddy.subclass() 方法。这种方式比较好理解，就是为目标类（即被增强的类）生成一个子类，在子类方法中插入动态代码。

rebasing:对应 ByteBuddy.rebasing() 方法。当使用 rebasing 方式增强一个类时，Byte Buddy 保存目标类中所有方法的实现，也就是说，当 Byte Buddy 遇到冲突的字段或方法时，会将原来的字段或方法实现复制到具有兼容签名的重新命名的私有方法中，而不会抛弃这些字段和方法实现。从而达到不丢失实现的目的。这些重命名的方法可以继续通过重命名后的名称进行调用。

redefinition:对应 ByteBuddy.redefine() 方法。当重定义一个类时，Byte Buddy 可以对一个已有的类添加属性和方法，或者删除已经存在的方法实现。如果使用其他的方法实现替换已经存在的方法实现，则原来存在的方法实现就会消失。

通过上述三种方式完成类的增强之后，我们得到的是 DynamicType.Unloaded 对象，表示的是一个未加载的类型，我们可以使用 ClassLoadingStrategy 加载此类型。Byte Buddy 提供了几种类加载策略，这些加载策略定义在 ClassLoadingStrategy.Default 中，其中：

WRAPPER 策略：创建一个新的 ClassLoader 来加载动态生成的类型。
CHILD_FIRST 策略：创建一个子类优先加载的 ClassLoader，即打破了双亲委派模型。
INJECTION 策略：使用反射将动态生成的类型直接注入到当前 ClassLoader 中。

