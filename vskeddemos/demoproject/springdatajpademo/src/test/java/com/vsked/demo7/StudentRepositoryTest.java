package com.vsked.demo7;

import com.vsked.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(StudentRepositoryTest.class);

    @Resource
    StudentRepository studentRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createStudent(){
        log.trace("start create student");
        long studentIdTemp=1008L;
        String studentNameTemp="老衲";
        StudentEntity studentEntity=new StudentEntity(studentIdTemp,studentNameTemp);
        studentRepository.save(studentEntity);
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createStudentWithCourse(){
        log.trace("start create createStudentWithCourse");
        long studentIdTemp=1008L;
        String studentNameTemp="老衲";

        Set<CourseEntity> courseSetTemp=new HashSet<>();

        long courseIdTemp1=1L;
        String courseNameTemp1="语文";
        CourseEntity courseEntityTemp1=new CourseEntity(courseIdTemp1,courseNameTemp1);
        courseSetTemp.add(courseEntityTemp1);
        long courseIdTemp2=2L;
        String courseNameTemp2="数学";
        CourseEntity courseEntityTemp2=new CourseEntity(courseIdTemp2,courseNameTemp2);
        courseSetTemp.add(courseEntityTemp2);
        long courseIdTemp3=3L;
        String courseNameTemp3="英语";
        CourseEntity courseEntityTemp3=new CourseEntity(courseIdTemp3,courseNameTemp3);
        courseSetTemp.add(courseEntityTemp3);
        StudentEntity studentEntity=new StudentEntity(studentIdTemp,studentNameTemp,courseSetTemp);
        studentRepository.save(studentEntity);
    }

}
