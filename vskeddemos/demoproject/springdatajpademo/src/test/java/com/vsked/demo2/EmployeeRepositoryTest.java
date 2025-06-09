package com.vsked.demo2;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(EmployeeRepositoryTest.class);

    @Resource
    EmployeeRepository employeeRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){
        log.trace(" start test create");
        Long eid=1L;
        String employeeName="张三";
        EmployeeEntity employeeEntity=new EmployeeEntity(eid,employeeName);
        log.info("当前保存前的实体是:{}",employeeEntity);
        EmployeeEntity employeeEntitySaved=employeeRepository.save(employeeEntity);
        log.info("当前保存后的实体是:{}",employeeEntitySaved);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void findAllForSort(){
        log.trace(" start test read");
        List<EmployeeEntity> employeeEntityListSave=new LinkedList<>();
        for(int i=0;i<20;i++){
            Long eidTemp=new Long(i);
            String employeeNameTemp="员工"+i;
            EmployeeEntity employeeEntityTemp=new EmployeeEntity(eidTemp,employeeNameTemp);
            employeeEntityListSave.add(employeeEntityTemp);
        }

        employeeRepository.saveAll(employeeEntityListSave);//保存员工列表

        List<EmployeeEntity> employeeEntityListFindAll=new LinkedList<>();

        Sort employeeSort=Sort.by("eid").descending();//复合用法Sort.by("eid").descending().and(Sort.by("employeeName").ascending())
        employeeEntityListFindAll= (List<EmployeeEntity>) employeeRepository.findAll(employeeSort);
        log.info("当前找的实体集合是:{}",employeeEntityListFindAll);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void findAllForPage(){
        log.trace(" start test read");
        List<EmployeeEntity> employeeEntityListSave=new LinkedList<>();
        for(int i=0;i<200;i++){
            Long eidTemp=new Long(i);
            String employeeNameTemp="员工"+i;
            EmployeeEntity employeeEntityTemp=new EmployeeEntity(eidTemp,employeeNameTemp);
            employeeEntityListSave.add(employeeEntityTemp);
        }

        employeeRepository.saveAll(employeeEntityListSave);//保存员工列表

        Page<EmployeeEntity> employeeEntityPage;
        int page=3;//当前页
        int size=10;
        Pageable pageable= PageRequest.of(page,size);//这里还有增型用法，后面再加一个排序参数

        employeeEntityPage=employeeRepository.findAll(pageable);

        log.info("总记录数是:{}",employeeEntityPage.getTotalElements());
        log.info("总页数是:{}",employeeEntityPage.getTotalPages());
        log.info("当前页是:{}",employeeEntityPage.getNumber());
        log.info("一页显示记录数:{}",employeeEntityPage.getSize());


        List<EmployeeEntity> employeeEntityList=employeeEntityPage.getContent();
        log.info("当前找的实体集合是:{}",employeeEntityList);
    }

}
