package com.vsked.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentScoreKey implements Serializable {

    private long studentId;

    private long scoreId;

    public StudentScoreKey() {
    }

    public StudentScoreKey(long studentId, long scoreId) {
        this.studentId = studentId;
        this.scoreId = scoreId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
    }
}
