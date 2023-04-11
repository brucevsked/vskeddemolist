package com.jat.model.business;

public class Parameter {
    private Integer id;
    private String name;
    private Integer sequence;
    private DateType dateType;

    public Parameter(Integer id, String name, Integer sequence, DateType dateType) {
        this.id = id;
        this.name = name;
        this.sequence = sequence;
        this.dateType = dateType;
    }
}
