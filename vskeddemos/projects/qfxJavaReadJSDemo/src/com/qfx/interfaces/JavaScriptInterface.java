package com.qfx.interfaces;

/**
 * <h5>描述:实现与JavaScript通信的接口</h5>
 * 
 * @author zhangpj	2018年9月6日 
 */
public interface JavaScriptInterface {
	// 方法名要与JavaScript中存在的函数名相同
    public String sayHello(String name);
}
