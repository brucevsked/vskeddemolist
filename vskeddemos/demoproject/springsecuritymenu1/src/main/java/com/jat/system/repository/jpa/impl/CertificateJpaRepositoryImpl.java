package com.jat.system.repository.jpa.impl;

import com.jat.system.model.Certificate;
import com.jat.system.repository.CertificateRepository;
import com.jat.system.repository.jpa.ICertificateJpaRepository;
import com.jat.system.repository.jpa.po.CertificatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class CertificateJpaRepositoryImpl implements CertificateRepository {

    @Autowired
    ICertificateJpaRepository iCertificateJpaRepository;

    public Certificate poToCertificate(CertificatePo po){
        if (po==null){
            return null;
        }
        Long id=po.getId();
        Date expireTime=po.getExpireTime();
        return new Certificate(id,expireTime);
    }

    public CertificatePo certificateToPo(Certificate certificate){
        if(certificate==null){
            return null;
        }
        CertificatePo po=new CertificatePo();
        po.setId(certificate.getId());
        po.setExpireTime(certificate.getExpireTime());
        return po;
    }
}
