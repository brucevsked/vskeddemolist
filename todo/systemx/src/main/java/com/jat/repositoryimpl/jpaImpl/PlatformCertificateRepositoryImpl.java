package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformCertificate;
import com.jat.po.PlatformCertificatePO;
import com.jat.repository.PlatformCertificateRepository;
import com.jat.repositoryimpl.jpa.IPlatformCertificateRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class PlatformCertificateRepositoryImpl implements PlatformCertificateRepository {

    @Resource
    IPlatformCertificateRepository iPlatformCertificateRepository;

    @Override
    public Long nextId() {
        Long id=iPlatformCertificateRepository.nextId();
        return id==null?1:id;
    }

    public PlatformCertificate poToBo(PlatformCertificatePO po){
        if(po==null){
            return null;
        }
        return new PlatformCertificate(po.getId(),po.getExpireTime());
    }

    public PlatformCertificatePO boToPo(PlatformCertificate bo){
        if(bo==null){
            return null;
        }
        return new PlatformCertificatePO(bo.getId().getId(),bo.getExpireTime().getDateTime());
    }
}
