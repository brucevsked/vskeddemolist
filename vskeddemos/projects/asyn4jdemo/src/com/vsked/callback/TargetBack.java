package com.vsked.callback;

import java.util.Map;

import com.googlecode.asyn4j.core.callback.AsynCallBack;

public class TargetBack extends AsynCallBack{

	private static final long serialVersionUID = -6154035375203594924L;

	@SuppressWarnings("unchecked")
	@Override
	public void doNotify() {
		Map<String, Object> resultData=(Map<String, Object>) this.methodResult;
		System.out.println("|"+resultData+"|");
		
	}

}
