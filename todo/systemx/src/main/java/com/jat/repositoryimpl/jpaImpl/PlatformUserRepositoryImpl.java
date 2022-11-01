package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformUser;
import com.jat.po.PlatformUserPO;
import com.jat.repository.PlatformUserRepository;
import com.jat.repositoryimpl.jpa.IPlatformUserRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.time.LocalDate;

@Repository
public class PlatformUserRepositoryImpl implements PlatformUserRepository {

    @Resource
    private IPlatformUserRepository iPlatformUserRepository;

    public Long nextId() {
        Long id=iPlatformUserRepository.nextId();
        return id==null?1:id;
    }

    public PlatformUser poToBo(PlatformUserPO po){
        if(po==null){
            return null;
        }
        Long id=po.getId();
        String name=po.getName();
        LocalDate birthdayDate=po.getBirthday();
        return new PlatformUser(id,name,birthdayDate);
    }

    public PlatformUserPO boToPo(PlatformUser bo){
        if(bo==null){
            return null;
        }
        return new PlatformUserPO(bo.getId().getId(),bo.getName().getName(),bo.getBirthday().getBirthday());
    }
}
