package com.vsked.tool;

public class Response<T> {

	private Integer code=200;
	private String msg="success";
	private T data;

	public Response() {
	}

	public Response(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Response(Integer code, String msg, T data) {
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

    public String toString() {
        String result="";
        result+="{";

        result+="\"code\":\""+code+"\",";
        result+="\"msg\":\""+msg+"\"";
        if(data!=null){
            result+=",\"data\":"+data;
        }else{
			result+=",\"data\":\"\"";
		}
        result+="}";

        return result;
    }

}
