package com.vsked.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "score")
@Entity
public class Score {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "score")
    private int score;

    public Score() {
    }

    public Score(long id, int score) {
        this.id = id;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
