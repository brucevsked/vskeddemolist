package com.vsked.repository.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("role_menu")
public record RoleMenu(
        @Column("role_id")
        long role_id,
        @Column("menu_id")
        long menu_id
) {}
