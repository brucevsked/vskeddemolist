package com.jat.repository;

import com.jat.bo.PlatformAccountName;
import com.jat.bo.PlatformUserAccount;

public interface PlatformUserAccountRepository {

    PlatformUserAccount save(PlatformUserAccount userAccount);
    PlatformUserAccount findBy(PlatformAccountName platformAccountName);

}
