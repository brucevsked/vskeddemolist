package com.jat.interceptor;

import com.jat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class ExceptionInterceptor implements Interceptor {
	private static final Logger log = LoggerFactory.getLogger(ExceptionInterceptor.class);

	public void intercept(Invocation ai) {

		try {
			ai.invoke();
		} catch (Exception e) {
			log.error("全局异常：", e);
			Controller c = ai.getController();
			String errorResponse=new Response(500,"操作异常:"+e.getMessage())+"";
			c.renderJson(errorResponse);
		}

	}
}
