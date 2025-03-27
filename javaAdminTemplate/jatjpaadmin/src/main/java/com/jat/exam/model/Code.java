package com.jat.exam.model;

/**
 * 编码
 */
public class Code {
    private String code;

    public Code(String code,String type) {
        if(code==null){
            throw new IllegalArgumentException(type+"编码不能为空！");
        }
        this.code = code;
    }
}
