package com.jat.demo4;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.Optional;


public class AccountRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Resource
    AccountRepository accountRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void queryBySpecification(){
        log.trace(" start test queryBySpecification");
        /**
         * 特别注意！！
         * 1 本方案需要extends , JpaSpecificationExecutor
         * 2 还需要编写一个实体类AccountSpecificationByName implements Specification<AccountEntity>
         */
        Long id=1L;
        String accountName="admin";
        String password="123456";
        AccountEntity accountEntity=new AccountEntity(id,accountName,password);
        log.info("当前保存前的实体是:{}",accountEntity);
        AccountEntity accountEntitySaved=accountRepository.save(accountEntity);//可以打断点看日志
        log.info("当前保存后的实体是:{}",accountEntitySaved);

        Specification<AccountEntity> accountSpecificationByName=new AccountSpecificationByName(accountName);
        Optional<AccountEntity> accountEntityQueryOptional=accountRepository.findOne(accountSpecificationByName);
        AccountEntity accountEntityQuery=accountEntityQueryOptional.orElse(null);
        log.info("当前查询的实体是:{}",accountEntityQuery);
        
        //分页查询排序
        //Sort sortByAddtime=Sort.by(Sort.Order.desc("addTime"));
		//Pageable pageable = PageRequest.of(pageIndex, pageSize,sortByAddtime);


    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void queryByExample(){
        log.trace(" start test queryByExample");
        /**
         * 特别注意本方案需要继承QueryByExampleExecutor，如果使用JpaRepository默认已经继承
         * 特别注意，使用Example查询时注意封装数据类型与原始数据类型区别！
         * 当是封装数据类型时不会自动增加查询条件，当是原始数据类型时由于有默认值会自动增加查询条件！
         * 如AccountEntity中有Long password,Long balance,Long id时只设置password这时候balance,id默认值为null所以查询时不会拼上这两个条件
         * 如AccountEntity中有long pwd,long balance,long id时只设置pwd这时balance,id会有默认值0，所以查询时会自动拼接上查询条件balance=0 and id=0!
         */
        Long id=1L;
        String accountName="admin";
        String password="123456";
        AccountEntity accountEntity=new AccountEntity(id,accountName,password);
        log.info("当前保存前的实体是:{}",accountEntity);
        AccountEntity accountEntitySaved=accountRepository.save(accountEntity);//可以打断点看日志
        log.info("当前保存后的实体是:{}",accountEntitySaved);

        AccountEntity queryAccountParameter=new AccountEntity();
        queryAccountParameter.setAccountName(accountName);
        Example<AccountEntity> queryByName=Example.of(queryAccountParameter);

        Optional<AccountEntity> accountEntityQueryOptional=accountRepository.findOne(queryByName);
        AccountEntity accountEntityQuery=accountEntityQueryOptional.orElse(null);
        log.info("当前查询的实体是:{}",accountEntityQuery);

    }



}
