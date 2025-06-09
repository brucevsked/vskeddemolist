package com.vsked.demo6;


import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class SchoolRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(SchoolRepositoryTest.class);

    @Resource
    SchoolRepository schoolRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createSchool(){
        log.trace(" start test create");
        long schoolId=19L;
        String schoolName="大力技术学校";
        SchoolEntity schoolEntity=new SchoolEntity(schoolId,schoolName);
        log.info("当前保存前的实体是:{}",schoolEntity);
        schoolRepository.save(schoolEntity);//可以打断点看日志

    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createSchoolWithGrade(){
        log.trace(" start test create");
        long gradeId=8L;
        String gradeName="1年级";
        GradeEntity gradeEntity=new GradeEntity(gradeId,gradeName);
        log.info("当前保存前的实体是:{}",gradeEntity);
        Set<GradeEntity> gradeEntitySet=new HashSet<>();
        gradeEntitySet.add(gradeEntity);

        long gradeId1=9L;
        String gradeName1="2年级";
        GradeEntity gradeEntity1=new GradeEntity(gradeId1,gradeName1);
        log.info("当前保存前的实体是:{}",gradeEntity1);
        gradeEntitySet.add(gradeEntity1);

        long schoolId=19L;
        String schoolName="大力技术学校";
        SchoolEntity schoolEntity=new SchoolEntity(schoolId,schoolName,gradeEntitySet);
        log.info("当前保存前的实体是:{}",schoolEntity);
        schoolRepository.save(schoolEntity);//可以打断点看日志

    }

}
