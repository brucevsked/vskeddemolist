package com.vsked.pattern1;

/**
 * 懒汉，线程安全
 * @author brucevsked
 *
 */
public class Singleton2 {
	private static Singleton2 instance;
	private Singleton2(){	}
	public static synchronized Singleton2 getInstance(){
		return instance == null?new Singleton2():instance;
	}
}
