package com.jat.service;

import com.jat.bo.PlatformCertificate;
import com.jat.manager.PlatformCertificateManager;

public class PlatformCertificateService {

    private PlatformCertificateManager platformCertificateManager;
    private PlatformIdService platformIdService;

    public void setPlatformCertificateManager(PlatformCertificateManager platformCertificateManager) {
        this.platformCertificateManager = platformCertificateManager;
    }

    public void setPlatformIdService(PlatformIdService platformIdService) {
        this.platformIdService = platformIdService;
    }

    public PlatformCertificate create(){
        Long id=platformIdService.nextCertificateId();
        return platformCertificateManager.create(id);
    }
}
