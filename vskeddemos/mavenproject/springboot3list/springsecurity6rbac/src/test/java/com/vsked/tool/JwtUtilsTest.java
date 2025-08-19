package com.vsked.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class JwtUtilsTest {
    private static final Logger log = LoggerFactory.getLogger(JwtUtilsTest.class);

    @Test
    public void generateTokenWithUserNameAndId(){
        String username = "admin";
        String userId = "ss6";
        String token = JwtUtils.generateToken(username,userId);
        log.info("{}", token);
    }

    @Test
    public void generateToken(){
        String username = "admin";
        String token = JwtUtils.generateToken(username);
        log.info("{}", token);
    }

    @Test
    public void parseUsername(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJJZCI6InNzNiIsImV4cCI6MTc1NTUyOTAyOX0.XM80UV9eAIjC5mI-59EYZ16BtTCJ-GZSg7i0UH-p3UiEwN2qZ-GQMBfVOyyFI5xCqBORSvBnupYJF6pJ2eiqHg";
        String username = JwtUtils.parseUsername(token);
        log.info("{}", username);
    }

    @Test
    public void parseUserId(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJJZCI6InNzNiIsImV4cCI6MTc1NTUyOTAyOX0.XM80UV9eAIjC5mI-59EYZ16BtTCJ-GZSg7i0UH-p3UiEwN2qZ-GQMBfVOyyFI5xCqBORSvBnupYJF6pJ2eiqHg";
        String userId = JwtUtils.parseUserId(token);
        log.info("{}", userId);
    }

    @Test
    public void validateToken(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJJZCI6InNzNiIsImV4cCI6MTc1NTUyOTAyOX0.XM80UV9eAIjC5mI-59EYZ16BtTCJ-GZSg7i0UH-p3UiEwN2qZ-GQMBfVOyyFI5xCqBORSvBnupYJF6pJ2eiqHg";
        boolean result = JwtUtils.validateToken(token);
        log.info("{}", result);
    }
}
