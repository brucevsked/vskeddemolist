package com.vsked.test.formservice;

import java.lang.reflect.Method;

public class TestFormService {

	public static void main(String[] args) {
		Class<?> c=FormService.class;
		Method[] methods=c.getDeclaredMethods();
		System.out.println("methods count:"+methods.length);
		
		for(Method m:methods){
			NeedTest nt=m.getAnnotation(NeedTest.class);
			if(nt!=null){
				System.out.println(m.getName()+(nt.valuey()?"":"不")+"需要测试");
			}
				
		}
		
	}

}
