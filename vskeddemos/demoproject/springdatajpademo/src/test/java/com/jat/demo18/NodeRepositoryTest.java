package com.jat.demo18;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class NodeRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(NodeRepositoryTest.class);

    @Resource
    NodeRepository nodeRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createRoot(){
        Long id=1L;
        String name="太极";
        Integer level=1;
        Node rootNode=new Node(id,name,level);
        nodeRepository.save(rootNode);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createChild(){
        Long id=1L;
        String name="太极";
        Integer level=1;
        Node rootNode=new Node(id,name,level);

        Long id1=101L;
        String name1="阴";
        Integer level1=2;
        Node nodeLeft1=new Node(id1,name1,level1);
        nodeLeft1.setParent(rootNode);//设置上级

        Set<Node> left1Childs=new HashSet<>();

        Long id1a=10101L;
        String name1a="少阴";
        Integer level1a=3;
        Node nodeLeft1a=new Node(id1a,name1a,level1a);
        nodeLeft1a.setParent(nodeLeft1);
        left1Childs.add(nodeLeft1a);

        Long id1b=10102L;
        String name1b="太阴";
        Integer level1b=3;
        Node nodeLeft1b=new Node(id1b,name1b,level1b);
        nodeLeft1b.setParent(nodeLeft1);
        left1Childs.add(nodeLeft1b);

        nodeLeft1.setChilds(left1Childs);

        Long id2=201L;
        String name2="阳";
        Integer level2=2;
        Node nodeRight1=new Node(id2,name2,level2);
        nodeRight1.setParent(rootNode);//设置上级

        Set<Node> right1Childs=new HashSet<>();

        Long id2a=20101L;
        String name2a="少阳";
        Integer level2a=3;
        Node nodeRight1a=new Node(id2a,name2a,level2a);
        nodeRight1a.setParent(nodeRight1);//设置上级
        right1Childs.add(nodeRight1a);

        Long id2b=20102L;
        String name2b="太阳";
        Integer level2b=3;
        Node nodeRight1b=new Node(id2b,name2b,level2b);
        nodeRight1b.setParent(nodeRight1);//设置上级
        right1Childs.add(nodeRight1b);

        nodeRight1.setChilds(right1Childs);

        Set<Node> childs=new HashSet<>();
        childs.add(nodeLeft1);
        childs.add(nodeRight1);

        rootNode.setChilds(childs);
        nodeRepository.save(rootNode);
    }

    @Test
    public void query(){
        Node root=nodeRepository.getById(1L);
        log.debug("{}",root.getParent());
        log.debug("{}",root.getChilds());
        Node leftNode=nodeRepository.getById(101L);
        log.debug("{}",leftNode);
        log.debug("{}",leftNode.getParent());
        log.debug("{}",leftNode.getChilds());
        Node leftNodea=nodeRepository.getById(10101L);
        log.debug("{}",leftNodea);
        log.debug("{}",leftNodea.getParent());
        log.debug("{}",leftNodea.getChilds());
    }

    @Test
    public void query2(){

        Node leftNode=nodeRepository.getById(101L);
        log.debug("{}",leftNode);
        log.debug("{}",leftNode.getParent());
        log.debug("{}",leftNode.getChilds());

    }
}
