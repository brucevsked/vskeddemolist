package com.vsked.pattern1;

/**
 * 饿汉
 * @author brucevsked
 *
 */
public class Singleton3 {
	private static Singleton3 instance=new Singleton3();
	private Singleton3(){	}
	public static Singleton3 getInstance(){
		return instance;
	}
}
