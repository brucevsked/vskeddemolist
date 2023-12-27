# log4j2testng7
## 所用技术
maven 3.6.3  
Log4j  2.13.3  
TestNG  7.4.0


单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

一、什么是 CGLIB?
CGLIB是一个功能强大，高性能的代码生成包。它为没有实现接口的类提供代理，为JDK的动态代理提供了很好的补充。
通常可以使用Java的动态代理创建代理，但当要代理的类没有实现接口或者为了更好的性能，CGLIB是一个好的选择。
CGLIB作为一个开源项目，其代码托管在github，地址为：https://github.com/cglib/cglib

二、CGLIB 原理
CGLIB 原理：动态生成一个要代理类的子类，子类重写要代理的类的所有不是final的方法。
在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。它比使用java反射的JDK动态代理要快。
CGLIB 底层：使用字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，
因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
CGLIB缺点：对于final方法，无法进行代理。

三、CGLIB 的应用
广泛的被许多AOP的框架使用，例如Spring AOP和dynaop。Hibernate使用CGLIB来代理单端single-ended(多对一和一对一)关联。

四、为什么使用 CGLIB?
CGLIB代理主要通过对字节码的操作，为对象引入间接级别，以控制对象的访问。
我们知道Java中有一个动态代理也是做这个事情的，那我们为什么不直接使用Java动态代理，而要使用CGLIB呢？
答案是CGLIB相比于JDK动态代理更加强大，JDK动态代理虽然简单易用，但是其有一个致命缺陷是，只能对接口进行代理。
如果要代理的类为一个普通类、没有接口，那么Java动态代理就没法使用了。

五、CGLIB组成结构
![pic1](cglib1.png)
CGLIB底层使用了ASM（一个短小精悍的字节码操作框架）来操作字节码生成新的类。
除了CGLIB库外，脚本语言（如Groovy何BeanShell）也使用ASM生成字节码。
ASM使用类似SAX的解析器来实现高性能。我们不鼓励直接使用ASM，因为它需要对Java字节码的格式足够的了解。

六、CGLIB的API
1、Jar包：
cglib-nodep-2.2.jar：使用nodep包不需要关联asm的jar包,jar包内部包含asm的类.
cglib-2.2.jar：使用此jar包需要关联asm的jar包,否则运行时报错.
2、CGLIB类库：
由于基本代码很少，学起来有一定的困难，主要是缺少文档和示例，这也是CGLIB的一个不足之处。

本系列使用的CGLIB版本是2.2。

net.sf.cglib.core: 底层字节码处理类，他们大部分与ASM有关系。
net.sf.cglib.transform: 编译期或运行期类和类文件的转换
net.sf.cglib.proxy: 实现创建代理和方法拦截器的类
net.sf.cglib.reflect: 实现快速反射和C#风格代理的类
net.sf.cglib.util: 集合排序等工具类
net.sf.cglib.beans: JavaBean相关的工具类
本篇介绍通过MethodInterceptor和Enhancer实现一个动态代理。