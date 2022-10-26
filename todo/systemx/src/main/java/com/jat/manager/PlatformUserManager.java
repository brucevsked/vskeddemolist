package com.jat.manager;

import com.jat.bo.PlatformUser;
import com.jat.repository.PlatformUserRepository;

import java.time.LocalDate;

public class PlatformUserManager {
    private PlatformUserRepository platformUserRepository;

    public void setPlatformUserRepository(PlatformUserRepository platformUserRepository) {
        this.platformUserRepository = platformUserRepository;
    }

    public PlatformUser create(Long id, String name, LocalDate birthday){
        return new PlatformUser(id,name,birthday);
    }
}
