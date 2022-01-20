package com.jat.requestresponse;


public class Response {

    private String requestId;
    private String param;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String toString() {
        return "Response{" +
                "requestId='" + requestId + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
