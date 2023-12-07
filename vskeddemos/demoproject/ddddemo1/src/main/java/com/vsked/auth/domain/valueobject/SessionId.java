package com.vsked.auth.domain.valueobject;

public class SessionId {

    private String sessionId;

    public SessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return sessionId +"";
    }
}
