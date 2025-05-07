package com.vsked.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
public record User (
        @Id
        long id,
        String name,
        String password,
        String email,
        boolean active
){}
