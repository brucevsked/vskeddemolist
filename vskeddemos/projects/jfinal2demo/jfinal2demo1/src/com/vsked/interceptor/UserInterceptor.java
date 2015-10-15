package com.vsked.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class UserInterceptor implements Interceptor {

	public void intercept(Invocation iv) {
		iv.invoke();
	}

}
