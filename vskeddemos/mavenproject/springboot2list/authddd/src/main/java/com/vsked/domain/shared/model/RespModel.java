package com.vsked.domain.shared.model;

import java.io.Serializable;

public class RespModel implements Serializable {
    /**
     * 响应编码
     */
    private String code;
    /**
     * 响应消息内容
     */
    private String msg;
    /**
     * 响应数据
     */
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public RespModel() {
    }

    public RespModel(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code +
                "\", \"msg\":\"" + msg +
                "\", \"data\":\"" + data +
                "\"}";
    }
}
