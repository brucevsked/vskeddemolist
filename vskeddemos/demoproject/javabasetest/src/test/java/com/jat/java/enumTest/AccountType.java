package com.jat.java.enumTest;

public enum AccountType {
    nameAndPass(Byte.valueOf("0"),"nameAndPass");

    private Byte id;
    private String name;

    AccountType(Byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public Byte getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public static AccountType findBy(Byte id){
        for(AccountType tmpType:AccountType.values()){
            if(tmpType.id.byteValue()==id.byteValue()){
                return tmpType;
            }
        }
        throw new IllegalArgumentException("无此账号类型编号！");
    }

    public static AccountType findBy(String name){
        for(AccountType tmpType:AccountType.values()){
            if(tmpType.getName().equals(name)){
                return tmpType;
            }
        }
        throw new IllegalArgumentException("无此账号类型名称！");
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
