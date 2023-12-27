package com.jat.demo3;

/**
 * 只第一次懒加载
 */
public class OnlyOne {

    private String key;
    private String value;

    public OnlyOne() {
    }

    public OnlyOne(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OnlyOne{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}'+getClass();
    }
}
