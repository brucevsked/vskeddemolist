package com.jat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Plan1 {

    @Value("${server.port}")
    public int port;

    @Value("${project.name}")
    public String name;

    public String toString() {
        return "{" +
                "\"port\":" + port +
                ", \"name\":\"" + name + "\"" +
                "}";
    }
}
