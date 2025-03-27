package com.jat.util;

import java.util.Map;

public class Response {
	
	private Integer code=0;
	private String msg="success";
	private Object data=null;

	public Response() {
	}

	public Response(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Response(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
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
