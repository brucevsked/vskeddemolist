


http://localhost:8080/filterdemo



Java Web开发——Servlet监听器
一、Servlet监听器的概念

Servlet监听器是Servlet规范中定义的一种特殊类，用于监听ServletContext、HttpSession和ServletRequest等域对象的创建与销毁事件，以及监听这些域对象中属性发生修改的事件。

监听对象：

1、ServletContext：application，整个应用只存在一个

2、HttpSession：session，针对每一个对话

3、ServletRequest：request，针对每一个客户请求

监听内容：创建、销毁、属性改变事件

监听作用：可以在事件发生前、发生后进行一些处理，一般可以用来统计在线人数和在线用户、统计网站访问量、系统启动时初始化信息等。

二、监听器的基本使用

创建步骤：

1、创建一个实现监听器接口的类

2、配置web.xml文件，注册监听器

<listener>
    <listener-class>完整类名</listener-class>
</listener>
监听器的启动顺序：按照web.xml的配置顺序来启动

加载顺序：监听器>过滤器>Servlet

三、监听器的分类

3.1 按照监听的对象划分

1、用于监听应用程序环境对象(ServletContext)的事件监听器，实现ServletContextListener、ServletContextAttributeListener接口

2、用于监听用户会话对象(HttpSeesion)的事件监听器，实现HttpSessionListener、HttpSessionAttributeListener接口

3、用于监听请求消息对象(ServletRequest)的事件监听器，实现ServletRequestListener、ServletRequestAttributeListener接口

3.2按照监听事件划分

1、监听域对象自身的创建和销毁的事件监听器

根据监听对象不同分别实现ServletContextListener、HttpSessionListener、ServletRequestListener接口。 

①ServletContext的创建和销毁：contextInitialized方法和contextDestroyed方法

public void contextInitialized(ServletContextEvent sce)//ServletContext创建时调用
public void contextDestroyed(ServletContextEvent sce)//ServletContext销毁时调用
主要用途：作为定时器、加载全局属性对象、创建全局数据库连接、加载缓存信息等

实例：

在web.xml中可以配置项目初始化信息，在contextInitialized方法中进行启动

<context-param>
    <param-name>属性名</param-name>
    <param-value>属性值</param-value>
</context-param>
自定义监听器

复制代码
public class MyFirstListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent sce){
        //获取web.xml中配置的属性
        String value=sce.getServletContext().getInitParameter("属性名");
        System.out.println(value);
　　}
    public void contextDestroyed(ServletContextEvent sce){
        //关闭时操作
　　}
}
复制代码
 ②HttpSession的创建和销毁：sessionCreated和sessionDestroyed方法

public void sessionCreated(HttpSessionEvent se)//session创建时调用
public void sessionDestroyed(HttpSessionEvent se)//session销毁时调用
主要用途：统计在线人数、记录访问日志等

【注】

 web.xml配置session超时参数，单位：分，session超时的时间并不是精确的

<session-config>
    <session-timeout>10</session-timeout>
</session-config>
 ③ServletRequest的创建和销毁：requestInitialized和requestDestroyed方法

public void requestInitialized(ServletRequestEvent sre)//request创建时调用
public void requestDestroyed(ServletRequestEvent sre)//request销毁时调用
主要用途：读取request参数，记录访问历史

实例： 

复制代码
public class MySRequestListener implements SevletRequestListener{
    public void requestInitialized(ServletRequestEvent sre){
        String value=sre.getServletRequest().getParameter("key");//获取request中的参数
        System.out.println(value);
    }
    public void requestDestroyed(ServletRequestEvent sre){  
        System.out.println("request destroyed");
    }
}   
复制代码
  

2、监听域对象中的属性的增加和删除的事件监听器

　　根据监听对象不同分别实现ServletContextAttributeListener、HttpSessionAttributeListener、ServletRequestAttributeListener接口。

　　实现方法：attributeAdded、attributeRemoved、attributeReplaced

 

3、监听绑定到HttpSeesion域中的某个对象的状态的事件监听器(创建普通JavaBean)

　　HttpSession中的对象状态：绑定→解除绑定；钝化→活化

　　实现接口及方法：HttpSessionBindingListener接口(valueBound和valueUnbound方法)、HttpSessionActivationListener接口(sessionWillPassivate和sessionDidActivate方法)

【注1】①要实现钝化和活化必须实现Serializable接口

           ②不需要在web.xml中注册

【注2】

　　绑定：　　　　通过setAttribute保存到session对象当中

　　解除绑定：　　通过removeAttribue去除

　　钝化：　　　　将session对象持久化到存储设备上

　　活化：　　　　将session对象从存储设备上进行恢复

　　session钝化机制：

　　　　①把服务器不常使用的session对象暂时序列化到系统文件或者是数据库中，当使用时反序列化到内存中，整个过程由服务器自动完成；

　　　　②session的钝化机制由SessionManager管理，创建一个普通的JavaBean绑定和接触需要实现HttpSessionBindingListener接口

四、Servlet3.0下监听器的使用

4.1 使用条件

　　1、使用servlet3.0新标准的jar包

　　2、JDK在1.6以上版本

　　3、编译器的编译级别为6.0

　　4、在web.xml文件中，使用3.0规范

　　5、使用支持servlet3.0特性的web容器，比如tomcat7

4.2 servlet3.0下监听器的用法

使用注解 @WebListener 即可，无法去定义监听器的顺序

@WebListener的常用属性
属性名	类型	是否可选	描述
value	String	是	该监听器的描述信息
@WebListener("This is a listener")
public class FirstListener impliements ServletRequestListener{}
该注解用于将类声明为监听器，被 @WebListener 标注的类必须实现以下至少一个接口：

　　ServletContextListener

　　ServletContextAttributeListener

　　ServletRequestListener

　　ServletRequestAttributeListener

　　HttpSessionListener

　　HttpSessionAttributeListener

 