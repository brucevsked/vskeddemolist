package com.jat.manager;

import com.jat.bo.PlatformCertificate;
import com.jat.bo.PlatformUser;
import com.jat.bo.PlatformUserCertificate;
import com.jat.repository.PlatformUserCertificateRepository;

public class PlatformUserCertificateManager {

    private PlatformUserCertificateRepository platformUserCertificateRepository;

    public void setPlatformUserCertificateRepository(PlatformUserCertificateRepository platformUserCertificateRepository) {
        this.platformUserCertificateRepository = platformUserCertificateRepository;
    }

    public PlatformUserCertificate create(PlatformUser user, PlatformCertificate certificate){
        return new PlatformUserCertificate(user,certificate);
    }

    public PlatformUserCertificate save(PlatformUserCertificate platformUserCertificate){
        return platformUserCertificateRepository.save(platformUserCertificate);
    }
}
