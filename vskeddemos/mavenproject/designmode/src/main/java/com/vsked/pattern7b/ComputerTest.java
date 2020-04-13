package com.vsked.pattern7b;

/**
 * 2、对象适配器模式
 * @author vsked
 *
 */
public class ComputerTest {

	public static void main(String[] args) {
		Ps2 p=new Adapter(new UDisk());
		p.isPs2();
		//1Ps2接口
		//2适配器 需要传入U盘参数
		//3适配器实现Ps2接口
		//4调用刚才传入的U盘接口方法

	}

}
