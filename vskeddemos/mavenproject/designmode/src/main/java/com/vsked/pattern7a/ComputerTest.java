package com.vsked.pattern7a;

/**
 * 1、类适配器模式：
 * @author vsked
 *
 */
public class ComputerTest {

	public static void main(String[] args) {
		Ps2 p=new Adapter();
		p.isPs2();
		
		//1Ps2接口
		//2适配器继承U盘类实现Ps2接口
		//3调用isPs2
		//4通过Adapter类的isPs2适配U盘的isUsb3接口

	}

}
