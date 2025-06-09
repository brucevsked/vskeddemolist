package com.vsked.demo21;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(HumanRepositoryTest.class);

    @Resource
    HumanRepository humanRepository;

    @Test
    public void queryTest(){
        Set<Human> humans=new HashSet<>();
        Human human1=new Human(1L,"张三");
        Human human2=new Human(2L,"李四");
        Human human3=new Human(3L,"唐三");
        Human human4=new Human(4L,"孙悟空");
        Human human5=new Human(5L,"一灯");
        Human human6=new Human(6L,"牛魔王");
        Human human7=new Human(7L,"赵云");
        Human human8=new Human(8L,"马可波罗");
        Human human9=new Human(9L,"后羿");
        Human human10=new Human(10L,"武则天");

        humans.add(human1);
        humans.add(human2);
        humans.add(human3);
        humans.add(human4);
        humans.add(human5);
        humans.add(human6);
        humans.add(human7);
        humans.add(human8);
        humans.add(human9);
        humans.add(human10);

        humanRepository.saveAll(humans);

        Set<Long> humanIds=new HashSet<>();
        humanIds.add(3L);
        humanIds.add(6L);
        humanIds.add(9L);
        List<Human> humanList=humanRepository.findAllById(humanIds);
        log.debug("{}",humanList);
    }

}
