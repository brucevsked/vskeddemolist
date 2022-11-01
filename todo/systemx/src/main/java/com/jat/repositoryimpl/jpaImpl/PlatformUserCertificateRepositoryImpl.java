package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformCertificate;
import com.jat.bo.PlatformUser;
import com.jat.bo.PlatformUserCertificate;
import com.jat.po.PlatformCertificatePO;
import com.jat.po.PlatformUserCertificatePO;
import com.jat.po.PlatformUserPO;
import com.jat.repository.PlatformUserCertificateRepository;
import com.jat.repositoryimpl.jpa.IPlatformUserCertificateRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class PlatformUserCertificateRepositoryImpl implements PlatformUserCertificateRepository {

    @Resource
    IPlatformUserCertificateRepository iPlatformUserCertificateRepository;
    @Resource
    PlatformUserRepositoryImpl platformUserRepository;
    @Resource
    PlatformCertificateRepositoryImpl platformCertificateRepository;

    @Override
    public PlatformUserCertificate save(PlatformUserCertificate platformUserCertificate) {
        PlatformUserCertificatePO po=boToPo(platformUserCertificate);
        po=iPlatformUserCertificateRepository.save(po);
        return poToBo(po);
    }

    public PlatformUserCertificate poToBo(PlatformUserCertificatePO po){
        if(po==null){
            return null;
        }

        PlatformUser user=platformUserRepository.poToBo(po.getUser());
        PlatformCertificate certificate=platformCertificateRepository.poToBo(po.getCertificate());
        return new PlatformUserCertificate(user,certificate);
    }

    public PlatformUserCertificatePO boToPo(PlatformUserCertificate bo){
        if(bo==null){
            return null;
        }

        PlatformUserPO userPO=platformUserRepository.boToPo(bo.getPlatformUser());
        PlatformCertificatePO certificatePO=platformCertificateRepository.boToPo(bo.getPlatformCertificate());
        return new PlatformUserCertificatePO(userPO,certificatePO);
    }
}
