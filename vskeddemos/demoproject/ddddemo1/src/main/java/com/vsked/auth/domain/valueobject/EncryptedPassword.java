package com.vsked.auth.domain.valueobject;

public class EncryptedPassword {

    private String encryptedPassword;

    public EncryptedPassword(String password){
        if(password.equals("")){
            throw new IllegalArgumentException("password cannot be null");
        }
        // TODO password not encrypted.
        this.encryptedPassword = password;
    }

    public boolean verify(String password){
        return encryptedPassword.equals(password);
    }

}
