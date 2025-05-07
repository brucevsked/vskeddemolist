package com.vsked.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("menu")
public record Menu(
        @Id
        long id,
        String name,
        int type,
        String url,
        Long parent_id
) {}
