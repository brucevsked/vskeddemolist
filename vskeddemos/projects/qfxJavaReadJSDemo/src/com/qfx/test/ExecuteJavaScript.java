package com.qfx.test;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.qfx.interfaces.JavaScriptInterface;

/**
 * <h5>描述:Java调用JavaScript中函数的测试类</h5>
 * 
 * @author zhangpj	2018年9月6日 
 */
public class ExecuteJavaScript {
	
	public static void main(String[] args) {
		readScriptTest("张三");
	}
	
	public static void readScriptTest(String param){
		ScriptEngineManager manager = new ScriptEngineManager();
		// 1.获取一个JavaScript 引擎实例
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		
		try {
			// 2.获取文件路径
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//            System.out.println(path);
            // 3.执行js脚本,FileReader的参数为所要执行的js文件的路径
            engine.eval(new FileReader(path+ "../static/js/dateUtil.js"));
            engine.eval(new FileReader(path+ "../static/js/main.js"));
            
            // 4.验证engine是否属于Invocable的实例
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                // 5.从脚本引擎中获取JavaScriptInterface接口对象
                JavaScriptInterface executeMethod = invocable.getInterface(JavaScriptInterface.class);
                // 6.调用这个js接口(会去调用js中的相匹配名称的函数)
                String info = executeMethod.sayHello(param);
                System.out.println(info);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
