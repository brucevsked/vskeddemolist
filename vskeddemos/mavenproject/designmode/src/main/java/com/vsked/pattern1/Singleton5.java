package com.vsked.pattern1;

/**
 * 双重校验锁 jdk1.5+
 * @author brucevsked
 *
 */
public class Singleton5 {
	private volatile static Singleton5 instance=new Singleton5();
	private Singleton5(){	}
	public static Singleton5 getInstance(){
		if(instance==null){
			synchronized(Singleton5.class){
				if(instance==null){
					instance=new Singleton5();
				}
			}
		}
		return instance;
	}
}
