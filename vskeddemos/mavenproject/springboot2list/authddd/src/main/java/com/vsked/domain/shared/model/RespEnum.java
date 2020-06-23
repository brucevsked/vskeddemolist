package com.vsked.domain.shared.model;

import com.vsked.domain.shared.web.BaseErrorInfoInterface;

public enum RespEnum implements BaseErrorInfoInterface {
    ServerException("-1","服务器异常",""),
    Success("0","操作成功","")
    ;

    private String code;
    private String msg;
    private String data;

    RespEnum(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getData() {
        return data;
    }
}
