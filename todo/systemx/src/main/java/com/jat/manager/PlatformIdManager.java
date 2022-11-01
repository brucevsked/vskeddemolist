package com.jat.manager;

import com.jat.repository.PlatformAccountRepository;
import com.jat.repository.PlatformCertificateRepository;
import com.jat.repository.PlatformUserRepository;

public class PlatformIdManager {
    private PlatformAccountRepository platformAccountRepository;
    private PlatformUserRepository platformUserRepository;

    private PlatformCertificateRepository platformCertificateRepository;

    public void setPlatformAccountRepository(PlatformAccountRepository platformAccountRepository) {
        this.platformAccountRepository = platformAccountRepository;
    }

    public void setPlatformUserRepository(PlatformUserRepository platformUserRepository) {
        this.platformUserRepository = platformUserRepository;
    }

    public void setPlatformCertificateRepository(PlatformCertificateRepository platformCertificateRepository) {
        this.platformCertificateRepository = platformCertificateRepository;
    }

    public Long nextAccountId(){
        return platformAccountRepository.nextId();
    }

    public Long nextUserId(){
        return platformUserRepository.nextId();
    }

    public Long nextCertificateId(){
        return platformCertificateRepository.nextId();
    }
}
