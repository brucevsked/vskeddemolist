package com.jat.demo1;

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

import java.lang.reflect.Method;

/**
 * 无中生有，测试新生成一个类<br>
 *     这种方案会生成一个实体的class文件，再通过这个文件实例化类<br>
 */
public class CreateNewClassWithFileTest {

    private static final Logger log = LoggerFactory.getLogger(CreateNewClassWithFileTest.class);

    @Test
    public void create() {
        try {
            ClassPool pool = ClassPool.getDefault();
            // 1. 创建一个空类
            CtClass cc = pool.makeClass("com.jat.demo1.User");
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
            cons.setBody("{name = \"xiaohong\";}");
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
            //这里会将这个创建的类对象编译为.class文件
            cc.writeFile("/logs/");

            ClassPool executePool = ClassPool.getDefault();
            // 设置类路径
            executePool.appendClassPath("/logs/");
            CtClass ctClass = executePool.get("com.jat.demo1.User");
            Object person = ctClass.toClass().newInstance();
            // 设置值
            Method setName = person.getClass().getMethod("setName", String.class);
            setName.invoke(person, "老衲");
            // 输出值
            Method execute = person.getClass().getMethod("printName");
            execute.invoke(person);


        } catch (Exception e) {
            log.error("测试有异常啦", e);
        }
    }

}
