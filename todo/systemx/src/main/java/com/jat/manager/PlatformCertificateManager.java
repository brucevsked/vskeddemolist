package com.jat.manager;

import com.jat.bo.PlatformCertificate;
import com.jat.repository.PlatformCertificateRepository;


public class PlatformCertificateManager {

    private PlatformCertificateRepository platformCertificateRepository;

    public void setPlatformCertificateRepository(PlatformCertificateRepository platformCertificateRepository) {
        this.platformCertificateRepository = platformCertificateRepository;
    }

    public PlatformCertificate create(Long id){
        return new PlatformCertificate(id);
    }


}
