package com.vsked.test;

import com.vsked.entity.Score;
import com.vsked.entity.Student;
import com.vsked.entity.StudentScore;
import com.vsked.entity.StudentScoreKey;
import com.vsked.repository.ScoreRepository;
import com.vsked.repository.StudentRepository;
import com.vsked.repository.StudentScoreRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentScoreRepositoryTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(StudentScoreRepositoryTest.class);

    @Autowired
    StudentScoreRepository studentScoreRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ScoreRepository scoreRepository;

    @Test
    public void test1(){
        Student student=new Student(1,"vsked");
        studentRepository.save(student);
        Score score=new Score(8,100);
        scoreRepository.save(score);
        StudentScoreKey studentScoreKey=new StudentScoreKey(1,8);
        StudentScore studentScore=new StudentScore(studentScoreKey);
        studentScoreRepository.save(studentScore);
    }


}
