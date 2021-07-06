package com.vsked.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "studentScore")
@Entity
public class StudentScore {

    @EmbeddedId
    StudentScoreKey studentScoreKey;

    public StudentScore() {
    }

    public StudentScore(StudentScoreKey studentScoreKey) {
        this.studentScoreKey = studentScoreKey;
    }

    public StudentScoreKey getStudentScoreKey() {
        return studentScoreKey;
    }

    public void setStudentScoreKey(StudentScoreKey studentScoreKey) {
        this.studentScoreKey = studentScoreKey;
    }
}
