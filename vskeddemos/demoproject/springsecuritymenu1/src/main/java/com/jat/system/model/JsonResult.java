package com.jat.system.model;

public class JsonResult {

    private final String code;
    private final String msg;
    private Object data;

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String toString() {
        String result="";
        result+="{";

        result+="\"code\":\""+code+"\",";
        result+="\"msg\":\""+msg+"\"";
        if(data!=null){
            result+=",\"data\":"+data+"";
        }
        result+="}";

        return result;
    }
}
