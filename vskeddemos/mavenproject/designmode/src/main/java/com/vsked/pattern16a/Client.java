package com.vsked.pattern16a;

/**
 * this is 主场景 策略模式
 *
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("离间计干死你");
		UserStategy stategy;
		StrategyInterface detailStrategy=new DetailStrategy();
		stategy = new UserStategy(detailStrategy);
		stategy.action();
		System.out.println("离间成功");
	}
}
