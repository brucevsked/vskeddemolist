package com.vsked.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("role")
public record Role (
        @Id
        long id,
        String name
){}
