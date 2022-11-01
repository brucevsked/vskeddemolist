package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformAccountName;
import com.jat.po.PlatformAccountPO;
import com.jat.repository.PlatformAccountRepository;
import com.jat.repositoryimpl.jpa.IPlatformAccountRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class PlatformAccountRepositoryImpl implements PlatformAccountRepository {

    @Resource
    private IPlatformAccountRepository iPlatformAccountRepository;


    public Long nextId() {
        Long id=iPlatformAccountRepository.nextId();
        return id==null?1:id;
    }

    @Override
    public PlatformAccount findBy(PlatformAccountName platformAccountName) {
        PlatformAccountPO po= iPlatformAccountRepository.findByName(platformAccountName.getName()).orElse(null);
        return poToBo(po);
    }

    public PlatformAccount poToBo(PlatformAccountPO po){
        if(po==null){
            return null;
        }

        return new PlatformAccount(po.getId(),po.getName(),po.getPassword());
    }

    public PlatformAccountPO boToPo(PlatformAccount bo){
        if(bo==null){
            return null;
        }
        return new PlatformAccountPO(bo.getId().getId(),bo.getName().getName(),bo.getPassword().getPassword());
    }

}
