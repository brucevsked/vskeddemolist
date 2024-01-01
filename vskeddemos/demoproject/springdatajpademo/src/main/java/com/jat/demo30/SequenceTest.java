package com.jat.demo30;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sequenceTest")
@Entity
public class SequenceTest implements Serializable {

    @Id
    @GeneratedValue(generator = "myIdGeneratorConfig",strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "myIdGeneratorConfig",strategy = "com.jat.demo30.Snowflake")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SequenceTest() {
    }
}
