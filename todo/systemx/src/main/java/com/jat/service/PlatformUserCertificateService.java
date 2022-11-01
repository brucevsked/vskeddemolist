package com.jat.service;

import com.jat.bo.PlatformCertificate;
import com.jat.bo.PlatformUser;
import com.jat.bo.PlatformUserCertificate;
import com.jat.manager.PlatformUserCertificateManager;

public class PlatformUserCertificateService {
    private PlatformUserCertificateManager platformUserCertificateManager;

    public void setPlatformUserCertificateManager(PlatformUserCertificateManager platformUserCertificateManager) {
        this.platformUserCertificateManager = platformUserCertificateManager;
    }

    public PlatformUserCertificate create(PlatformUser user, PlatformCertificate certificate){
        return platformUserCertificateManager.create(user,certificate);
    }

    public PlatformUserCertificate save(PlatformUserCertificate platformUserCertificate){
        return platformUserCertificateManager.save(platformUserCertificate);
    }
}
