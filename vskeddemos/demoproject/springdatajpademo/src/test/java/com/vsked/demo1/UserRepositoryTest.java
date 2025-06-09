package com.vsked.demo1;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.Optional;

public class UserRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Resource
    UserRepository userRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){
        log.trace(" start test create");
        Long uid=1L;
        String userName="user1";
        UserEntity userEntity=new UserEntity(uid,userName);
        log.info("当前保存前的实体是:{}",userEntity);
        UserEntity userEntitySaved=userRepository.save(userEntity);
        log.info("当前保存后的实体是:{}",userEntitySaved);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void read(){
        log.trace(" start test read");
        Long uid=1L;
        String userName="user1";
        UserEntity userEntity=new UserEntity(uid,userName);
        log.info("当前保存前的实体是:{}",userEntity);
        UserEntity userEntitySaved=userRepository.save(userEntity); //先加一个用户实体
        log.info("当前保存后的实体是:{}",userEntitySaved);

        Long readUid=2L; //查查找的用户唯一标识
        Optional<UserEntity> userEntityOptional=userRepository.findById(readUid);
        UserEntity userEntityRead=userEntityOptional.orElse(null);//如果有用户实体就返回用户实体，没有就返回null
        log.info("当前找的实体是:{}",userEntityRead);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void update(){
        log.trace(" start test update");
        Long uid=1L;
        String userName="user1";
        UserEntity userEntity=new UserEntity(uid,userName);
        log.info("当前保存前的实体是:{}",userEntity);
        UserEntity userEntitySaved=userRepository.save(userEntity); //先加一个用户实体
        log.info("当前保存后的实体是:{}",userEntitySaved);

        String userNameNew="user1NewNameJack";//更新手用户名
        UserEntity userEntityNew=new UserEntity(uid,userNameNew);
        log.info("更新前要保存的实体是:{}",userEntityNew);
        UserEntity userEntitySavedNew=userRepository.save(userEntityNew);
        log.info("更新后已经保存的实体是:{}",userEntitySavedNew);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void delete(){
        log.trace(" start test update");
        Long uid=1L;
        String userName="user1";
        UserEntity userEntity=new UserEntity(uid,userName);
        log.info("当前保存前的实体是:{}",userEntity);
        UserEntity userEntitySaved=userRepository.save(userEntity); //先加一个用户实体
        log.info("当前保存后的实体是:{}",userEntitySaved);

        Optional<UserEntity> userEntityOptionalBefore=userRepository.findById(uid);
        UserEntity userEntityReadBefore=userEntityOptionalBefore.orElse(null);//如果有用户实体就返回用户实体，没有就返回null
        log.info("删除前当前找的实体是:{}",userEntityReadBefore);

        log.warn("准备执行删除操作，要删除的对象唯一标识：{}",uid);
        userRepository.deleteById(uid);
        log.warn("删除操作执行完成，已经删除实体的唯一标识是：{}",uid);

        Optional<UserEntity> userEntityOptionalAfter=userRepository.findById(uid);
        UserEntity userEntityReadAfter=userEntityOptionalAfter.orElse(null);//如果有用户实体就返回用户实体，没有就返回null
        log.info("删除后当前找的实体是:{}",userEntityReadAfter);
    }
}
