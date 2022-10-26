package com.jat.service;

import com.jat.bo.PlatformUser;
import com.jat.manager.PlatformUserManager;

import java.time.LocalDate;

public class PlatformUserService {
    private PlatformUserManager platformUserManager;
    private PlatformIdService platformIdService;

    public void setPlatformUserManager(PlatformUserManager platformUserManager) {
        this.platformUserManager = platformUserManager;
    }

    public void setPlatformIdService(PlatformIdService platformIdService) {
        this.platformIdService = platformIdService;
    }

    public PlatformUser create(String name, LocalDate birthday){
        Long id=platformIdService.nextUserId();
        return new PlatformUser(id,name,birthday);
    }
}
