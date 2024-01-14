package com.jat.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import javax.servlet.http.HttpServletResponse;

public class CrossInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        //前台使用 axios.defaults.withCredentials = false;   // axios 默认不发送cookie，需要全局设置true发送cookie
        if(inv.isActionInvocation()){
            Controller c = inv.getController();
            HttpServletResponse response = c.getResponse();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
        }

        inv.invoke();

    }

}
