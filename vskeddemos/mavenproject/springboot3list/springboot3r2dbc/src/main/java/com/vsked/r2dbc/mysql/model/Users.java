package com.vsked.r2dbc.mysql.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record Users(
        @Id
        Integer id,
        @Column(value = "userName")
        String userName,
        String password
){}
