package com.vsked.auth.domain.factory;

import com.vsked.auth.domain.aggregate.Account;
import com.vsked.auth.domain.aggregate.Session;
import com.vsked.auth.domain.valueobject.AccountId;
import com.vsked.auth.domain.valueobject.SessionId;
import com.vsked.common.ProjectGlobalSetting;
import java.sql.Timestamp;

public class SessionFactory {

    public static Session createSession(Account account){
        SessionId sessionId=Session.generateSessionId(account);
        Timestamp createTime=new Timestamp(System.currentTimeMillis());
        Timestamp expireTime=new Timestamp(System.currentTimeMillis()+ ProjectGlobalSetting.sessionExpireTime);
        AccountId accountId=account.getAccountId();
        return new Session(sessionId,createTime,expireTime,accountId);
    }
}
