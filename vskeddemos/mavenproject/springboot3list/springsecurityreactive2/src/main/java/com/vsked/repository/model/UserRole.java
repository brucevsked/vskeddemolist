package com.vsked.repository.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("user_role")
public record UserRole (
        long userId,
        long roleId
){}
