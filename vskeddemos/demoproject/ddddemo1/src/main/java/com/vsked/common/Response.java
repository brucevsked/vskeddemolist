package com.vsked.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Response {

    private static final Logger log = LoggerFactory.getLogger(Response.class);

    private final String code;
    private final String msg;
    private Object data;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        Object data=getData();
        if(log.isDebugEnabled()){
            log.debug(getCode()+getMsg()+data+"");
        }

        if(data==null){
            return "{\"code\":\""+getCode()+"\","+
                    "\"msg\":\""+getMsg()+"\""+
                    "}";
        }else{
            return "{\"code\":\""+getCode()+"\","+
                    "\"msg\":\""+getMsg()+"\","+
                    "\"data\":"+(data)+
                    "}";
        }

    }
}
