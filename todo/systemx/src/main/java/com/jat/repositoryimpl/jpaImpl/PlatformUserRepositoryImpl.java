package com.jat.repositoryimpl.jpaImpl;

import com.jat.repository.PlatformUserRepository;
import com.jat.repositoryimpl.jpa.IPlatformUserRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class PlatformUserRepositoryImpl implements PlatformUserRepository {

    @Resource
    private IPlatformUserRepository iPlatformUserRepository;

    public Long nextId() {
        return iPlatformUserRepository.nextId();
    }
}
