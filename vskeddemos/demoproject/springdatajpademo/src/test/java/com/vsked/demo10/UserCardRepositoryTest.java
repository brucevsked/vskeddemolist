package com.vsked.demo10;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.Optional;

public class UserCardRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserCardRepositoryTest.class);

    @Resource
    UserCardRepository userCardRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save(){
        Long userId=1L;
        Long cardId=1001L;
        UserCardPO userCardPO=new UserCardPO(userId,cardId);
        userCardRepository.save(userCardPO);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void save2(){
        for(int i=1;i<10;i++){
            Long userId=1L+i;
            Long cardId=1001L+i;
            UserCardPO userCardPO=new UserCardPO(userId,cardId);
            userCardRepository.save(userCardPO);
        }

    }

    @Test
    public void query1(){
        log.trace("根据用户编号找数据");
        Long userIdQuery=1L;
        UserCardPO userCardPOQuery=new UserCardPO();
        userCardPOQuery.setUserId(userIdQuery);
        Example<UserCardPO> userCardPOExample=Example.of(userCardPOQuery);
        Optional<UserCardPO> userCardPOOptional=userCardRepository.findOne(userCardPOExample);
        if(userCardPOOptional.isPresent()){
            UserCardPO ucp=userCardPOOptional.get();
            log.info("当前数据是:{}",ucp);
        }else {
            log.info("没找到需要的数据");
        }
    }

    @Test
    public void query2(){
        log.trace("根据卡号找数据");
        Long cardIdQuery=1001L;
        UserCardPO userCardPOQuery=new UserCardPO();
        userCardPOQuery.setCardId(cardIdQuery);
        Example<UserCardPO> userCardPOExample=Example.of(userCardPOQuery);
        Optional<UserCardPO> userCardPOOptional=userCardRepository.findOne(userCardPOExample);
        if(userCardPOOptional.isPresent()){
            UserCardPO ucp=userCardPOOptional.get();
            log.info("当前数据是:{}",ucp);
        }else {
            log.info("没找到需要的数据");
        }
    }



}
