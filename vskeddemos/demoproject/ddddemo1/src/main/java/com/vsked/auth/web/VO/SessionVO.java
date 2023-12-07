package com.vsked.auth.web.VO;

public class SessionVO {
    /**
     * 会话编号
     */
    private String sessionId;

    /**
     * 账户名称
     */
    private String accountName;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
