package com.vsked.object;

public class Address {

    private String address;

    /**
     * 最小长度
     */
    private final Integer minLength = 10;

    /**
     * 最大长度
     */
    private final Integer maxLength = 50;

    public Address(String type,String address) {
        if (address == null) {
            throw new IllegalArgumentException(type +"地址不能为空！");
        }

        String trimName = address.replace(" ", "");
        if ("".equals(trimName)) {
            throw new IllegalArgumentException(type +"地址不能为空字符串！");
        }

        if (address.length() < minLength) {
            throw new IllegalArgumentException(type +"地址长度过短！长度应为" + minLength + "～" + maxLength + "个字符");
        }

        if (address.length() > maxLength) {
            throw new IllegalArgumentException(type +"地址长度过长！长度应为" + minLength + "～" + maxLength + "个字符");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return address;
    }
}
