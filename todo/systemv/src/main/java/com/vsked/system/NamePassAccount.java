package com.vsked.system;

public class NamePassAccount implements Account{
    private AccountName name;
    private AccountPass pass;

    public NamePassAccount(AccountName name, AccountPass pass) {
        if(name==null){
            throw new IllegalArgumentException("account name not be null！");
        }
        if(pass==null){
            throw new IllegalArgumentException("account pass not be null！");
        }
        this.name = name;
        this.pass = pass;
    }

    public AccountName getName() {
        return name;
    }

    public AccountPass getPass() {
        return pass;
    }

    public void validate(Account account) {
        if(account instanceof NamePassAccount){
            NamePassAccount tmpAccount= (NamePassAccount) account;
            if(!name.getName().equals(tmpAccount.getName().getName())){
                throw new IllegalArgumentException("account name wrong！");
            }
            if(!pass.getPass().equals(tmpAccount.getPass().getPass())){
                throw new IllegalArgumentException("account pass wrong！");
            }
        }else{
            throw new IllegalArgumentException("account type error，not NamePass account！");
        }

    }

    public String toString() {
        return "{" +
                "name=" + name  +
                ", pass=" + pass  +
                "}";
    }
}
