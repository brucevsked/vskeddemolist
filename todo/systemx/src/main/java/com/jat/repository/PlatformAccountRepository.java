package com.jat.repository;

import com.jat.bo.PlatformAccount;
import com.jat.bo.PlatformAccountName;

public interface PlatformAccountRepository {
    public Long nextId();
    public PlatformAccount findBy(PlatformAccountName accountName);
}
