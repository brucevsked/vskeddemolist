package com.jat.demo3;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PersonServiceModifyTest {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceModifyTest.class);

    @Test
    public void modifyTest(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.jat.demo3.PersonService");

            CtMethod personFly = cc.getDeclaredMethod("personFly");
            /**
             * 需要注意的是：上面的insertBefore() insertAfter(), setBody()中的语句，
             * 如果你是单行语句可以直接用双引号，但是有多行语句的情况下，你需要将多行语句用{}括起来。javassist只接受单个语句或用大括号括起来的语句块。
             */
            personFly.insertBefore("System.out.println(\"起飞之前准备降落伞\");");
            personFly.insertAfter("System.out.println(\"成功落地。。。。\");");


            //新增一个方法
            CtMethod ctMethod = new CtMethod(CtClass.voidType, "joinFriend", new CtClass[]{}, cc);
            ctMethod.setModifiers(Modifier.PUBLIC);
            ctMethod.setBody("{System.out.println(\"新增方法:我们还是好朋友，友谊小船没有翻\");}");
            cc.addMethod(ctMethod);

            Object person = cc.toClass().newInstance();
            // 调用 personFly 方法
            Method personFlyMethod = person.getClass().getMethod("personFly");
            personFlyMethod.invoke(person);
            //调用 joinFriend 方法
            Method execute = person.getClass().getMethod("joinFriend");
            execute.invoke(person);
        }catch (Exception e){
            log.error("测试有异常啦", e);
        }
    }
}
