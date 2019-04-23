package com.vsked.pattern1;

/**
 * 懒汉，线程不安全
 * @author brucevsked
 *
 */
public class Singleton1 {
	
	private static Singleton1 instance;
	private Singleton1(){	}
	public static Singleton1 getInstance(){
		return instance == null?new Singleton1():instance;
	}
}
