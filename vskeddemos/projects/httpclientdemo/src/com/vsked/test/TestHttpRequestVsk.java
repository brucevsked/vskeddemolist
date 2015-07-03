package com.vsked.test;

import com.vsked.util.HttpRequestVsk;

public class TestHttpRequestVsk {

	public static void main(String[] args) {
        //发送 GET 请求
        String s=HttpRequestVsk.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
        System.out.println(s);
        
        //发送 POST 请求
        String sr=HttpRequestVsk.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
        System.out.println(sr);
    }
}
