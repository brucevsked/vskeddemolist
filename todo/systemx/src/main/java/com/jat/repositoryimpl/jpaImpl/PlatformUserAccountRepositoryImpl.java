package com.jat.repositoryimpl.jpaImpl;

import com.jat.bo.PlatformUserAccount;
import com.jat.repository.PlatformUserAccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PlatformUserAccountRepositoryImpl implements PlatformUserAccountRepository {

    @Override
    public PlatformUserAccount save(PlatformUserAccount userAccount) {
        return null;
    }
}
