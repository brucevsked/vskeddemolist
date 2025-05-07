package com.vsked.jwt;

public class JwtProperties {

    public String getSecretKey() {
        return "shandongyunzecompanydevelope";
    }

    public long getValidityInMs() {
        return 3600000;
    }

}
