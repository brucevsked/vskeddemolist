package com.jat.service;

import com.jat.manager.PlatformIdManager;

public class PlatformIdService {

    private PlatformIdManager platformIdManager;

    public void setPlatformIdManager(PlatformIdManager platformIdManager) {
        this.platformIdManager = platformIdManager;
    }

    public Long nextAccountId(){
        return platformIdManager.nextAccountId();
    }

    public Long nextUserId(){
        return platformIdManager.nextUserId();
    }


}
