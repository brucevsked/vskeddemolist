package com.jat.demo2;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 通过定义一个接口，为这个接口定义好方法，<br>
 * 动态定义一个实现类，通过接口来调用实现类中方法<br>
 */
public class WebUserTest {

    private static final Logger log = LoggerFactory.getLogger(WebUserTest.class);

    @Test
    public void createWebUserImplementsUser(){
        try {
            ClassPool pool = ClassPool.getDefault();
            // 1. 创建一个空类
            CtClass cc = pool.makeClass("com.jat.demo2.WebUser");
            // 2. 新增一个字段 private String name;
            // 字段名为name
            CtField param = new CtField(pool.get("java.lang.String"), "name", cc);
            // 访问级别是 private
            param.setModifiers(Modifier.PRIVATE);
            // 初始值是 "xiaoming"
            cc.addField(param, CtField.Initializer.constant("xiaoming"));
            // 3. 生成 getter、setter 方法
            cc.addMethod(CtNewMethod.setter("setName", param));
            cc.addMethod(CtNewMethod.getter("getName", param));
            // 4. 添加无参的构造函数
            CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
            cons.setBody("{name = \"默认名字在这儿\";}");
            cc.addConstructor(cons);

            // 5. 添加有参的构造函数
            cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, cc);
            // $0=this / $1,$2,$3... 代表方法参数
            cons.setBody("{$0.name = $1;}");
            cc.addConstructor(cons);

            // 6. 创建一个名为printName方法，无参数，无返回值，输出name值
            CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, cc);
            ctMethod.setModifiers(Modifier.PUBLIC);
            ctMethod.setBody("{System.out.println(name);}");
            cc.addMethod(ctMethod);
            // 获取接口
            CtClass userInterface = pool.get("com.jat.demo2.User");

            // 获取上面生成的类
            CtClass webUserClass = pool.get("com.jat.demo2.WebUser");
            // 使代码生成的WebUser类，实现 User 接口=implements User
            webUserClass.setInterfaces(new CtClass[]{userInterface});

            User webUser=(User)webUserClass.toClass().newInstance();
            System.out.println(webUser.getName());
            webUser.setName("小妹妹，一起玩呀");
            webUser.printName();

        } catch (Exception e) {
            log.error("测试有异常啦", e);
        }
    }
}
