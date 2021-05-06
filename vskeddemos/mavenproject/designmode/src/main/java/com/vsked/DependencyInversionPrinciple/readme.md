依赖倒转（倒置）原则（Dependence Inversion Principle）

基本介绍
高层模块不应该依赖低层模块，二者都应该依赖其抽象
抽象（接口/抽象类）不应该依赖细节（类），细节应该依赖抽象
依赖倒转（倒置）的中心思想是面向接口编程
依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建的架构比以细节为基础的架构要稳定的多。在java中，抽象指的是接口或抽象类，细节就是具体的实现类。
使用接口或抽象类的目的是：制定好规范，而不涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成。




有一个手机Phone，手机上面有多个APP，每个APP有自己的打开方式。
 Client是客户端，需要创建Phone实例、TaoBao、QQ等应用实例然后调用应用的打开方法
 
 old旧版本设计不用依赖
 这种方式可以完成需求，但是不利于扩展。比如现在手机安装了一个WeiXin，那么就要加一个WeiXin类，而且Phone类中还要添加WeiXin的打开方法。
 
 解决方式：遵循依赖倒置原则设计程序
 
 遵循依赖倒置原则分析
 现在Phone与每一个具体的APP（QQ,TaoBao...）之间没有了直接的关系，如果要下载一个微信，只需要写一个WeiXin类去实现App接口并实现其open()方法即可。
 
 不论增加或减少多少个App，都不会再改变Phone类。
 

 简单一句话说：在开发过程中尽可能的依赖抽象层（接口/抽象类）而不是依赖实现层（类）。
 
 这样可以很好地提高程序的扩展性和维护性。
依赖关系传递的三种方式
接口传递
上面的例子使用的就是接口传递方式
构造方法传递
修改Phone为构造方法传递即可：
class Phone{
    private App app;
 
    public Phone(App app){
        this.app = app;
    }
 
    public void openApp(){
        this.app.open();
    }
}

setter方式传递
修改Phone为settrt方式传递即可
class Phone{
    private App app;
 
    public void setPhone(App app){
        this.app = app;
    }
 
    public void openApp(){
        if(this.app != null){
            this.app.open();
        }
    }
}

依赖倒置原则的注意事项和细节
低层模块尽量都要有抽象类或接口，或者两者都有，程序稳定性更好。
变量的声明类型尽量是抽象类或接口，这样我们的变量引用和实际对象间，就存在一个缓冲层，利于程序扩展和优化。
继承时遵循里氏替换原则

————————————————
版权声明：本文为CSDN博主「yangxinhu_coder」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_42425970/article/details/97298814