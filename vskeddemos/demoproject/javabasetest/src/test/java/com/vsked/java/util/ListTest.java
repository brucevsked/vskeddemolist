package com.vsked.java.util;

import com.vsked.test.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * list是有序的
 */
public class ListTest {

    private static final Logger log = LoggerFactory.getLogger(ListTest.class);

    /**
     * 所有已知实现类：
     * AbstractList， AbstractSequentialList，
     * ArrayList， AttributeList，
     * CopyOnWriteArrayList， LinkedList，
     * RoleList， RoleUnresolvedList，
     * Stack， Vector
     */
    @Test
    public void linkListTest() {


         // 常用的有两种
         // LinkedList 场景：频繁插入数据或删除数据
         // ArrayList 场景：只用来查询，数据变化不大，不需要频繁插入删除


        LinkedList<UserEntity> userEntityLinkedList=new LinkedList<>();
        for(int i=0;i<20;i++){
            UserEntity userEntityTemp=new UserEntity((long) i,"user"+i);
            userEntityLinkedList.add(userEntityTemp);
        }
        log.info("{}",userEntityLinkedList.size());
        log.info("当前是有顺序的:{}",userEntityLinkedList);//可以在这里打个断点看下内存中是否有序
        
    }

    @Test
    public void remove(){

        LinkedList<UserEntity> userEntityLinkedList=new LinkedList<>();
        for(int i=0;i<10;i++){
            UserEntity userEntityTemp=new UserEntity((long) i,"user"+i);
            userEntityLinkedList.add(userEntityTemp);
        }

        long deleteUserId=6L;
        Iterator<UserEntity> it=userEntityLinkedList.iterator();
        UserEntity user;
        while(it.hasNext()){
            user=it.next();
            if(user.getUid() ==deleteUserId){
                it.remove(); //注意这里用法
            }
        }

        log.info("当前是有顺序的:{}",userEntityLinkedList);//可以在这里打个断点看下内存中是否有序
    }

}
