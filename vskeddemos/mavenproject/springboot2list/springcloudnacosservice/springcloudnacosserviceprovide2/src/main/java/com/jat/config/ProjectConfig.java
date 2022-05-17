package com.jat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class ProjectConfig {

    @Value("${project.id}")
    public int id;
    @Value("${project.name}")
    public String name;

    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + "\"" +
                "}";
    }
}
