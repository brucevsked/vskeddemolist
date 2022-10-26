package com.jat.manager;

import com.jat.repository.PlatformAccountRepository;
import com.jat.repository.PlatformUserRepository;

public class PlatformIdManager {
    private PlatformAccountRepository platformAccountRepository;
    private PlatformUserRepository platformUserRepository;

    public void setPlatformAccountRepository(PlatformAccountRepository platformAccountRepository) {
        this.platformAccountRepository = platformAccountRepository;
    }

    public void setPlatformUserRepository(PlatformUserRepository platformUserRepository) {
        this.platformUserRepository = platformUserRepository;
    }

    public Long nextAccountId(){
        return platformAccountRepository.nextId();
    }

    public Long nextUserId(){
        return platformUserRepository.nextId();
    }
}
