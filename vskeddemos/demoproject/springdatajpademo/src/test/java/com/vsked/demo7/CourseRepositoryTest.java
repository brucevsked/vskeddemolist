package com.vsked.demo7;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(CourseRepositoryTest.class);

    @Resource
    CourseRepository courseRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createCourse(){
        log.trace("start create createCourse");
        long idTemp=4L;
        String nameTemp="物理";
        CourseEntity course=new CourseEntity(idTemp,nameTemp);
        courseRepository.save(course);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createCourseWithStudent(){
        log.trace("start create createCourseWithStudent");
        long idTemp=4L;
        String nameTemp="物理";

        Set<StudentEntity> studentSetTemp=new HashSet<>();

        long studentIdTemp1=2001L;
        String studentNameTemp1="张三";
        StudentEntity studentTemp1=new StudentEntity(studentIdTemp1,studentNameTemp1);
        studentSetTemp.add(studentTemp1);
        long studentIdTemp2=2002L;
        String studentNameTemp2="刘备";
        StudentEntity studentTemp2=new StudentEntity(studentIdTemp2,studentNameTemp2);
        studentSetTemp.add(studentTemp2);
        long studentIdTemp3=2003L;
        String studentNameTemp3="任你行你最行";
        StudentEntity studentTemp3=new StudentEntity(studentIdTemp3,studentNameTemp3);
        studentSetTemp.add(studentTemp3);

        CourseEntity course=new CourseEntity(idTemp,nameTemp,studentSetTemp);
        courseRepository.save(course);

    }

}
